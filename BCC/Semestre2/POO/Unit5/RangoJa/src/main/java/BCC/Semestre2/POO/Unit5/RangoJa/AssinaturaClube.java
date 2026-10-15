package BCC.Semestre2.POO.Unit5.RangoJa;

/**
 * Assinatura do RangoClube. Não tem parentesco nenhum com Pedido,
 * mas os dois cumprem o contrato Cobravel.
 */
public class AssinaturaClube implements Cobravel {

    private static final int MESES_PARA_DESCONTO = 12;
    private static final double DESCONTO_ANUAL = 0.15;

    private double valorMensal;
    private int meses;
    private Cliente cliente; // associação: AssinaturaClube -> Cliente (1)

    public AssinaturaClube(Cliente cliente, double valorMensal, int meses) {
        if (cliente == null) {
            throw new IllegalArgumentException("A assinatura precisa de um cliente.");
        }
        if (valorMensal <= 0) {
            throw new IllegalArgumentException("O valor mensal deve ser positivo.");
        }
        if (meses < 1) {
            throw new IllegalArgumentException("A assinatura deve ter pelo menos 1 mês.");
        }
        this.cliente = cliente;
        this.valorMensal = valorMensal;
        this.meses = meses;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public double getValorMensal() {
        return valorMensal;
    }

    public int getMeses() {
        return meses;
    }

    // Valor mensal x meses; 12 meses ou mais ganham 15% de desconto.
    @Override
    public double calcularValorCobrar() {
        double total = valorMensal * meses;
        if (meses >= MESES_PARA_DESCONTO) {
            total = total * (1 - DESCONTO_ANUAL);
        }
        return total;
    }
}
