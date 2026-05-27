package unit7.ExemploJogador;

public class Jogador {

    String nome;
    int pontuacao;

    public Jogador(String nome, int pontuacao) {
        this.nome = nome;
        this.pontuacao = pontuacao;
    }

    public boolean eDestaque() {
        if (pontuacao >= 1000) {
            return true;
        } else {
            return false;
        }
    }

    public void exibir(int posicao) {
        String asterisco = "";
        if (eDestaque()) {
            asterisco = "*";
        }
        System.out.println("Posição: " + posicao + " -> Nome: " + nome + asterisco + " -> Pontuação: " + pontuacao);
    }
}
