import main.java.iphone.model.IPhone;

public class IPhoneApp {
    public static void main(String[] args) {

        IPhone iPhone = new IPhone();

        iPhone.desbloquear();

        iPhone.ligar("123456789");
        iPhone.atender();
        iPhone.iniciarCorreioVoz();

        iPhone.exibirPagina("www.google.com");
        iPhone.adicionarNovaAba();
        iPhone.atualizarPagina();

        iPhone.tocar();
        iPhone.pausar();
        iPhone.selecionarMusica("Stairway to Heaven");

        iPhone.bloquear();
    }
}
