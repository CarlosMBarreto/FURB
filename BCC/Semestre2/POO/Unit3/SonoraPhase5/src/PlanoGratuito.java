/**
 * final: regra de negocio do Sonora. Ninguem pode especializar o plano gratuito
 * (por exemplo sobrescrevendo temAnuncios()) para tirar os anuncios de graca.
 */
public final class PlanoGratuito extends Plano {

    public PlanoGratuito() {
        super("Gratuito", 1);
    }

    @Override
    public boolean temAnuncios() {
        return true;
    }

    @Override
    public double calcularMensalidade() {
        return 0.0;
    }
}
