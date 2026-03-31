package list5;

import java.util.Scanner;

public class Uni4Exe16 {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {

            int h1 = sc.nextInt();
            int h2 = sc.nextInt();

            int m1 = sc.nextInt();
            int m2 = sc.nextInt();

            int soma = 0;
            int produto = 0;

            if (h1 > h2 && m1 > m2) {
                soma = h1 + m2;
                produto = h2 * m1;
            } else if (h1 < h2 && m1 < m2){
                soma = h2 + m1;
                produto = h1 * m2;
            }

            System.out.println("Soma: " + soma + "  Produto: " + produto);

        }
    }

}
