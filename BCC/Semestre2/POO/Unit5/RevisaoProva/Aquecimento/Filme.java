package BCC.Semestre2.POO.RevisaoProva.Aquecimento;

public class Filme extends Midia {

    public Filme(String descricao, double precoBase) {
        super(descricao, precoBase);
    }

    @Override
    public double calcularPreco() {
        return getPrecoBase();
    }
}
