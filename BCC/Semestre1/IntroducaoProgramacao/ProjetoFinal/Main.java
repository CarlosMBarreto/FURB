package ProjetoFinal;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String sala[][] = new String[10][10];

        int opcao = 0;

        do {
            System.out.println("   === MENU ===");
            System.out.println("1 - Visualizar sala");
            System.out.println("2 - Comprar ingresso");
            System.out.println("3 - Resumo");
            System.out.println("0 - Encerrar");
            System.out.print("Opção: ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    mostrarSala(sala);
                    break;

                case 2:
                    System.out.print("Fila: ");
                    int fila = sc.nextInt();

                    System.out.print("Poltrona: ");
                    int poltrona = sc.nextInt();

                    System.out.print("Tipo: [1]Inteira - [2]Meia: ");
                    int tipo = sc.nextInt();

                    
                    break;

                case 3:
                    break;

                case 0:
                    System.out.println("Encerrando...");
                    break;

                default:
                    System.out.println("Opção Incorreta.");
                    break;
            }
        } while (opcao != 0);

    }

    public static void mostrarSala(String sala[][]) {

        Random rand = new Random();

        int preenchidos = 0;
        int ingressosVendidos = 0;
        double bilheteria = 150.6789;
        int ocupacao = 0;

        System.out.println("===== Cine Campus - Totem de autoatendimento =====");
        System.out.print("Ingressos vendidos: " + ingressosVendidos + "\t");
        System.out.printf("Bilheteria: %.2f", bilheteria);
        System.out.println("\tOcupação: " + ocupacao + "%");

        System.out.println("  0  1  2  3  4  5  6  7  8  9");

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
            System.out.print(i);
            for (int j = 0; j < sala[i].length; j++) {
                if (!sala[i][j].equals("#")) {
                    System.out.print("[" + "-" + "]");
                } else {
                    System.out.print("[" + sala[i][j] + "]");
                }
            }
            System.out.println();
        }
        System.out.println(" ------------ TELA ------------  \n\n");
    }
}
