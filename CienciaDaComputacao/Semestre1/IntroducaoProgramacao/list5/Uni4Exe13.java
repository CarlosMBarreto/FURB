package list5;

import java.util.Scanner;

public class Uni4Exe13 {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {

            int c1 = sc.nextInt();

            int c2 = sc.nextInt();

            int c3 = sc.nextInt();

            int qtCartasBoas = 0;

            if (c1 == 1 || c1 == 2 || c1 == 3) {
                qtCartasBoas++;
            }
            if (c2 == 1 || c2 == 2 || c2 == 3) {
                qtCartasBoas++;
            }
            if (c3 == 1 || c3 == 2 || c3 == 3) {
                qtCartasBoas++;
            }

            if (qtCartasBoas == 1) {
                System.out.println("TRUCO");
            } else if (qtCartasBoas == 2) {
                System.out.println("SEIS");
            } else if (qtCartasBoas == 3) {
                System.out.println("NOVE");
            }
        }
    }
}