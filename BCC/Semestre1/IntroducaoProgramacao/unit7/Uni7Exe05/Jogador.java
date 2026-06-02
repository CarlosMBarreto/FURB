package unit7.Uni7Exe05;

public class Jogador {
    String nome;
    int[] pontuacao;

    public Jogador(String nome) {
        this.nome = nome;
        this.pontuacao = new int[3];
    }

    public void registrarPontos(int rodada, int pontos) {
        if (rodada < 0 || rodada > pontuacao.length) {
            System.out.println("Rodada invalida.");
        } else {
            pontuacao[rodada] = pontos;
        }
    }

    public int totalPontos() {
        int soma = 0;
        for (int i = 0; i < pontuacao.length; i++) {
            soma += pontuacao[i];
        }
        return soma;
    }

    public double mediaPontos() {
        return (double) totalPontos() / pontuacao.length;
    }

    public int melhorRodada() {
        int melhor = 0;

        for (int i = 1; i < pontuacao.length; i++) {
            if (pontuacao[i] > pontuacao[melhor]) {
                melhor = i;
            }
        }
        return melhor + 1;
    }

    public String classificacao() {
        int total = totalPontos();

        if (total >= 2500) {
            return "Ouro 🥇";
        } else if (total >= 1500) {
            return "Prata 🥈";
        } else if (total >= 800) {
            return "Bronze 🥉";
        } else {
            return "Sem classificação";
        }
    }
}
