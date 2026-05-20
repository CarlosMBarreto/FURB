package unit5.list7;

import java.util.Scanner;

public class Uni5Exe25 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {

            int d = 0, e = 0;

            while (true) {
                System.out.print("Ponto (D/E): ");
                char p = sc.next().toUpperCase().charAt(0);

                if (p == 'D') d++;
                else if (p == 'E') e++;

                if ((d >= 21 || e >= 21) && Math.abs(d - e) >= 2) break;
            }

            System.out.println("Placar: D=" + d + " E=" + e);
            System.out.println((d > e) ? "Direita venceu" : "Esquerda venceu");
        }
    }
}