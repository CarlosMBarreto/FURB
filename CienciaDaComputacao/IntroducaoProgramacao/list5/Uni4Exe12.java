package list5;

import java.util.Scanner;

public class Uni4Exe12 {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {

            double l1 = sc.nextDouble();

            double l2 = sc.nextDouble();

            double l3 = sc.nextDouble();

            if (l1 < (l2 + l3) && l2 < (l1 + l3) && l3 < (l1 + l2)) {
                if (l1 == l2 && l1 == l3) {
                    System.out.println("É equilatero.");
                } else if (l1 == l2 || l1 == l3 || l2 == l3) {
                    System.out.println("É isósceles.");
                } else if (l1 != l2 && l1 != l3 && l2 != l3) {
                    System.out.println("É escaleno.");
                }
            } else {
                System.out.println("Não formam um triângulo");
            }
        }
    }
}