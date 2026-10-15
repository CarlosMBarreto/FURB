package BCC.Semestre2.POO.Unit5.RangoJa;

public class Prato extends ItemCardapio {

    private char tamanho;

    public Prato(String nome, double precoBase, char tamanho) {
        super(nome, precoBase);
        if (tamanho != 'P' && tamanho != 'M' && tamanho != 'G') {
            throw new IllegalArgumentException("Tamanho inválido: use 'P', 'M' ou 'G'.");
        }
        this.tamanho = tamanho;
    }

    public char getTamanho() {
        return tamanho;
    }

    // P = preço base; M = +30%; G = +60%
    @Override
    public double calcularPreco() {
        switch (tamanho) {
            case 'M':
                return getPrecoBase() * 1.30;
            case 'G':
                return getPrecoBase() * 1.60;
            default:
                return getPrecoBase();
        }
    }

    @Override
    public String toString() {
        return super.toString() + " (tamanho " + tamanho + ")";
    }
}
