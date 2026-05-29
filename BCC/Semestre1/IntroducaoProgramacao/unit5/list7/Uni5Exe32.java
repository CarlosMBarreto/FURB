package unit5.list7;

import java.util.Scanner;

public class Uni5Exe32 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {

            int p = sc.nextInt();
            int n = sc.nextInt();

            System.out.println("D S T Q Q S S");

            int dia = 1;

            for (int i = 1; i < p; i++) System.out.print("  ");

            while (dia <= n) {
                System.out.printf("%2d ", dia);
                if ((dia + p - 1) % 7 == 0) System.out.println();
                dia++;
            }
        }
    }
}