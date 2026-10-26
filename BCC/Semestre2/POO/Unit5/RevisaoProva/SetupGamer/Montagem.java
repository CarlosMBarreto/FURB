package BCC.Semestre2.POO.RevisaoProva.SetupGamer;

public class Montagem extends ItemSetup {

    private int horas;

    public Montagem(String descricao, double precoBase, int horas) {
        super(descricao, precoBase);
        if (horas <= 0) {
            throw new IllegalArgumentException("Quantidade de horas invalida.");
        }
        this.horas = horas;
    }

    public int getHoras() {
        return horas;
    }

    @Override
    public double calcularPreco() {
        return getPrecoBase() * getHoras();
    }
}
