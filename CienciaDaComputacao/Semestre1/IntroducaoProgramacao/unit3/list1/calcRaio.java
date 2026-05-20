package unit3.list1;

import java.util.Scanner;

public class calcRaio {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {

            System.out.print("Digite o raio do círculo: ");
            double raio = sc.nextDouble();

            double calcArea = Math.PI * Math.pow(raio, 2);

            System.out.println("O círculo de raio " + raio + " tem área de: " + calcArea);
        }
    }
}
