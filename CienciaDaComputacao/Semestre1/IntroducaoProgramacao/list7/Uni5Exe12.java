package list7;

import java.util.Scanner;

public class Uni5Exe12 {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {

            int n = sc.nextInt();
            int numero = 1;

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= i; j++) {
                    System.out.print(numero + " ");
                    numero++;
                }
                System.out.println();
            }
        }
    }
}
