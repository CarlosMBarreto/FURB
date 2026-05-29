package unit7.Uni7Exe02;

public class Pedido {

    String nomeItem;
    int quantidade;
    double precoUnitario;

    public Pedido(String nomeItem, int quantidade, double precoUnitario) {
        this.nomeItem = nomeItem;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
    }

    public double calcularTotal() {
        return quantidade * precoUnitario;
    }
}