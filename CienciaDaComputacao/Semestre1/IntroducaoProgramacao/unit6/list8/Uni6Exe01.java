package unit6.list8;

import java.util.Scanner;

public class Uni6Exe01 {

    public static void main(String[] args) {

        int[] valor = new int[5];

        lerValores(valor);
        escreverInverso(valor);
    }

    public static void lerValores(int[] valor) {
        try (Scanner sc = new Scanner(System.in)) {

            for (int i = 0; i < valor.length; i++) {
                System.out.print("Valor " + (i + 1) + ": ");
                valor[i] = sc.nextInt();
            }
        }
    }

    public static void escreverInverso(int[] valor) {
        System.out.print("Vetor Invertido: ");
        for (int i = valor.length - 1; i >= 0; i--) {
            System.out.print("[" + valor[i] + "]");
        }
    }
}
