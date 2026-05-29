package unit5.list7;

import java.util.Scanner;

public class Uni5Exe16 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {

            double altura, somaMulheres = 0, somaTotal = 0;
            int contMulheres = 0, contTotal = 0;

            while (true) {
                System.out.print("Altura: ");
                altura = sc.nextDouble();

                if (altura == 0) break;

                System.out.print("Genero: ");
                char g = sc.next().charAt(0);

                somaTotal += altura;
                contTotal++;

                if (g == 'F' || g == 'f') {
                    somaMulheres += altura;
                    contMulheres++;
                }
            }

            if (contMulheres > 0)
                System.out.printf("Média mulheres: %.2f\n", somaMulheres / contMulheres);

            if (contTotal > 0)
                System.out.printf("Média grupo: %.2f\n", somaTotal / contTotal);
        }
    }
}