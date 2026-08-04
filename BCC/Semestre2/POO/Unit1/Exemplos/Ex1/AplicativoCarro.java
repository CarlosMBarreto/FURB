package Ex1;
public class AplicativoCarro {
    public static void main(String[] args) {
        Carro carro1 = new Carro();
        Carro carro2 = new Carro();

        carro1.marca = "VW";
        carro1.modelo = "Fusca";

        carro2.marca = "Chevrolet";
        carro2.modelo = "Onix";

        System.out.println("Modelo do carro 1: " + carro1.modelo);
        System.out.println("Modelo do carro 2: " + carro2.modelo);
    }
}
