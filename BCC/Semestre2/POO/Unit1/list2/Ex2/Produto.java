
public class Produto {

    private String nome;
    private double preco;
    private int estoque;

    public void vender(int quantidade) {
        if (quantidade > estoque) {
            System.out.println("Quantidade indiponivel no estoque.");
        } else {
            estoque -= quantidade;
            System.out.println("Quantidade atualizada no estoque (" + getNome() + "): " + estoque);
        }
    }

    public void repor(int quantidade) {
        if (quantidade > 0) {
            estoque += quantidade;
            System.out.println("Quantidade atualizada no estoque: (" + getNome() + "): " + estoque);
        } else {
            System.out.println("Informe uma quantidade positiva.");
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        if (preco > 0) {
            this.preco = preco;
            System.out.println("Valor atualizado do produto (" + getNome() + "): " + getPreco());
        } else {
            System.out.println("Informe um valor positivo.");
        }
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }
}
