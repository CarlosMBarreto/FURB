package list7;

import java.util.Scanner;

public class Uni5Exe02 {

    public static void main(String[] args) {

        int vetNumeros[] = new int[100];
        int somaPares = 0;
        int somaImpares = 0;

        try (Scanner sc = new Scanner(System.in)) {
            for (int i = 0; i < vetNumeros.length; i++) {

                if (i % 2 == 0) {
                     vetNumeros[i] += vetNumeros[i];
                     somaPares = vetNumeros[i];
                } else {
                    vetNumeros[i] += vetNumeros[i];
                     somaImpares = vetNumeros[i];
                }
            }
            System.out.println("Soma dos numeros pares: " + somaPares);
            System.out.println("Soma dos numeros ímpares:" + somaImpares);
        }
    }
}
