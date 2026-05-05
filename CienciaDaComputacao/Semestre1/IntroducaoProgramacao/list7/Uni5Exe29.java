package list7;

import java.util.Scanner;

public class Uni5Exe29 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {

            int valor = sc.nextInt();

            int n20 = valor / 20;
            valor %= 20;

            int n10 = valor / 10;
            valor %= 10;

            int n5 = valor / 5;
            valor %= 5;

            int n2 = valor / 2;
            valor %= 2;

            int n1 = valor;

            System.out.println("20: " + n20);
            System.out.println("10: " + n10);
            System.out.println("5: " + n5);
            System.out.println("2: " + n2);
            System.out.println("1: " + n1);
        }
    }
}