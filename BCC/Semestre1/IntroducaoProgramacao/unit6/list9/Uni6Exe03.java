package unit6.list9;

import java.util.Scanner;

public class Uni6Exe03 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int matriz1[][] = new int[3][3];
        int matriz2[][] = new int[3][3];

        lerMatriz(matriz1, matriz2, sc);
        multiplicarMatriz(matriz1, matriz2);
        System.out.println("---Matriz multiplicada---");
        escreverMatriz(matriz1, matriz2);
    }

    public static void lerMatriz(int matriz1[][], int matriz2[][], Scanner sc) {

        for (int lin = 0; lin < matriz1.length; lin++) {
            for (int col = 0; col < matriz1[lin].length; col++) {
                matriz1[lin][col] = sc.nextInt();
            }
        }

        for (int lin = 0; lin < matriz2.length; lin++) {
            for (int col = 0; col < matriz2[lin].length; col++) {
                matriz2[lin][col] = sc.nextInt();
            }
        }
    }

    public static void multiplicarMatriz(int matriz1[][], int matriz2[][]) {

        for (int lin = 0; lin < matriz1.length; lin++) {
            for (int col = 0; col < matriz1[lin].length; col++) {
                matriz1[lin][col] = matriz1[lin][col] * matriz2[lin][col];
            }
        }
    }

    public static void escreverMatriz(int matriz1[][], int matriz2[][]) {
        for (int lin = 0; lin < matriz1.length; lin++) {
            for (int col = 0; col < matriz1[lin].length; col++) {
                System.out.print("[" + matriz1[lin][col] + "]");
            }
            System.out.println();
        }
    }
}
