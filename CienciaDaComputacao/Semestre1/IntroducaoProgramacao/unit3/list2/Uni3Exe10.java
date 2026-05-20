package unit3.list2;

import java.util.Scanner;

public class Uni3Exe10 {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {

            System.out.print("Cateto oposto:");
            double cateto1 = sc.nextDouble();

            System.out.print("Cateto adjacente:");
            double cateto2 = sc.nextDouble();

            double hipotenusa = Math.sqrt(Math.pow(cateto1, 2) + Math.pow(cateto2, 2));

            System.out.println("A hipotenusa é: " + hipotenusa);
        }
    }
}
