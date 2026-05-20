package unit5.list7;

import java.util.Scanner;

public class Uni5Exe18 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {

            int canal, pessoas;
            int c4 = 0, c5 = 0, c9 = 0, c12 = 0, total = 0;

            while (true) {
                System.out.print("Canal: ");
                canal = sc.nextInt();
                if (canal == 0) break;

                System.out.print("Pessoas: ");
                pessoas = sc.nextInt();

                total += pessoas;

                if (canal == 4) c4 += pessoas;
                if (canal == 5) c5 += pessoas;
                if (canal == 9) c9 += pessoas;
                if (canal == 12) c12 += pessoas;
            }

            System.out.println("4: " + (c4 * 100.0 / total) + "%");
            System.out.println("5: " + (c5 * 100.0 / total) + "%");
            System.out.println("9: " + (c9 * 100.0 / total) + "%");
            System.out.println("12: " + (c12 * 100.0 / total) + "%");
        }
    }
}