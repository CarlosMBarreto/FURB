package list4;

import java.util.Scanner;

public class Exe1010 {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {

            @SuppressWarnings("unused")
            int codigoP1 = sc.nextInt(), numeroPecasP1 = sc.nextInt();
            double precoUnidadeP1 = sc.nextDouble();

            @SuppressWarnings("unused")
            int codigoP2 = sc.nextInt(), numeroPecasP2 = sc.nextInt();
            double precoUnidadeP2 = sc.nextDouble();

            double total = (numeroPecasP1 * precoUnidadeP1) + (numeroPecasP2 * precoUnidadeP2);

            System.out.printf("VALOR A PAGAR: R$ %.2f\n", total);
        }
    }
}
