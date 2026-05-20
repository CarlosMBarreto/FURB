package unit4.list5;

import java.util.Scanner;

public class Uni4Exe25 {
    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {

            System.out.print("Valor 1:");
            double n1 = sc.nextDouble();
            System.out.print("Valor 2:");
            double n2 = sc.nextDouble();

            System.out.print("Opção:");
            int opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println(n1 + n2);
                    break;
                case 2:
                    System.out.println(n1 - n2);
                    break;
                case 3:
                    System.out.println(n1 * n2);
                    break;
                case 4:
                    if (n1 == 0) {
                        System.out.println("O denominador não pode ser 0(zero).");
                    } else {
                        System.out.println(n1 / n2);
                        break;
                    }
            }
        }
    }
}
