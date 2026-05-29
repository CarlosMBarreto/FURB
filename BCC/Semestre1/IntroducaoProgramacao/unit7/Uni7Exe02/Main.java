package unit7.Uni7Exe02;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Pedido[] comanda = new Pedido[10];
        int totalPedidos = 0;

        Scanner sc = new Scanner(System.in);

        int opcao;

        do {
            System.out.println("\n=== LANCHONETE ===");
            System.out.println("1 - Adicionar item");
            System.out.println("2 - Ver comanda");
            System.out.println("0 - Fechar e Pagar");
            System.out.print("Opcao: ");
            opcao = sc.nextInt();

            switch (opcao) {

                case 1:
                    System.out.println("\nCardápio:");
                    System.out.println("1 - X-Burger (R$ 18.50)");
                    System.out.println("2 - X-Salada (R$ 16.00)");
                    System.out.println("3 - Suco Natural (R$ 8.00)");
                    System.out.print("Item: ");
                    int item = sc.nextInt();

                    System.out.print("Quantidade: ");
                    int quantidade = sc.nextInt();

                    String nomeItem = "";
                    double preco = 0;

                    switch (item) {
                        case 1:
                            nomeItem = "X-Burger";
                            preco = 18.50;
                            break;
                        case 2:
                            nomeItem = "X-Salada";
                            preco = 16.00;
                            break;
                        case 3:
                            nomeItem = "Suco Natural";
                            preco = 8.00;
                            break;
                        default:
                            System.out.println("Item inválido!");
                            continue;
                    }

                    if (totalPedidos < comanda.length) {
                        comanda[totalPedidos] = new Pedido(nomeItem, quantidade, preco);
                        totalPedidos++;
                        System.out.println("Adicionado!");
                    } else {
                        System.out.println("Comanda cheia!");
                    }
                    break;

                case 2:
                    System.out.println("\n=== COMANDA ===");

                    double totalComanda = 0;

                    for (int i = 0; i < totalPedidos; i++) {
                        System.out.printf(
                                "%s x%d = R$ %.2f%n",
                                comanda[i].nomeItem,
                                comanda[i].quantidade,
                                comanda[i].calcularTotal());

                        totalComanda += comanda[i].calcularTotal();
                    }

                    System.out.printf("TOTAL: R$ %.2f%n", totalComanda);
                    break;

                case 0:
                    double totalPagar = 0;

                    for (int i = 0; i < totalPedidos; i++) {
                        totalPagar += comanda[i].calcularTotal();
                    }

                    System.out.printf("Total a pagar: R$ %.2f%n", totalPagar);
                    System.out.println("Obrigado, volte sempre!");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);

        sc.close();
    }
}