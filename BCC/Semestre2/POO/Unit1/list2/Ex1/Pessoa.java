package BCC.Semestre2.POO.Unit1.list2.Ex1;

public class Pessoa {

    private String nome;
    private double altura;
    private double peso;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        if (altura <= 0) {
            throw new IllegalArgumentException();
        } else {
            this.altura = altura;
        }
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        if (peso <= 0) {
            throw new IllegalArgumentException();
        } else {
            this.peso = peso;
        }
    }

    public double calcularImc() {
        return getPeso() / (getAltura() * getAltura());
    }

    @Override
    public String toString() {
        return "Nome: " + getNome()
                + "\nAltura: " + getAltura()
                + "\nPeso: " + getPeso()
                + "\nIMC: " + calcularImc();
    }
}
