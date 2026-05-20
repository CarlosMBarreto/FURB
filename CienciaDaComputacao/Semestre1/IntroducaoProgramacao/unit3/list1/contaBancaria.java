package unit3.list1;

import java.util.Scanner;

public class contaBancaria {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {

            String numconta = "00123";
            double saldo = 0.0;
            int function;

            do {
                System.out.print("\n1.Depósito...\n2.Saque...\n3.Consultar Saldo...\n4.Extrato detalhado...\n5.Sair...\n\nDigite o número da função desejada: ");
                function = sc.nextInt();

                if (function < 1 || function > 5) {
                    System.out.print("Função inválida. Digite novamente: ");
                } else if (function == 1) {
                    System.out.print("Digite o valor do depósito:");
                    double deposito = sc.nextDouble();
                    saldo = saldo + deposito;
                    System.out.println("\n\nDepósito realizado com sucesso.");
                } else if (function == 2) {
                    System.out.print("Digite o valor do saque:");
                    double saque = sc.nextDouble();
                    if (saque <= saldo) {
                        saldo -= saque;
                        System.out.println("\n\nSaque realizado com sucesso.");
                    } else {
                        System.out.println("Saldo insuficiente.");
                    }
                } else if (function == 3) {
                    System.out.println("\nSaldo atual: " + saldo);

                } else if (function == 4) {
                    System.out.println("\n\nExtrato detalhado:");
                    System.out.println("Número da conta: " + numconta);
                    System.out.println("Saldo atual: " + saldo);
                } else if (function == 5) {
                    System.out.println("\n\nSaindo do sistema.");
                    break;
                }
            } while (function != 5);

        }
    }
}
