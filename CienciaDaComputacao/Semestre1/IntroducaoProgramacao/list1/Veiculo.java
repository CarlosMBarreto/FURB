package list1;


public class Veiculo {

    private String modelo;
    private double capacidadeTanque;
    private double quilometragem;

    public Veiculo(String modelo, double capacidadeTanque, double quilometragem) {
        this.modelo = modelo;
        this.capacidadeTanque = capacidadeTanque;
        this.quilometragem = quilometragem;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getCapacidadeTanque() {
        return capacidadeTanque;
    }

    public void setCapacidadeTanque(double capacidadeTanque) {
        this.capacidadeTanque = capacidadeTanque;
    }

    public double getQuilometragem() {
        return quilometragem;
    }

    public void setQuilometragem(double quilometragem) {
        this.quilometragem = quilometragem;
    }

    public String consumoKm() {
        return "Média de Consumo: " + getQuilometragem() / getCapacidadeTanque() + "KM/L";
    }

    @Override
    public String toString() {
        return "\n\nModelo: " + getModelo()
                + "\nCapacidade do tanque: " + getCapacidadeTanque() + " Litros"
                + "\nQuilometragem: " + getQuilometragem() + "KM rodados";
    }
}



