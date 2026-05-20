package unit5.list7;

import java.util.Scanner;

public class Uni5Exe14 {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {

            int lucroMenor10 = 0;
            int lucroE10e20 = 0;
            int lucroMaior20 = 0;

            double totalCompra = 0;
            double totalVenda = 0;

            for (int i = 1; i <= 20; i++) {

                System.out.print("Nome da mercadoria: ");
                String nome = sc.nextLine();

                System.out.print("Preço de compra: ");
                double pc = sc.nextDouble();

                System.out.print("Preço de venda: ");
                double pv = sc.nextDouble();
                sc.nextLine(); // limpar buffer

                double percentual = ((pv - pc) / pc) * 100;

                if (percentual < 10) {
                    lucroMenor10++;
                } else if (percentual <= 20) {
                    lucroE10e20++;
                } else {
                    lucroMaior20++;
                }

                totalCompra += pc;
                totalVenda += pv;
            }

            double lucroTotal = totalVenda - totalCompra;

            System.out.println("Lucro < 10%: " + lucroMenor10);
            System.out.println("Lucro entre 10% e 20%: " + lucroE10e20);
            System.out.println("Lucro > 20%: " + lucroMaior20);

            System.out.printf("Valor total de compra: %.2f\n", totalCompra);
            System.out.printf("Valor total de venda: %.2f\n", totalVenda);
            System.out.printf("Lucro total: %.2f\n", lucroTotal);
        }
    }
}