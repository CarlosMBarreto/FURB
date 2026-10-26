package BCC.Semestre2.POO.RevisaoProva.Aquecimento;

public class Documentario extends Midia implements Legendavel {

    public Documentario(String descricao, double precoBase) {
        super(descricao, precoBase);
    }

    @Override
    public double calcularPreco() {
        return getPrecoBase();
    }

    @Override
    public double calcularCustoLegenda() {
        return calcularPreco() * 0.10;
    }
}
