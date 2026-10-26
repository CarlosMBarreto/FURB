package BCC.Semestre2.POO.Unit5.RangoJa;

public class Bebida extends ItemCardapio {

    private static final double ACRESCIMO_ALCOOLICA = 3.00;

    private final int volumeMl;
    private final boolean alcoolica;

    public Bebida(String nome, double precoBase, int volumeMl, boolean alcoolica) {
        super(nome, precoBase);
        if (volumeMl <= 0) {
            throw new IllegalArgumentException("Volume deve ser positivo");
        }
        this.volumeMl = volumeMl;
        this.alcoolica = alcoolica;
    }

    public int getVolumeMl() {
        return volumeMl;
    }

    public boolean isAlcoolica() {
        return alcoolica;
    }

    @Override
    public double calcularPreco() {
        return alcoolica ? getPrecoBase() + ACRESCIMO_ALCOOLICA : getPrecoBase();
    }

    @Override
    public String toString() {
        return super.toString() + " (" + volumeMl + " ml)" + (alcoolica ? " [alcoólica]" : "");
    }
}
