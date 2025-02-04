package main.java.iphone.service;

public class AparelhoTelefonico {

    public void ligar(String numero) {
        System.out.println(String.format("Ligando para %s...", numero));
    }

    public void atender() {
        System.out.println("Atendendo chamada...");
    }

    public void iniciarCorreioVoz() {
        System.out.println("Correio de voz iniciado");
    }

}
