package unit7.ExemploJogador;

public class Ranking {
    Jogador[] jogadores;

    public Ranking() {
        jogadores = new Jogador[5];
    }

    public void registrar(int posicao, String nome, int pontuacao) {
        if (posicao >= 1 && posicao <= 5) {
            Jogador j = new Jogador(nome, pontuacao);
            jogadores[posicao - 1] = j;
        } else {
            System.out.println("Posição inválida.");
        }
    }

    public void exibirRanking() {
        for (int i = 0; i < jogadores.length; i++) {
            Jogador jog = jogadores[i];
            if (jog != null) {
                jog.exibir(i + 1);
            } else {
                System.out.println("-- vazio --");
            }
        }
    }
}
