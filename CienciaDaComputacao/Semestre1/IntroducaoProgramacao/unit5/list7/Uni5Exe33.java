package unit5.list7;

import java.util.Scanner;

public class Uni5Exe33 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {

            int c1 = 0, c2 = 0, c3 = 0, c4 = 0;
            int nulo = 0, branco = 0, total = 0;

            while (true) {
                int v = sc.nextInt();

                if (v == 0) break;

                if (v == 1) c1++;
                else if (v == 2) c2++;
                else if (v == 3) c3++;
                else if (v == 4) c4++;
                else if (v == 5) nulo++;
                else if (v == 6) branco++;
                else {
                    System.out.println("Opção incorreta");
                    continue;
                }

                total++;
            }

            System.out.println("1: " + c1);
            System.out.println("2: " + c2);
            System.out.println("3: " + c3);
            System.out.println("4: " + c4);
            System.out.println("Nulos: " + nulo);
            System.out.println("Brancos: " + branco);

            System.out.println("Percentual: " + ((nulo + branco) * 100.0 / total) + "%");
        }
    }
}