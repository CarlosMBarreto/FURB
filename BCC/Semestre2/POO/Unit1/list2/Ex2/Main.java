public class Main {
    public static void main(String[] args) {
        Produto arroz = new Produto();

        arroz.setNome("Arroz");
        arroz.setPreco(20.5);
        arroz.setEstoque(30);

        //vender
        arroz.vender(31);
        arroz.vender(30);

        //repor
        arroz.repor(-29);
        arroz.repor(10);
        
        //alterar
        arroz.setPreco(0);
        arroz.setPreco(20.99);
    }
}
