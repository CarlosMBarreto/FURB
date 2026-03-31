package list1;

import java.util.Scanner;

public class Retangulo {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {

        System.out.print("Digite o comprimento do retângulo: ");
        double c = sc.nextDouble();

        System.out.print("Digite a largura do retângulo: ");
        double l = sc.nextDouble();

        double area = c * l;

        System.out.print("A área do retângulo é: " + area);

        sc.close();
        }
    }
}
