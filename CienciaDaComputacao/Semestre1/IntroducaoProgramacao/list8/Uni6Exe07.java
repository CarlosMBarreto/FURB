package list8;

import java.util.Scanner;

public class Uni6Exe07 {

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

        int vet[] = new int[n];

        inserirValores(vet, sc);

        System.out.print("Vetor origem: ");
        escreverVetor(vet);

        ordenarVetor(vet);

        System.out.print("\nVetor ordenado: ");
        escreverVetor(vet);

    }

    public static void inserirValores(int[] vet, Scanner sc) {

        for (int i = 0; i < vet.length; i++) {

            boolean existe;

            do {

                existe = false;

                System.out.print("Valor " + (i + 1) + ": ");
                vet[i] = sc.nextInt();

                for (int j = 0; j < i; j++) {

                    if (vet[i] == vet[j]) {
                        existe = true;
                        System.out.println("Número já informado.");
                    }

                }

            } while (existe);
        }
    }

    public static void ordenarVetor(int[] vet) {

        int ordenar;

        for (int i = 0; i < vet.length; i++) {
            for (int j = 0; j < vet.length - 1; j++) {
                if (vet[j] > vet[j + 1]) {
                    ordenar = vet[j];
                    vet[j] = vet[j + 1];
                    vet[j + 1] = ordenar;
                }
            }
        }
    }

    public static void escreverVetor(int[] vet) {
        for (int i = 0; i < vet.length; i++) {
            System.out.print("[" + vet[i] + "]");
        }
    }
}
