package unit7.Uni7Exe03;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Produto[] produto = {
                new Produto("Arroz 5kg", 50, 29),
                new Produto("Feijão 1kg", 40, 8),
                new Produto("Macarrão 500g", 60, 4),
                new Produto("Óleo de Soja 900ml", 30, 7),
                new Produto("Açúcar 1kg", 45, 5),
                new Produto("Leite 1L", 80, 4),
                new Produto("Café 500g", 25, 18),
                new Produto("Farinha de Trigo 1kg", 35, 6)
        };

        int opcao = 1;

        int codigoProduto = 0;
        int quantidade = 0;

        while (opcao != 0) {
            System.out.println("\n=== ESTOQUE ===");
            System.out.println("1 - Listar produtos");
            System.out.println("2 - Vender");
            System.out.println("3 - Repor estoque");
            System.out.println("0 - Sair");
            System.out.print("Opcao: ");
            opcao = sc.nextInt();

            switch (opcao) {

                case 1:
                    System.out.println("Cod | Produto       | Preco     | Estoque");
                    for (int i = 0; i < produto.length; i++) {
                        String status = "";
                        if (produto[i].estaEmBaixa()) {
                            status = " <- BAIXO";
                        }
                        System.out.println((i + 1) + "   | " + produto[i].nome + "| R$ " + produto[i].preco + "| "
                                + produto[i].estoque + status);
                    }
                    break;

                case 2:
                    System.out.print("Codigo do produto: ");
                    codigoProduto = sc.nextInt();

                    if (codigoProduto < 1 || codigoProduto > 8) {
                        System.out.println("Codigo Invalido (" + codigoProduto + ")");
                    } else {

                        System.out.print("Quantidade: ");
                        quantidade = sc.nextInt();

                        produto[codigoProduto - 1].vender(quantidade);
                    }
                    break;

                case 3:
                    System.out.print("Codigo do produto: ");
                    codigoProduto = sc.nextInt();

                    if (codigoProduto < 1 || codigoProduto > 8) {
                        System.out.println("Codigo Invalido (" + codigoProduto + ")");
                    } else {

                        System.out.print("Quantidade: ");
                        quantidade = sc.nextInt();

                        produto[codigoProduto - 1].repor(quantidade);
                    }
                    break;

                case 0:
                System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opcao Invalida");
                    break;
            }
        }
    }
}
