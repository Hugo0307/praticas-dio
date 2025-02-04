package main.java.iphone.model;

import main.java.iphone.service.AparelhoTelefonico;
import main.java.iphone.service.NavegadorInternet;
import main.java.iphone.service.ReprodutorMusical;

public class IPhone {

    private AparelhoTelefonico aparelhoTelefonico;
    private NavegadorInternet navegadorInternet;
    private ReprodutorMusical reprodutorMusical;

    public IPhone() {
        this.aparelhoTelefonico = new AparelhoTelefonico();
        this.navegadorInternet = new NavegadorInternet();
        this.reprodutorMusical = new ReprodutorMusical();
    }

    public void desbloquear() {
        System.out.println("Bem vindo!");
    }

    public void bloquear() {
        System.out.println("Até logo!");
    }

    public void ligar(String numero) {
        aparelhoTelefonico.ligar(numero);
    }

    public void atender() {
        aparelhoTelefonico.atender();
    }

    public void iniciarCorreioVoz() {
        aparelhoTelefonico.iniciarCorreioVoz();
    }

    public void exibirPagina(String url) {
        navegadorInternet.exibirPagina(url);
    }

    public void adicionarNovaAba() {
        navegadorInternet.adicionarNovaAba();
    }

    public void atualizarPagina() {
        navegadorInternet.atualizarPagina();
    }

    public void tocar() {
        reprodutorMusical.tocar();
    }

    public void pausar() {
        reprodutorMusical.pausar();
    }

    public void selecionarMusica(String musica) {
        reprodutorMusical.selecionarMusica(musica);
    }

}
