package BCC.Semestre2.POO.RevisaoProva.Aquecimento;

public class Serie extends Midia implements Legendavel {

    private int temporadas;

    public Serie(String descricao, double precoBase, int temporadas) {
        super(descricao, precoBase);
        this.temporadas = temporadas;
    }

    public int getTemporadas() {
        return temporadas;
    }

    @Override
    public double calcularPreco() {
        return getPrecoBase() * temporadas;
    }

    @Override
    public double calcularCustoLegenda() {
        return calcularPreco() * 0.10;
    }
}
