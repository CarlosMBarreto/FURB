package BCC.Semestre2.POO.Unit5.RangoJa;

public class AssinaturaClube implements Cobravel {

    private static final int MESES_PARA_DESCONTO = 12;
    private static final double FATOR_DESCONTO = 0.85;

    private final Cliente cliente;
    private final double valorMensal;
    private final int meses;

    public AssinaturaClube(Cliente cliente, double valorMensal, int meses) {
        if (cliente == null) {
            throw new IllegalArgumentException("Cliente é obrigatório");
        }
        if (valorMensal <= 0) {
            throw new IllegalArgumentException("Valor mensal deve ser positivo");
        }
        if (meses <= 0) {
            throw new IllegalArgumentException("Meses deve ser positivo");
        }
        this.cliente = cliente;
        this.valorMensal = valorMensal;
        this.meses = meses;
    }

    public Cliente getCliente() {
        return cliente;
    }

    @Override
    public double calcularValorCobrar() {
        double total = valorMensal * meses;
        return meses >= MESES_PARA_DESCONTO ? total * FATOR_DESCONTO : total;
    }
}
