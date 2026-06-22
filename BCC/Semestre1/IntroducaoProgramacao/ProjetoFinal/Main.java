package ProjetoFinal;

import java.util.Scanner;

/**
 * Classe principal do sistema Cine Campus.
 * <p>
 * Implementa o totem de autoatendimento: exibe um menu em loop, permite
 * visualizar o mapa da sala, comprar/reservar ingressos e ver o resumo
 * parcial da sessão. O programa encerra quando o usuário escolhe a opção
 * 0 ou quando todas as poltronas disponíveis para venda pelo totem se
 * esgotam (85 ingressos, já que 15 das 100 poltronas começam pré-ocupadas
 * — ver {@link Sala#randomizarAssentos()}).
 */
public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Sala sala = new Sala();

        // Pré-ocupa 15 poltronas aleatórias antes de abrir o totem.
        sala.randomizarAssentos();

        int opcao = 0;

        // Loop principal do menu. Executa pelo menos uma vez (do-while) e
        // continua enquanto o usuário não escolher "Encerrar" (0) e ainda
        // houver poltronas disponíveis para venda pelo totem (< 85 vendidas).
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
                    // Apenas exibe o mapa atual da sala.
                    sala.exibirSala();
                    break;

                case 2:
                    // Fluxo de compra: mostra a sala, lê fileira/poltrona,
                    // valida a posição e, se válida, lê o tipo de ingresso
                    // e delega a confirmação/compra para sala.reservar(...).
                    System.out.println("===== Cine Campus - Totem de autoatendimento =====");
                    sala.exibirSala();

                    System.out.print("Fila: ");
                    int fila = sc.nextInt(); // corresponde ao índice de "fileira" em Sala

                    System.out.print("Poltrona: ");
                    int poltrona = sc.nextInt(); // corresponde ao índice de "coluna" em Sala

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
                    // Exibe o resumo parcial (pode ser chamado a qualquer momento).
                    sala.resumo();
                    break;

                case 0:
                    // Encerramento solicitado pelo usuário.
                    System.out.println("Encerrando...");
                    break;

                default:
                    // Qualquer opção fora de 0-3.
                    System.out.println("Opção Incorreta.");
                    break;
            }
            // Continua enquanto não for "Encerrar" e ainda houver poltronas
            // disponíveis pelo totem (máximo de 85 vendas possíveis).
        } while (opcao != 0 && sala.ingressosVendidos() < 85);

        // Se a sessão esgotou (todas as 85 poltronas restantes foram vendidas),
        // avisa o usuário antes do resumo final.
        if (sala.ingressosVendidos() == 85)

        {
            System.out.println("Sessão lotada!");
        }

        // Resumo final exibido sempre ao encerrar, seja por opção 0 ou por sala esgotada.
        sala.exibirSala();
        sala.resumo();
    }
}