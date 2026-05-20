package unit6.list9;

import java.util.Scanner;

public class Uni6Exe01 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int matriz[][] = new int[4][4];

        lerMatriz(matriz, sc);
        escreverMatriz(matriz, sc);

    }

    public static void lerMatriz(int matriz[][], Scanner sc) {
        for (int lin = 0; lin < matriz.length; lin++) {
            for (int col = 0; col < matriz[lin].length; col++) {
                System.out.print("Informe o " + (col + 1) + "º número(" + (lin + 1) + "ª linha): ");
                matriz[lin][col] = sc.nextInt();
            }
        }
    }

    public static void escreverMatriz(int matriz[][], Scanner sc) {
        System.out.print("Matriz diagonal principal: ");
        for (int lin = 0; lin < matriz.length; lin++) {
            for (int col = 0; col < matriz[lin].length; col++) {
                if (lin == col) {
                    System.out.print("[" + matriz[lin][col] + "]");
                }
            }
        }
    }
}

// a
