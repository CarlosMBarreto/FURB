package list2;

import java.util.Scanner;

public class Uni3Exe11 {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {

            System.out.print("Informe a temperatura(°C): ");
            double tempCelsius = sc.nextDouble();

            double tempF = (9.0/5.0) * tempCelsius + 32;

            System.out.println("A temperatura em Fahrenheit é: " + tempF);
        }
    }
}
