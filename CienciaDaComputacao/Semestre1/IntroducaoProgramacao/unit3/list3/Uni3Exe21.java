package unit3.list3;

import java.util.Scanner;

public class Uni3Exe21 {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {

            System.out.print("Peso: ");
            double peso = sc.nextDouble();

            System.out.print("Altura: ");
            double altura = sc.nextDouble();

            double IMC = peso / Math.pow(altura, 2);

            System.out.println("O IMC da pessoa é " + IMC);
        }
    }
}
