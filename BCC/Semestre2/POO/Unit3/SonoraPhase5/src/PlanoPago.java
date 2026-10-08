/**
 * Generalizacao, rodada 2: o que e comum so aos planos pagos.
 * Abstrata: nao existe "plano pago generico". Nao implementa calcularMensalidade(),
 * passando a obrigacao adiante para as subclasses concretas.
 */
public abstract class PlanoPago extends Plano {

    private double precoMensal;

    protected PlanoPago(String nome, int maxDispositivos, double precoMensal) {
        super(nome, maxDispositivos);
        setPrecoMensal(precoMensal);
    }

    public double getPrecoMensal() {
        return precoMensal;
    }

    public void setPrecoMensal(double precoMensal) {
        if (precoMensal <= 0) {
            throw new IllegalArgumentException("Preco deve ser positivo");
        }
        this.precoMensal = precoMensal;
    }

    // igual nos dois planos pagos (nenhum tem anuncios)
    @Override
    public boolean temAnuncios() {
        return false;
    }
}
