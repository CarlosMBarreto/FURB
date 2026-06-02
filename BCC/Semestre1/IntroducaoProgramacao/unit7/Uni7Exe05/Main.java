package unit7.Uni7Exe05;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int tabela[][] = new int[4][3];
        Jogador jogadores[] = new Jogador[4];

        System.out.println("=== CADASTRO ===");

        for (int i = 0; i < jogadores.length; i++) {
            System.out.print("Jogador " + (i + 1) + " - Nome: ");
            String nome = sc.nextLine();

            jogadores[i] = new Jogador(nome);

            for (int rodada = 0; rodada < 3; rodada++) {
                System.out.print("Rodada " + (rodada + 1) + ": ");
                int pontos = sc.nextInt();

                jogadores[i].registrarPontos(rodada, pontos);

                tabela[i][rodada] = pontos;
            }
            sc.nextLine();
        }

        int opcao = 0;

        do {
            System.out.println("1 - Tabela geral");
            System.out.println("2 - Ranking final");
            System.out.println("3 - Buscar jogador");
            System.out.println("0 - Sair");
            System.out.print("Opcao: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:

                    System.out.println("\n=== TABELA GERAL ===");
                    System.out.println("Jogador\t|R1\t|R2\t|R3\t|Total");

                    for (int j = 0; j < jogadores.length; j++) {
                        System.out.print(jogadores[j].nome + "\t|");
                        for (int r = 0; r < tabela[j].length; r++) {
                            System.out.print(tabela[j][r] + "\t|");
                        }
                        System.out.println(jogadores[j].totalPontos());
                    }
                    break;
                case 2:
                    System.out.println("=== RANKING FINAL ===");

                    int campeao = 0;
                    int i = 1;

                    while (i < jogadores.length) {
                        if (jogadores[i].totalPontos() > jogadores[campeao].totalPontos()) {
                            campeao = i;
                        }
                        i++;
                    }

                    for (i = 0; i < jogadores.length; i++) {

                        System.out.print(jogadores[i].nome);
                        System.out.print(" - Total: " + jogadores[i].totalPontos());
                        System.out.printf(" - Media: %.2f", jogadores[i].mediaPontos());
                        System.out.print(" - Melhor Rodada: " + jogadores[i].melhorRodada());
                        System.out.print(" - " + jogadores[i].classificacao());
                        if (i == campeao) {
                            System.out.print("🏆 CAMPEÃO");
                        }
                        System.out.println();
                    }
                    break;
                case 3:
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();

                    boolean encontrou = false;

                    i = 0;

                    while (i < jogadores.length && !encontrou) {

                        if (jogadores[i].nome.equalsIgnoreCase(nome)) {
                            encontrou = true;
                        } else {
                            i++;
                        }

                    }

                    if (!encontrou) {
                        System.out.println("Jogador não encontrado.");
                    }

                    if (encontrou) {

                        System.out.println("=== DETALHES ===");
                        System.out.println("Nome: " + jogadores[i].nome);

                        int p[] = jogadores[i].pontuacao;

                        System.out.print("Rodadas: ");
                        for (int j = 0; j < p.length; j++) {

                            System.out.print(p[j]);

                            if (j < p.length - 1) {
                                System.out.print(" | ");
                            }

                        }

                        System.out.println();

                        System.out.print("Total: " + jogadores[i].totalPontos());
                        System.out.printf(" | Media: %.2f\n", jogadores[i].mediaPontos());
                        System.out.println("Melhor rodada: " + jogadores[i].melhorRodada());
                        System.out.println("Classificacao: " + jogadores[i].classificacao());
                    }
                    break;
                case 0:
                    System.out.println("Fim do torneio!");
                    break;

                default:
                    System.out.println("Opcao Invalida.(" + opcao + ")");
            }
        } while (opcao != 0);
    }
}
