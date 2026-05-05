package list7;

import java.util.Scanner;

public class Uni5Exe13 {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Número total de reabastecimentos: ");
            int numRea = sc.nextInt();

            double mediaLitros = 0;
            double kmMedioLitros = 0;

            for (int i = 1; i <= numRea; i++) {
                System.out.print("Parada " + i + ": ");
                System.out.print("Quilometragem: ");
                double quilometragem = sc.nextDouble();
                System.out.print("Combustível: ");
                double combustivel = sc.nextDouble();

                mediaLitros = quilometragem / combustivel;

                System.out.println("Parada " + i + ": " + mediaLitros + " km por litro");

                kmMedioLitros += mediaLitros / numRea;
            }

            System.out.println("Quilometragem média obtida: " + kmMedioLitros);
        }
    }
}
