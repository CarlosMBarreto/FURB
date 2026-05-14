package list8;

import java.util.Scanner;

public class Uni6Exe10 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] vet = new int[50];
        int tamanho = 0;
        int opcao;

        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1 - Incluir valor");
            System.out.println("2 - Pesquisar valor");
            System.out.println("3 - Alterar valor");
            System.out.println("4 - Excluir valor");
            System.out.println("5 - Mostrar valores");
            System.out.println("6 - Ordenar valores");
            System.out.println("7 - Inverter valores");
            System.out.println("8 - Sair");
            System.out.print("Opção: ");
            opcao = sc.nextInt();

            switch (opcao) {

                case 1:
                    tamanho = incluirValor(vet, tamanho, sc);
                    break;

                case 2:
                    pesquisarValor(vet, tamanho, sc);
                    break;

                case 3:
                    alterarValor(vet, tamanho, sc);
                    break;

                case 4:
                    tamanho = excluirValor(vet, tamanho, sc);
                    break;

                case 5:
                    mostrarValores(vet, tamanho);
                    break;

                case 6:
                    ordenarValores(vet, tamanho);
                    break;

                case 7:
                    inverterValores(vet, tamanho);
                    break;

                case 8:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 8);

        sc.close();
    }

    // 1 - Incluir
    public static int incluirValor(int[] vet, int tamanho, Scanner sc) {

        if (tamanho < vet.length) {
            System.out.print("Digite o valor: ");
            vet[tamanho] = sc.nextInt();
            tamanho++;
            System.out.println("Valor inserido!");
        } else {
            System.out.println("Vetor cheio!");
        }

        return tamanho;
    }

    // 2 - Pesquisar
    public static void pesquisarValor(int[] vet, int tamanho, Scanner sc) {

        System.out.print("Valor a pesquisar: ");
        int valor = sc.nextInt();

        boolean achou = false;

        for (int i = 0; i < tamanho; i++) {
            if (vet[i] == valor) {
                achou = true;
                break;
            }
        }

        System.out.println(achou ? "Encontrado!" : "Não encontrado!");
    }

    // 3 - Alterar
    public static void alterarValor(int[] vet, int tamanho, Scanner sc) {

        System.out.print("Valor a alterar: ");
        int antigo = sc.nextInt();

        System.out.print("Novo valor: ");
        int novo = sc.nextInt();

        boolean achou = false;

        for (int i = 0; i < tamanho; i++) {
            if (vet[i] == antigo) {
                vet[i] = novo;
                achou = true;
                break;
            }
        }

        if (achou) {
            System.out.println("Valor alterado!");
        } else {
            System.out.println("Número não encontrado!");
        }
    }

    // 4 - Excluir
    public static int excluirValor(int[] vet, int tamanho, Scanner sc) {

        System.out.print("Valor a excluir: ");
        int valor = sc.nextInt();

        boolean achou = false;

        for (int i = 0; i < tamanho; i++) {
            if (vet[i] == valor) {

                for (int j = i; j < tamanho - 1; j++) {
                    vet[j] = vet[j + 1];
                }

                tamanho--;
                achou = true;
                break;
            }
        }

        System.out.println(achou ? "Valor excluído!" : "Valor não encontrado!");

        return tamanho;
    }

    // 5 - Mostrar
    public static void mostrarValores(int[] vet, int tamanho) {

        if (tamanho == 0) {
            System.out.println("Vetor vazio!");
            return;
        }

        for (int i = 0; i < tamanho; i++) {
            System.out.print(vet[i] + " ");
        }

        System.out.println();
    }

    // 6 - Bubble Sort
    public static void ordenarValores(int[] vet, int tamanho) {

        for (int i = 0; i < tamanho - 1; i++) {
            for (int j = 0; j < tamanho - 1 - i; j++) {
                if (vet[j] > vet[j + 1]) {

                    int temp = vet[j];
                    vet[j] = vet[j + 1];
                    vet[j + 1] = temp;
                }
            }
        }

        System.out.println("Vetor ordenado!");
    }

    // 7 - Inverter
    public static void inverterValores(int[] vet, int tamanho) {

        for (int i = 0; i < tamanho / 2; i++) {

            int temp = vet[i];
            vet[i] = vet[tamanho - 1 - i];
            vet[tamanho - 1 - i] = temp;
        }

        System.out.println("Vetor invertido!");
    }
}