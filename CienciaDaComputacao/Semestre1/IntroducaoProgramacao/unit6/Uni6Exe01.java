package unit6;

import java.util.Scanner;

public class Uni6Exe01 {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {

            int[] n = new int[3];
            String inverso = "";

            for (int i = 0; i < n.length; i++) {
                System.out.print("Informe o " + (i + 1) + "º número: ");
                n[i] = sc.nextInt();
            }

            for (int i = 0; i < n.length; i++) {
                inverso += n[i - 1] + " ";
            }

            System.out.println(inverso);
        }
    }
}
