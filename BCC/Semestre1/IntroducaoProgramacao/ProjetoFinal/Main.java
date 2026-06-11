package BCC.Semestre1.IntroducaoProgramacao.ProjetoFinal;

import java.util.Scanner;

import java.util.Random;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String sala[][] = new String[10][10];

        int opcao = 0;

        do {
            System.out.println("   === MENU ===\n");
            System.out.println("1 - Visualizar sala");
            System.out.println("2 - Comprar ingresso");
            System.out.println("3 - Sair");
            System.out.print("Opção: ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    mostrarSala(sala);
                    break;

                default:
                    break;
            }
        } while (opcao != 0);

    }

    public static void mostrarSala(String sala[][]) {

        Random rand = new Random();

        int preenchidos = 0;

        char linha[] = { 'J', 'I', 'H', 'G', 'F', 'E', 'D', 'C', 'B', 'A' };

        System.out.println("       === Cine Campus ===");

        System.out.println("   0  1  2  3  4  5  6  7  8  9");

        for (int i = 0; i < sala.length; i++) {
            for (int j = 0; j < sala[i].length; j++) {
                sala[i][j] = " ";
            }
        }

        while (preenchidos < 15) {
            int lin = rand.nextInt(sala.length);
            int col = rand.nextInt(sala[0].length);

            if (sala[lin][col] == " ") {
                sala[lin][col] = "#";
            }
            preenchidos++;
        }

        for (int i = 0; i < sala.length; i++) {
            System.out.print(linha[i] + " ");
            for (int j = 0; j < sala[i].length; j++) {
                if (!sala[i][j].equals("#")) {
                    System.out.print("[" + "-" + "]");
                } else {
                    System.out.print("[" + sala[i][j] + "]");
                }
            }
            System.out.println();
        }
        System.out.println("  ------------ TELA ------------  \n\n");
    }
}
