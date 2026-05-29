package unit5.list7;

import java.util.Scanner;

public class Uni5Exe02 {

    public static void main(String[] args) {

        int somaPares = 0;
        int somaImpares = 0;

        try (Scanner sc = new Scanner(System.in)) {
            for (int i = 0; i <= 100; i++) {

                if (i % 2 == 0) {
                    somaPares += i;
                } else {

                    somaImpares += i;
                }
            }
            System.out.println("Soma dos numeros pares: " + somaPares);
            System.out.println("Soma dos numeros ímpares:" + somaImpares);
        }
    }
}
