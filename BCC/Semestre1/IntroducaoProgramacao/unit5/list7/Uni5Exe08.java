package unit5.list7;

import java.util.Scanner;

public class Uni5Exe08 {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {

            int n = sc.nextInt();
            double menorNegativo = Double.MAX_VALUE;
            double mediaPositivo = 0;
            double somaPositivo = 0;
            double numero = 0;
            int p = 0;

            for (int i = 1; i <= n; i++) {
                System.out.print("Informe o " + i + "º número: ");
                numero = sc.nextDouble();

                if (numero >= 0) {
                    p++;
                    somaPositivo += numero;
                } else {
                    if (numero < menorNegativo) {
                        menorNegativo = numero;
                    }
                }
                mediaPositivo = somaPositivo / p;
            }
            System.out.printf("Menor valor negativo: %.2f", menorNegativo);
            System.out.printf("\nMédia dos números positivos: %.2f", mediaPositivo);
        }
    }
}
