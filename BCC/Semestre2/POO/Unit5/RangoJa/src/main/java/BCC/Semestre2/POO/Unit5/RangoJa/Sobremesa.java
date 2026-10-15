package BCC.Semestre2.POO.Unit5.RangoJa;

public class Sobremesa extends ItemCardapio {

    private int pesoGramas;

    // O "precoBase" da superclasse é o preço de 100 g.
    public Sobremesa(String nome, double precoPor100g, int pesoGramas) {
        super(nome, precoPor100g);
        validarPositivo(pesoGramas);
        this.pesoGramas = pesoGramas;
    }

    public int getPesoGramas() {
        return pesoGramas;
    }

    // Preço final proporcional ao peso.
    @Override
    public double calcularPreco() {
        return getPrecoBase() * pesoGramas / 100.0;
    }

    @Override
    public String toString() {
        return super.toString() + " (" + pesoGramas + " g)";
    }
}
