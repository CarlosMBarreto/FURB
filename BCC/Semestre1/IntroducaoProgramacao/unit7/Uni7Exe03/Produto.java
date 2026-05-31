package unit7.Uni7Exe03;

public class Produto {
    String nome;
    double preco;
    int estoque;

    public Produto(String nome, double preco, int estoque) {
        this.nome = nome;
        this.preco = preco;
        this.estoque = estoque;
    }

    public void vender(int qtd) {
        if (qtd > estoque) {
            System.out.println("Estoque insuficiente! Disponível: " + estoque);
        } else {
            estoque -= qtd;
            System.out.println("Venda realizada!");
        }
    }

    public void repor(int qtd) {
        estoque += qtd;
    }

    public boolean estaEmBaixa() {
        return estoque <= 3;
    }
}
