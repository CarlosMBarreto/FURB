package unit6;

import java.util.Scanner;

public class Uni6Exe04 {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {

            int[] v1 = new int[10];
            int[] v2 = new int[10];
            int[] v3 = new int[10];

            for (int i = 0; i < v1.length; i++) {
                v1[i] = sc.nextInt();
            }
            for (int i = 0; i < v2.length; i++) {
                v2[i] = sc.nextInt();
            }
            for (int i = 0; i < v3.length; i++) {
                v3[i] = v1[i] + v2[i];
            }

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
}
