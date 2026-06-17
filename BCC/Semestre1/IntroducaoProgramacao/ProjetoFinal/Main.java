package ProjetoFinal;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Sala sala = new Sala();

        sala.randomizarAssentos();

        int opcao = 0;

        do {
            System.out.println("\t===== MENU =====");
            System.out.println("1 - Visualizar sala");
            System.out.println("2 - Comprar ingresso");
            System.out.println("3 - Resumo");
            System.out.println("0 - Encerrar");
            System.out.print("Opção: ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    sala.exibirSala();
                    break;

                case 2:
                    System.out.println("===== Cine Campus - Totem de autoatendimento =====");
                    sala.exibirSala();

                    System.out.print("Fila: ");
                    int fila = sc.nextInt();

                    System.out.print("Poltrona: ");
                    int poltrona = sc.nextInt();

                    if (sala.posicaoValida(fila, poltrona)) {
                        System.out.print("Tipo - Inteira[1] / Meia[2]: ");
                        int tipo = sc.nextInt();

                        if (tipo != 1 && tipo != 2) {
                            System.out.println("Entrada Incorreta.");
                        } else {
                            sala.reservar(fila, poltrona, tipo, sc);
                        }
                    }
                    break;

                case 3:
                    sala.resumo();
                    break;

                case 0:
                    System.out.println("Encerrando...");
                    break;

                default:
                    System.out.println("Opção Incorreta.");
                    break;
            }
        } while (opcao != 0 && sala.ingressosVendidos() < 85);
        if (sala.ingressosVendidos() == 85)

        {
            System.out.println("Sessão lotada!");
        }

        sala.exibirSala();
        sala.resumo();
    }
}