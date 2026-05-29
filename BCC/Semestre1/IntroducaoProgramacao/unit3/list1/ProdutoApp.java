package unit3.list1;


public class ProdutoApp {

    public static void main(String[] args) {
        
        Produto p1 = new Produto("Cadeira", 11.5, 10);

        System.out.println(p1);

        System.out.println("Preço total em " + p1.getName() + ": " + p1.totalEstoque());

    }
}