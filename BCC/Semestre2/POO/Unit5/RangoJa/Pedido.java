package BCC.Semestre2.POO.Unit5.RangoJa;

import java.util.ArrayList;
import java.util.List;

public class Pedido implements Cobravel {

    private static final double TAXA_ENTREGA = 7.00;
    private static final double LIMITE_FRETE_GRATIS = 100.00;
    private static final double PERCENTUAL_CASHBACK = 0.05;

    private static int proximoNumero = 1;
    private static int totalPedidosCriados = 0;

    private final int numero;
    private final Cliente cliente;
    private final List<ItemCardapio> itens = new ArrayList<>();
    private boolean finalizado;

    public Pedido(Cliente cliente) {
        if (cliente == null) {
            throw new IllegalArgumentException("Cliente é obrigatório");
        }
        this.cliente = cliente;
        this.numero = proximoNumero++;
        totalPedidosCriados++;
    }

    public static int getTotalPedidosCriados() {
        return totalPedidosCriados;
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

    public int getQuantidadeItens() {
        return itens.size();
    }

    public void adicionarItem(ItemCardapio item) {
        adicionarItem(item, 1);
    }

    public void adicionarItem(ItemCardapio item, int quantidade) {
        if (finalizado) {
            throw new IllegalStateException("Pedido já finalizado");
        }
        if (item == null) {
            throw new IllegalArgumentException("Item não pode ser nulo");
        }
        if (quantidade <= 0) {
            throw new IllegalArgumentException("Quantidade deve ser positiva");
        }
        if (item instanceof Bebida && ((Bebida) item).isAlcoolica() && !cliente.isMaiorDeIdade()) {
            throw new IllegalArgumentException("Menor de idade não pode pedir bebida alcoólica");
        }
        for (int i = 0; i < quantidade; i++) {
            itens.add(item);
        }
    }

    public double calcularSubtotal() {
        double soma = 0;
        for (ItemCardapio item : itens) {
            soma += item.calcularPreco();
        }
        return soma;
    }

    public double calcularTaxaEntrega() {
        return calcularSubtotal() >= LIMITE_FRETE_GRATIS ? 0.00 : TAXA_ENTREGA;
    }

    @Override
    public double calcularValorCobrar() {
        return calcularSubtotal() + calcularTaxaEntrega();
    }

    public void finalizar() {
        if (finalizado) {
            throw new IllegalStateException("Pedido já finalizado");
        }
        if (itens.isEmpty()) {
            throw new IllegalStateException("Pedido sem itens");
        }
        cliente.creditarCashback(calcularSubtotal() * PERCENTUAL_CASHBACK);
        finalizado = true;
    }
}
