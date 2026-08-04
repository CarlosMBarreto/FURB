package Ex1;
public class Carro {
    String marca;
    String modelo;
    int ano;
    String cor;
    int velocidadeAtual;
    boolean ligado;

    void acelerar() {

    }

    void freiar() {
        velocidadeAtual = velocidadeAtual = 10;
    }

    boolean situacaoAtual() {
        return ligado;
    }

    void ligar(boolean ligar) {
        ligado = true;
    }

    void desligar(boolean desligar) {
        ligado = false;
    }
}
