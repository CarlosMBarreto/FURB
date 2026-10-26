package BCC.Semestre2.POO.RevisaoProva.SetupGamer;

public class Peca extends ItemSetup implements ComGarantia {

    private int quantidade;

    public Peca(String descricao, double precoBase, int quantidade) {
        super(descricao, precoBase);
        if (quantidade <= 0) {
            throw new IllegalArgumentException("Quantidade invalida");
        }
        this.quantidade = quantidade;
    }

    public int getQuantidade() {
        return quantidade;
    }

    @Override
    public double calcularPreco() {
        double desconto = 0;

        if (getQuantidade() >= 3) {
            desconto = (getPrecoBase() * getQuantidade()) * 0.10;
        }
        return getPrecoBase() * getQuantidade() - desconto;
    }

    @Override
    public double calcularGarantiaEstendida() {
        return calcularPreco() + (calcularPreco() * 0.15);
    }
}
