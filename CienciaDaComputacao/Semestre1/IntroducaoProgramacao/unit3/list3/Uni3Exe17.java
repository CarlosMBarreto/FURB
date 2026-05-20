package unit3.list3;

import java.util.Scanner;

public class Uni3Exe17 {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {

            final double precoCamisa = 35;
            final double porcentagemDesconto = 0.10;

            System.out.print("Quantidade de camisetas: ");
            int qntCamisetas = sc.nextInt();

            double valorTotal = precoCamisa * qntCamisetas;
            double desconto = valorTotal * porcentagemDesconto;
            double valorFinal = valorTotal - desconto;

            System.out.println("Valor total: R$" + valorTotal);
            System.out.println("Desconto aplicado: R$ " + desconto);
            System.out.println("Valor final: R$" + valorFinal);
        }
    }
}
