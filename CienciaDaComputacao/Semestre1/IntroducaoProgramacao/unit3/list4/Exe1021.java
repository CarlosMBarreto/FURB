package unit3.list4;

import java.util.Scanner;

public class Exe1021 {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {

            double valor = sc.nextDouble();

            int centavos = (int) Math.round(valor * 100);

            int nota100 = centavos / 10000;
            centavos %= 10000;

            int nota50 = centavos / 5000;
            centavos %= 5000;

            int nota20 = centavos / 2000;
            centavos %= 2000;

            int nota10 = centavos / 1000;
            centavos %= 1000;

            int nota5 = centavos / 500;
            centavos %= 500;

            int nota2 = centavos / 200;
            centavos %= 200;

            int moeda1 = centavos / 100;
            centavos %= 100;

            int moeda050 = centavos / 50;
            centavos %= 50;

            int moeda025 = centavos / 25;
            centavos %= 25;

            int moeda010 = centavos / 10;
            centavos %= 10;

            int moeda005 = centavos / 5;
            centavos %= 5;

            int moeda001 = centavos;

            System.out.println("NOTAS:");
            System.out.println(nota100 + " nota(s) de R$ 100.00");
            System.out.println(nota50 + " nota(s) de R$ 50.00");
            System.out.println(nota20 + " nota(s) de R$ 20.00");
            System.out.println(nota10 + " nota(s) de R$ 10.00");
            System.out.println(nota5 + " nota(s) de R$ 5.00");
            System.out.println(nota2 + " nota(s) de R$ 2.00");

            System.out.println("MOEDAS:");
            System.out.println(moeda1 + " moeda(s) de R$ 1.00");
            System.out.println(moeda050 + " moeda(s) de R$ 0.50");
            System.out.println(moeda025 + " moeda(s) de R$ 0.25");
            System.out.println(moeda010 + " moeda(s) de R$ 0.10");
            System.out.println(moeda005 + " moeda(s) de R$ 0.05");
            System.out.println(moeda001 + " moeda(s) de R$ 0.01");

        }
    }
}
