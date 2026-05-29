package unit6.list8;

import java.util.Scanner;

public class Uni6Exe08 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = 0;

        do {
            System.out.print("Informe o tamanho no vetor: ");
            n = sc.nextInt();
            if (n > 20) {
                System.out.println("Capacidade além da permitida(20): ");
            }
        } while (n > 20);

        double vet[] = new double[n];

        inserirValores(vet, sc);
        frequencia(vet);

    }

    public static void inserirValores(double[] vet, Scanner sc) {
        for (int i = 0; i < vet.length; i++) {
            System.out.print("Valor " + (i + 1) + ": ");
            vet[i] = sc.nextInt();
        }
    }

    public static void frequencia(double[] vet) {

        System.out.println("Valor   |   Frequência");

        for (int i = 0; i < vet.length; i++) {

            boolean repetido = false;

            for (int j = 0; j < i; j++) {

                if (vet[i] == vet[j]) {
                    repetido = true;
                    break;
                }
            }

            if (!repetido) {

                int contador = 0;

                for (int j = 0; j < vet.length; j++) {

                    if (vet[i] == vet[j]) {
                        contador++;
                    }
                }

                System.out.println(vet[i] + "    |    " + contador);
            }
        }
    }
}
