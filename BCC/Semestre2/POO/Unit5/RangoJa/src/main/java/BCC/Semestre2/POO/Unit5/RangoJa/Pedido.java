package BCC.Semestre2.POO.Unit5.RangoJa;

import java.util.ArrayList;

public class Pedido implements Cobravel {

    public static final double TAXA_ENTREGA = 7.0;
    public static final double VALOR_FRETE_GRATIS = 100.0;
    private static final double PERCENTUAL_CASHBACK = 0.05;

    // Compartilhado por todos os pedidos (static): é o contador da classe.
    private static int proximoNumero = 1;

    private int numero; // de cada pedido (não static)
    private boolean finalizado;

    // Associações (papéis das pontas das setas do diagrama):
    // Pedido -> Cliente (1) e Pedido -> ItemCardapio (0..*). Cliente NÃO conhece seus pedidos.
    private Cliente cliente;
    private ArrayList<ItemCardapio> itens;

    // US10 - Abrir pedido
    public Pedido(Cliente cliente) {
        if (cliente == null) {
            throw new IllegalArgumentException("O pedido precisa de um cliente.");
        }
        this.cliente = cliente;
        this.itens = new ArrayList<>();
        this.finalizado = false;
        this.numero = proximoNumero++;
    }

    public int getNumero() {
        return numero;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public boolean isFinalizado() {
        return finalizado;
    }

    // US11 - Adicionar itens
    public void adicionarItem(ItemCardapio item) {
        if (item == null) {
            throw new IllegalArgumentException("O item não pode ser nulo.");
        }
        if (finalizado) {
            throw new IllegalStateException("O pedido já foi finalizado.");
        }
        if (item instanceof Bebida) {
            Bebida bebida = (Bebida) item; // downcasting
            if (bebida.isAlcoolica() && !cliente.isMaiorDeIdade()) {
                throw new IllegalArgumentException(
                        "Bebida alcoólica só pode ser pedida por maiores de idade.");
            }
        }
        itens.add(item);
    }

    public void adicionarItem(ItemCardapio item, int quantidade) {
        if (quantidade < 1) {
            throw new IllegalArgumentException("A quantidade deve ser pelo menos 1.");
        }
        for (int i = 0; i < quantidade; i++) {
            adicionarItem(item); // reaproveita as regras da outra versão
        }
    }

    public int getQuantidadeItens() {
        return itens.size();
    }

    // US12 - Quanto vou pagar
    // Um único laço e nenhum instanceof: cada item responde com o seu calcularPreco (polimorfismo).
    public double calcularSubtotal() {
        double subtotal = 0;
        for (ItemCardapio item : itens) {
            subtotal += item.calcularPreco();
        }
        return subtotal;
    }

    public double calcularTaxaEntrega() {
        if (calcularSubtotal() >= VALOR_FRETE_GRATIS) {
            return 0.0;
        }
        return TAXA_ENTREGA;
    }

    @Override
    public double calcularValorCobrar() {
        return calcularSubtotal() + calcularTaxaEntrega();
    }

    // US13 - Finalizar
    public void finalizar() {
        if (finalizado) {
            throw new IllegalStateException("O pedido já foi finalizado.");
        }
        if (itens.isEmpty()) {
            throw new IllegalStateException("Não é possível finalizar um pedido sem itens.");
        }
        cliente.creditarCashback(calcularSubtotal() * PERCENTUAL_CASHBACK);
        finalizado = true;
    }

    public static int getTotalPedidosCriados() {
        return proximoNumero - 1;
    }
}
