package unit5.list7;

import java.util.Scanner;

public class Uni5Exe23 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {

            while (true) {
                System.out.print("Nome: ");
                String nome = sc.nextLine();

                System.out.print("Qtd produtos: ");
                int n = sc.nextInt();

                double total = 0;

                for (int i = 0; i < n; i++) {
                    System.out.print("Preço: ");
                    double preco = sc.nextDouble();
                    System.out.print("Qtd: ");
                    int qtd = sc.nextInt();
                    total += preco * qtd;
                }

                sc.nextLine();

                double salario = total * 0.3;

                System.out.println(nome + " - Vendas: " + total + " Salário: " + salario);

                System.out.print("Mais um? (s/n): ");
                if (sc.nextLine().equalsIgnoreCase("n")) break;
            }
        }
    }
}