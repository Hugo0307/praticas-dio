import java.util.Locale;
import java.util.Scanner;

public class ContaTerminal {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        System.out.println("Digite o nome do titular da conta:");
        String nomeCliente = scanner.nextLine();

        System.out.println("Digite o saldo inicial da conta: ex.: 000.00");
        double saldo = scanner.nextDouble();

        System.out.println("Digite o número da agência:");
        int agencia = scanner.nextInt();

        System.out.println("Digite o número da conta:");
        int numero = scanner.nextInt();

        System.out.printf("Olá %s, obrigado por criar uma conta em nosso banco, "+ 
        "sua agência é %d, conta %d e seu saldo %.2f já está disponível para saque",
        nomeCliente, agencia, numero, saldo);

        scanner.close();
    }
}
