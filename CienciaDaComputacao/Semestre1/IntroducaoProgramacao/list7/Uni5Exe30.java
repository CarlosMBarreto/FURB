package list7;

import java.util.Scanner;

public class Uni5Exe30 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {

            int N = sc.nextInt();
            int K = sc.nextInt();
            int M = sc.nextInt();

            int somaDentro = 0, somaFora = 0;

            for (int i = N; i > 0; i -= K) {
                if (somaDentro + i <= M) {
                    somaDentro += i;
                    System.out.println("Dentro: " + i);
                } else {
                    somaFora += i;
                    System.out.println("Fora: " + i);
                }
            }

            System.out.println("Soma dentro: " + somaDentro);
            System.out.println("Soma fora: " + somaFora);
        }
    }
}