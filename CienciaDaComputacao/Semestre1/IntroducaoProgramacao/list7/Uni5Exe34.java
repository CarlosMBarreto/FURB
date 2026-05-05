package list7;

import java.util.Scanner;

public class Uni5Exe34 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {

            int opcao, contas = 0;

            do {
                System.out.println("1-Encerrar 2-Contas 3-Sair");
                opcao = sc.nextInt();

                if (opcao == 1) {
                    sc.nextLine();
                    String nome = sc.nextLine();
                    int dias = sc.nextInt();

                    double taxa;
                    if (dias < 15) taxa = 7.5;
                    else if (dias == 15) taxa = 6.5;
                    else taxa = 5;

                    double total = dias * (50 + taxa);

                    System.out.println(nome + " paga: " + total);
                    contas++;
                }

                if (opcao == 2) {
                    System.out.println("Contas: " + contas);
                }

            } while (opcao != 3);
        }
    }
}