package list1;
public class VeiculoApp {
        public static void main(String[] args) {
            
            Veiculo v1 = new Veiculo("Ford", 100, 240);
            
            System.out.println(v1);
            System.out.println("Consumo na última viagem: " + v1.consumoKm());
        }
}
