
package BCC.Semestre2.POO.RevisaoProva.SetupGamer;

public class Principal {
    public static void main(String[] args) {
        System.out.println(
                "Itens criados: " + ItemSetup.getTotalItens()
        );

        Cliente cliente = new Cliente(
                "Marina Souza",
                "123.456.789-00"
        );

        Orcamento orcamento = new Orcamento(
                cliente, "Blumenau", 7
        );

        // As variáveis são do tipo ItemSetup.
        ItemSetup placa = new Peca(
                "Placa de vídeo", 2500.0, 1
        );

        ItemSetup monitor = new Peca(
                "Monitor 27 polegadas", 1200.0, 3
        );

        ItemSetup montagem = new Montagem(
                "Montagem e cabeamento", 80.0, 2
        );

        orcamento.adicionarItem(placa);
        orcamento.adicionarItem(monitor);
        orcamento.adicionarItem(montagem);

        System.out.println(
                "Solicitante: " + orcamento.getSolicitante().getNome()
        );

        System.out.println(
                "Entrega: " + orcamento.getCidadeEntrega()
                        + ", em " + orcamento.getPrazoEntrega() + " dias"
        );

        int numero = 1;

        for (ItemSetup item : orcamento.getItens()) {
            System.out.println(numero + " - " + item.getDescricao()
                    + " - R$ " + item.calcularPreco());
            numero++;
        }

        System.out.println(
                "Valor total: " + orcamento.calcularValorTotal()
        );

        System.out.println(
                "Garantia estendida: "
                        + orcamento.calcularTotalGarantia()
        );

        try {
            orcamento.adicionarItem(placa);
        } catch (IllegalStateException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        try {
            ItemSetup montagemInvalida = new Montagem(
                    "Montagem inválida", 80.0, 0
            );

            orcamento.adicionarItem(montagemInvalida);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        System.out.println(
                "Itens criados: " + ItemSetup.getTotalItens()
        );
    }
}
