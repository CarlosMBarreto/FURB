package BCC.Semestre2.POO.Unit5.RangoJa;

public class Sobremesa extends ItemCardapio {

    private final int pesoGramas;

    public Sobremesa(String nome, double precoBase, int pesoGramas) {
        super(nome, precoBase);
        if (pesoGramas <= 0) {
            throw new IllegalArgumentException("Peso deve ser positivo");
        }
        this.pesoGramas = pesoGramas;
    }

    public int getPesoGramas() {
        return pesoGramas;
    }

    // precoBase é o preço de cada 100 g
    @Override
    public double calcularPreco() {
        return getPrecoBase() * pesoGramas / 100.0;
    }

    @Override
    public String toString() {
        return super.toString() + " (" + pesoGramas + " g)";
    }
}
