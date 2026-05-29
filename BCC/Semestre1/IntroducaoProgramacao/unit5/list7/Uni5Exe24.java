package unit5.list7;

import java.util.Scanner;

public class Uni5Exe24 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {

            double limite = sc.nextDouble();
            double total = 0;

            while (true) {
                System.out.print("Peso: ");
                double peso = sc.nextDouble();

                total += peso;
                System.out.println("Total: " + total);

                if (total > limite) {
                    System.out.println("Limite excedido");
                    break;
                }

                System.out.print("Mais? (s/n): ");
                if (sc.next().equalsIgnoreCase("n")) break;
            }
        }
    }
}