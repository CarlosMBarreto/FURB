package BCC.Semestre2.POO.RevisaoProva.Aquecimento;

public class PrincipalPedido {

    public static void main(String[] args) {
        Pedido pedido = new Pedido(new Cliente("Marina Souza"), "Rua XV de Novembro", 1200);
        System.out.println("Comprador: " + pedido.getComprador().getNome());
        System.out.println("Entrega: " + pedido.getRuaEntrega() + ", " + pedido.getNumeroEntrega());
    }
}
