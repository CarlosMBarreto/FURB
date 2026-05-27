package unit7.ExemploPedido;

public class pedido {
    String nome;
    String descricao;
    double valor;
    boolean status;

    public pedido(String nome, String descricao, double valor) {
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
    }

    public boolean entregar(){
        status = true;
        return status;
    }

    public void exibirStatus(){
        if(status){
            System.out.println("Pedido de " + nome + " entregue.");
        } else {
            System.out.println("Pedido de " + nome + " pendente.");
        }
    }

    @Override
    public String toString(){
        return "Nome: " + nome + "\nDescrição: " + descricao + "\nValor: " + valor + "\nStatus: " + status;
    }
}
