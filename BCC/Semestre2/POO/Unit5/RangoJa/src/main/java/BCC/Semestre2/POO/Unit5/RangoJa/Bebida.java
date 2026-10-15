package BCC.Semestre2.POO.Unit5.RangoJa;

public class Bebida extends ItemCardapio {

    private static final double ACRESCIMO_LACRE = 3.00;

    private int volumeMl;
    private boolean alcoolica;

    public Bebida(String nome, double precoBase, int volumeMl, boolean alcoolica) {
        super(nome, precoBase);
        validarPositivo(volumeMl);
        this.volumeMl = volumeMl;
        this.alcoolica = alcoolica;
    }

    public int getVolumeMl() {
        return volumeMl;
    }

    public boolean isAlcoolica() {
        return alcoolica;
    }

    // Bebida alcoólica tem acréscimo de R$ 3,00 pela embalagem com lacre.
    @Override
    public double calcularPreco() {
        if (alcoolica) {
            return getPrecoBase() + ACRESCIMO_LACRE;
        }
        return getPrecoBase();
    }

    @Override
    public String toString() {
        String texto = super.toString() + " (" + volumeMl + " ml)";
        if (alcoolica) {
            texto += " [alcoólica]";
        }
        return texto;
    }
}
