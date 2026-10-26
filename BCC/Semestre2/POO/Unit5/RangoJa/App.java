package BCC.Semestre2.POO.Unit5.RangoJa;

import java.util.ArrayList;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Simulação de um dia no RangoJá.
 * O programa nunca "morre" com exceção: todo erro previsto é tratado e explicado.
 */
public class App {

    private static final Locale PT_BR = Locale.forLanguageTag("pt-BR");

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        // ---------------------------------------------------------------
        // Passo 1 - Cardápio em um ArrayList<ItemCardapio>, exibido com um laço
        // ---------------------------------------------------------------
        System.out.println("=== 1. CARDÁPIO ===");
        Prato xisSalada = new Prato("Xis Salada", 30.00, 'M');
        Bebida refri = new Bebida("Refri", 6.00, 350, false);
        Bebida chopp = new Bebida("Chopp", 12.00, 500, true);
        Sobremesa pudim = new Sobremesa("Pudim", 8.00, 150);

        ArrayList<ItemCardapio> cardapio = new ArrayList<>();
        cardapio.add(xisSalada);
        cardapio.add(refri);
        cardapio.add(chopp);
        cardapio.add(pudim);

        for (ItemCardapio item : cardapio) {
            System.out.println(" - " + item);
        }

        // ---------------------------------------------------------------
        // Passo 2 - Ana (20 anos) e Beto (17 anos), indicado pela Ana
        // ---------------------------------------------------------------
        System.out.println("\n=== 2. CADASTRO DE CLIENTES ===");
        Cliente ana = new Cliente("Ana Souza", "ana@furb.br", 20);
        Cliente beto = new Cliente("Beto Lima", "beto@furb.br", 17, ana);
        System.out.println("Cadastrados: " + ana + " e " + beto + " (indicado por " + beto.getIndicadoPor().getNome() + ")");
        System.out.println("Saldo de cashback da Ana: " + moeda(ana.getSaldoCashback()));

        ArrayList<Pedido> pedidos = new ArrayList<>();

        // ---------------------------------------------------------------
        // Passo 3 - Pedido do Beto: lê a quantidade de um prato do teclado
        // ---------------------------------------------------------------
        System.out.println("\n=== 3. PEDIDO DO BETO ===");
        Pedido pedidoBeto = new Pedido(beto);
        pedidos.add(pedidoBeto);
        lerQuantidadeEAdicionar(teclado, pedidoBeto, xisSalada);
        System.out.println("Itens no pedido #" + pedidoBeto.getNumero() + ": " + pedidoBeto.getQuantidadeItens());

        // ---------------------------------------------------------------
        // Passo 4 - Beto (17 anos) tenta pedir um chopp
        // ---------------------------------------------------------------
        System.out.println("\n=== 4. BETO TENTA PEDIR CHOPP ===");
        try {
            pedidoBeto.adicionarItem(chopp);
            System.out.println("Chopp adicionado.");
        } catch (IllegalArgumentException e) {
            System.out.println("Não foi possível adicionar o chopp: " + e.getMessage());
        }
        try {
            pedidoBeto.finalizar();
            System.out.println("Pedido #" + pedidoBeto.getNumero() + " do Beto finalizado: "
                    + moeda(pedidoBeto.calcularValorCobrar()));
        } catch (IllegalStateException e) {
            System.out.println("Não foi possível finalizar o pedido do Beto: " + e.getMessage());
        }

        // ---------------------------------------------------------------
        // Passo 5 - Pedido da Ana: adicionarItem e finalizar no mesmo try (multi-catch)
        // ---------------------------------------------------------------
        System.out.println("\n=== 5. PEDIDO DA ANA ===");
        Pedido pedidoAna = new Pedido(ana);
        pedidos.add(pedidoAna);
        try {
            pedidoAna.adicionarItem(xisSalada);
            pedidoAna.adicionarItem(refri);
            pedidoAna.adicionarItem(pudim);
            pedidoAna.finalizar();
            System.out.println("Pedido #" + pedidoAna.getNumero() + " da Ana finalizado.");
            System.out.println("Subtotal: " + moeda(pedidoAna.calcularSubtotal())
                    + " | Entrega: " + moeda(pedidoAna.calcularTaxaEntrega())
                    + " | Total: " + moeda(pedidoAna.calcularValorCobrar()));
            System.out.println("Saldo de cashback da Ana: " + moeda(ana.getSaldoCashback()));
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println("Erro no pedido da Ana: " + e.getMessage());
        }

        System.out.println("Tentando finalizar o mesmo pedido de novo...");
        try {
            pedidoAna.finalizar();
            System.out.println("Pedido finalizado novamente (não deveria acontecer).");
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println("Erro esperado: " + e.getMessage());
        }

        // ---------------------------------------------------------------
        // Passo 6 - Ana tenta usar mais cashback do que tem (finally exibe o saldo)
        // ---------------------------------------------------------------
        System.out.println("\n=== 6. USO DE CASHBACK ===");
        tentarUsarCashback(ana, 50.00); // mais do que tem -> SaldoInsuficienteException
        tentarUsarCashback(ana, 5.00);  // dentro do saldo -> dá certo

        // ---------------------------------------------------------------
        // Passo 7 - Assinatura do RangoClube + CentralCobranca + relatório
        // ---------------------------------------------------------------
        System.out.println("\n=== 7. COBRANÇAS ===");
        try {
            AssinaturaClube assinatura = new AssinaturaClube(ana, 19.90, 12);
            CentralCobranca central = new CentralCobranca();
            central.registrar(assinatura);
            for (Pedido pedido : pedidos) {
                if (pedido.isFinalizado()) {
                    central.registrar(pedido);
                } else {
                    System.out.println("Pedido #" + pedido.getNumero() + " não finalizado: não registrado.");
                }
            }
            System.out.println("Cobranças registradas: " + central.getQuantidadeCobrancas());
            System.out.println(central.gerarRelatorio());
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao montar as cobranças: " + e.getMessage());
        }

        System.out.println("\nTotal de pedidos criados no dia: " + Pedido.getTotalPedidosCriados());
        teclado.close();
    }

    /**
     * Lê a quantidade do teclado e adiciona o prato ao pedido.
     * Repete até dar certo: texto que não é número ou quantidade inválida só geram aviso.
     */
    private static void lerQuantidadeEAdicionar(Scanner teclado, Pedido pedido, ItemCardapio prato) {
        while (true) {
            System.out.print("Quantas unidades de \"" + prato.getNome() + "\" o "
                    + pedido.getCliente().getNome() + " quer? ");
            String linha;
            try {
                linha = teclado.nextLine();
            } catch (NoSuchElementException e) {
                // Sem mais entrada (ex.: executado sem teclado): segue com 1 unidade.
                System.out.println("\nSem entrada disponível; usando quantidade 1.");
                pedido.adicionarItem(prato, 1);
                return;
            }
            try {
                int quantidade = Integer.parseInt(linha.trim());
                pedido.adicionarItem(prato, quantidade);
                System.out.println(quantidade + " unidade(s) adicionada(s).");
                return;
            } catch (NumberFormatException e) {
                System.out.println("\"" + linha + "\" não é um número inteiro. Tente de novo.");
            } catch (IllegalArgumentException e) {
                System.out.println("Quantidade inválida: " + e.getMessage() + " Tente de novo.");
            }
        }
    }

    private static void tentarUsarCashback(Cliente cliente, double valor) {
        System.out.println(cliente.getNome() + " tenta usar " + moeda(valor) + " de cashback...");
        try {
            cliente.usarCashback(valor);
            System.out.println("Cashback usado com sucesso.");
        } catch (SaldoInsuficienteException e) {
            System.out.println("Não foi possível usar o cashback: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Valor inválido: " + e.getMessage());
        } finally {
            System.out.println("Saldo atual de cashback de " + cliente.getNome() + ": "
                    + moeda(cliente.getSaldoCashback()));
        }
    }

    private static String moeda(double valor) {
        return String.format(PT_BR, "R$ %.2f", valor);
    }
}
