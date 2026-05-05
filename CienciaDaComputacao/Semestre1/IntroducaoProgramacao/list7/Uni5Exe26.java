package list7;

import java.util.Scanner;

public class Uni5Exe26 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {

            double limite = sc.nextDouble();
            int acima = 0, total = 0, aceitos150 = 0;

            while (true) {
                double pedagio = sc.nextDouble();
                if (pedagio < 0) break;

                double dist = sc.nextDouble();
                total++;

                if (pedagio > limite) acima++;
                if (pedagio <= limite && dist > 150) aceitos150++;
            }

            System.out.println(acima);
            System.out.println(total);
            System.out.println(aceitos150);
        }
    }
}