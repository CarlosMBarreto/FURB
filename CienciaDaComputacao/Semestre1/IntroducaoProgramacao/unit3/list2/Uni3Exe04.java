package unit3.list2;

import java.util.Scanner;

public class Uni3Exe04 {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {

            double n1, n2, n3;

            System.out.print("Informe a sua 1ª nota: ");
            n1 = sc.nextDouble();

            System.out.print("Informe a sua 1ª nota: ");
            n2 = sc.nextDouble();

            System.out.print("Informe a sua 1ª nota: ");
            n3 = sc.nextDouble();

            double mediaPonderada = (n1 * 0.5) + (n2 * 0.3) + (n3 * 0.2);
            
            System.out.println("Média ponderada final: " + mediaPonderada);
        }
    }
}
