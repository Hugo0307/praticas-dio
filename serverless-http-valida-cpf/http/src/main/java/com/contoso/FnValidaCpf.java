package com.contoso;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microsoft.azure.functions.ExecutionContext;
import com.microsoft.azure.functions.HttpMethod;
import com.microsoft.azure.functions.HttpRequestMessage;
import com.microsoft.azure.functions.HttpResponseMessage;
import com.microsoft.azure.functions.HttpStatus;
import com.microsoft.azure.functions.annotation.AuthorizationLevel;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.HttpTrigger;

import java.util.Optional;

/**
 * Azure Functions with HTTP Trigger.
 */
public class FnValidaCpf {
    @FunctionName("fvValidaCpf")
    public HttpResponseMessage runPost(
            @HttpTrigger(
                name = "req",
                methods = {HttpMethod.POST},
                authLevel = AuthorizationLevel.FUNCTION)
                HttpRequestMessage<Optional<String>> request,
            final ExecutionContext context) {
        context.getLogger().info("Iniciando a validação do CPF.");

        String cpf;
        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode jsonNode = mapper.readTree(request.getBody().orElse("{}"));
            cpf = Optional.ofNullable(jsonNode.get("cpf")).map(JsonNode::asText).orElse(null);
            if (cpf == null || cpf.isEmpty() || !validaCpf(cpf)) {
                return request.createResponseBuilder(HttpStatus.BAD_REQUEST)
                        .body("Por favor, informe um CPF válido.").build();
            }

            context.getLogger().info("CPF válido.");
        } catch (Exception e) {
            context.getLogger().severe("Error parsing request body: " + e.getMessage());
            return request.createResponseBuilder(HttpStatus.BAD_REQUEST)
                    .body("Error parsing request body").build();
        }

        return request.createResponseBuilder(HttpStatus.OK).body("CPF ok!").build();
    }

    private boolean validaCpf(String cpf) {
        if (cpf == null) {
            return false;
        }
    
        cpf = cpf.replaceAll("[^\\d]", "");
    
        if (cpf.length() != 11 || cpf.matches("(\\d)\\1{10}")) {
            return false;
        }

        try {
            int sum = 0;
            for (int i = 0; i < 9; i++) {
                sum += Character.getNumericValue(cpf.charAt(i)) * (10 - i);
            }
            int firstCheckDigit = 11 - (sum % 11);
            if (firstCheckDigit >= 10) {
                firstCheckDigit = 0;
            }

            sum = 0;
            for (int i = 0; i < 10; i++) {
                sum += Character.getNumericValue(cpf.charAt(i)) * (11 - i);
            }
            int secondCheckDigit = 11 - (sum % 11);
            if (secondCheckDigit >= 10) {
                secondCheckDigit = 0;
            }

            return firstCheckDigit == Character.getNumericValue(cpf.charAt(9)) &&
                   secondCheckDigit == Character.getNumericValue(cpf.charAt(10));
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
