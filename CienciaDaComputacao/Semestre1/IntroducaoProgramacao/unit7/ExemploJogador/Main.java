package unit7.ExemploJogador;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Ranking ranking = new Ranking();

        int menu = 0;

        do {
            System.out.println("1 -> Inserir Jogador");
            System.out.println("2 -> Exibir Ranking");
            System.out.println("0 -> Sair");
            System.out.print("Opção:");
            menu = sc.nextInt();

            switch (menu) {

                case 1:
                    System.out.print("Digite a posição do jogador: ");
                    int posicao = sc.nextInt();

                    System.out.print("Digite o nome do jogador: ");
                    String nome = sc.next();

                    System.out.print("Digite a pontuação do jogador: ");
                    int pontuacao = sc.nextInt();

                    ranking.registrar(posicao, nome, pontuacao);
                    break;
                case 2:
                    ranking.exibirRanking();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida.");
            }

        } while (menu != 0);
        sc.close();
    }
}
