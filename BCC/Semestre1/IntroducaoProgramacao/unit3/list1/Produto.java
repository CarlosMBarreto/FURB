package unit3.list1;


public class Produto {

    private String name;
    private double price;
    private int qtdEstoque;

    public Produto (String name,double price, int qtdEstoque){
        this.name = name;
        this.price = price;
        this.qtdEstoque = qtdEstoque;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQtdEstoque() {
        return qtdEstoque;
    }

    public void setQtdEstoque(int qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }

    public double totalEstoque(){
        return getPrice() * getQtdEstoque();
    }
    

    @Override
    public String toString() {
        return "\nNome do Produto: " + getName() + "\n" +
                "Preço do Produto: " + getPrice() + "\n" +
                "Quantidade em Estoque: " + getQtdEstoque() + "\n";
    }
}