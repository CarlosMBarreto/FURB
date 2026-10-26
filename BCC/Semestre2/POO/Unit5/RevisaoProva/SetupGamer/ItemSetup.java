package BCC.Semestre2.POO.RevisaoProva.SetupGamer;

public abstract class ItemSetup {
    private static int totalItens = 0;
    private static int contadorCodigo = 0;

    private int codigo;
    private String descricao;
    private double precoBase;

    public ItemSetup(String descricao, double precoBase) {
        if (precoBase <= 0) {
            throw new IllegalArgumentException("Preco base invalido");
        }
        this.descricao = descricao;
        this.precoBase = precoBase;

        contadorCodigo++;
        this.codigo = contadorCodigo;

        totalItens++;
    }

    public static int getTotalItens() {
        return totalItens;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getPrecoBase() {
        return precoBase;
    }

    public abstract double calcularPreco();

    @Override
    public String toString() {
        return getCodigo() + " - " + getDescricao() + " - R$" + calcularPreco();
    }
}
