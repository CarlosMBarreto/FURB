package BCC.Semestre2.POO.RevisaoProva.Aquecimento;

public class Pedido {

    private Cliente comprador;
    private Endereco entrega;

    public Pedido(Cliente comprador, String rua, int numero) {
        this.comprador = comprador;
        this.entrega = new Endereco(rua, numero);
    }

    public Cliente getComprador() {
        return comprador;
    }

    public String getRuaEntrega() {
        return entrega.getRua();
    }

    public int getNumeroEntrega() {
        return entrega.getNumero();
    }
}
