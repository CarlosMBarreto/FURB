package unit3.list4;

import java.util.Scanner;

public class Exe1009 {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {

            final double comissao = 15.0 / 100;

            @SuppressWarnings("unused")
            String nome = sc.nextLine();

            double salarioFixo = sc.nextDouble();

            double vendas = sc.nextDouble();

            double total = salarioFixo + (vendas * comissao);

            System.out.printf("TOTAL = R$ %.2f\n", total);

        }
    }
}
