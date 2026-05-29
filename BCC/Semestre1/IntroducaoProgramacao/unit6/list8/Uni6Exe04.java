package unit6.list8;

import java.util.Scanner;

public class Uni6Exe04 {

    public static void main(String[] args) {
        int[] v1 = new int[3];
        int[] v2 = new int[3];
        int[] v3 = new int[3];

        lerValores(v1, v2);
        somaVetores(v1, v2, v3);
        escreverValores(v1, v2, v3);
    }

    public static void lerValores(int[] v1, int[] v2) {
        try (Scanner sc = new Scanner(System.in)) {
            for (int i = 0; i < v1.length; i++) {
                v1[i] = sc.nextInt();
            }
            for (int i = 0; i < v2.length; i++) {
                v2[i] = sc.nextInt();
            }

        }
    }

    public static void somaVetores(int[] v1, int[] v2, int[] v3) {
        for (int i = 0; i < v3.length; i++) {
            v3[i] = v1[i] + v2[i];
        }
    }

    public static void escreverValores(int[] v1, int[] v2, int[] v3) {
        System.out.print("Vetor1 = ");
        for (int i = 0; i < v1.length; i++) {
            System.out.print("[" + v1[i] + "]");
        }
        System.out.print("\nVetor2 = ");
        for (int i = 0; i < v2.length; i++) {
            System.out.print("[" + v2[i] + "]");
        }
        System.out.print("\nVetor3 = ");
        for (int i = 0; i < v3.length; i++) {
            System.out.print("[" + v3[i] + "]");
        }
    }
}
