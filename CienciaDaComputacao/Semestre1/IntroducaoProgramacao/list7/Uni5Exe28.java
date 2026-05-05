package list7;

import java.util.Scanner;

public class Uni5Exe28 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {

            int v1 = 0, v2 = 0, v3 = 0, v4 = 0, total = 0;

            while (true) {
                int voto = sc.nextInt();

                if (voto == 1) v1++;
                else if (voto == 2) v2++;
                else if (voto == 3) v3++;
                else if (voto == 4) v4++;

                total++;

                System.out.print("Mais um voto? (s/n): ");
                if (sc.next().equalsIgnoreCase("n")) break;
            }

            System.out.println("1: " + v1 + " (" + (v1 * 100.0 / total) + "%)");
            System.out.println("2: " + v2 + " (" + (v2 * 100.0 / total) + "%)");
            System.out.println("3: " + v3 + " (" + (v3 * 100.0 / total) + "%)");
            System.out.println("4: " + v4 + " (" + (v4 * 100.0 / total) + "%)");

            int vencedor = 1;
            int maior = v1;

            if (v2 > maior) { maior = v2; vencedor = 2; }
            if (v3 > maior) { maior = v3; vencedor = 3; }
            if (v4 > maior) { maior = v4; vencedor = 4; }

            System.out.println("Vencedor: " + vencedor);
        }
    }
}