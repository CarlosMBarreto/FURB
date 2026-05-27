package unit7.ExemploPedido;

public class pedidoApp {

    public static void main(String[] args) {
        
        pedido p1 = new pedido("Nicolas", "Cookie Pink", 23.50);
        pedido p2 = new pedido("Giovana", "Cheesecake", 15.00);

        p1.exibirStatus();
        p1.entregar();
        p1.exibirStatus();
        System.out.println(p2);
    }
}
