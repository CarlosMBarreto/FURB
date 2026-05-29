package unit3.list4;

import java.io.IOException;
import java.util.Scanner;

public class Exe1002 {

    public static void main(String[] args) throws IOException {

        try (Scanner input = new Scanner(System.in)) {
            double n = 3.14159;

            double raio = input.nextDouble();

            double area = n * Math.pow(raio, 2);

            System.out.printf("A=%.4f\n", area);

        }
    }
}
