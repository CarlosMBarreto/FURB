package unit3.list2;

import java.util.Scanner;

public class Uni3Exe09 {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {

            System.out.print("Raio:");
            double raio = sc.nextDouble();

            System.out.print("Altura: ");
            double altura = sc.nextDouble();

            double volumeLata = Math.PI * Math.pow(raio, 2) * altura;

            System.out.println("O volume da lata de óleo é: " + volumeLata);

        }
    }
}
