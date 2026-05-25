package unit6.list9;

import java.util.Scanner;

public class Uni6Exe05 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String velha[][] = new String[3][3];

        for (int lin = 0; lin < velha.length; lin++) {
            for (int col = 0; col < velha[lin].length; col++) {
                velha[lin][col] = " ";
            }
        }

        int opcao = 0;
        String jogadorAtual = "X";
        boolean vencedor = false;

        do {

            System.out.println("\n--- MENU ---");
            System.out.println("1 --> Jogar");
            System.out.println("2 --> Exibir tabuleiro");
            System.out.println("3 --> Sair");
            System.out.print("Opcao: ");
            opcao = sc.nextInt();

            switch (opcao) {

                case 1:

                    jogar(velha, sc, jogadorAtual);

                    exibirTabuleiro(velha);

                    vencedor = verificarVencedor(velha);

                    if (vencedor) {
                        System.out.println("VENCEU: " + jogadorAtual);
                        break;
                    }

                    if (verificarVelha(velha)) {
                        System.out.println("DEU VELHA!");
                        break;
                    }

                    if (jogadorAtual.equals("X")) {
                        jogadorAtual = "O";
                    } else {
                        jogadorAtual = "X";
                    }

                    break;

                case 2:
                    exibirTabuleiro(velha);
                    break;

                case 3:
                    Sair();
                    break;

                default:
                    System.out.println("Opcao invalida.");
            }

        } while (opcao != 3 && !vencedor);

        sc.close();
    }

    public static void jogar(String velha[][], Scanner sc, String jogadorAtual) {

        int linha;
        int coluna;

        do {

            System.out.print("Informe a linha (0-2): ");
            linha = sc.nextInt();

            System.out.print("Informe a coluna (0-2): ");
            coluna = sc.nextInt();

            if (linha < 0 || linha > 2 || coluna < 0 || coluna > 2) {
                System.out.println("Posicao invalida.");
                continue;
            }

            if (!velha[linha][coluna].equals(" ")) {
                System.out.println("Posicao ocupada.");
            }

        } while (linha < 0 || linha > 2 ||
                coluna < 0 || coluna > 2 ||
                !velha[linha][coluna].equals(" "));

        velha[linha][coluna] = jogadorAtual;
    }

    public static void exibirTabuleiro(String velha[][]) {

        System.out.println("\n--- TABULEIRO ---");

        for (int lin = 0; lin < velha.length; lin++) {

            for (int col = 0; col < velha[lin].length; col++) {
                System.out.print("[" + velha[lin][col] + "]");
            }

            System.out.println();
        }
    }

    public static boolean verificarVencedor(String velha[][]) {

        for (int lin = 0; lin < velha.length; lin++) {

            if (!velha[lin][0].equals(" ")
                    && velha[lin][0].equals(velha[lin][1])
                    && velha[lin][1].equals(velha[lin][2])) {
                return true;
            }
        }

        for (int col = 0; col < velha[0].length; col++) {

            if (!velha[0][col].equals(" ")
                    && velha[0][col].equals(velha[1][col])
                    && velha[1][col].equals(velha[2][col])) {
                return true;
            }
        }

        if (!velha[0][0].equals(" ")
                && velha[0][0].equals(velha[1][1])
                && velha[1][1].equals(velha[2][2])) {
            return true;
        }

        if (!velha[0][2].equals(" ")
                && velha[0][2].equals(velha[1][1])
                && velha[1][1].equals(velha[2][0])) {
            return true;
        }

        return false;
    }

    public static boolean verificarVelha(String velha[][]) {

        for (int lin = 0; lin < velha.length; lin++) {
            for (int col = 0; col < velha[lin].length; col++) {

                if (velha[lin][col].equals(" ")) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void Sair() {
        System.exit(0);
    }
}