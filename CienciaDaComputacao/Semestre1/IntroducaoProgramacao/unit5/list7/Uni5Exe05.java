package unit5.list7;

import java.util.Scanner;

public class Uni5Exe05 {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {

            int n = sc.nextInt();

            int valor = 8;

            if (n < 2) {
                System.out.println("Valor mínimo aceito: 3");
            } else {

                for (int i = 1; i <= n; i++) {

                    if (i % 2 == 0) {
                        valor += 2;
                    } else {
                        valor *= 2;
                    }
                }
            }
        }
    }
}
