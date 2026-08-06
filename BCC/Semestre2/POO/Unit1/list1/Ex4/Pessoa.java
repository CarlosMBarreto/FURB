package BCC.Semestre2.POO.Unit1.list1.Ex4;

public class Pessoa {
    String nome;
    double altura;
    double peso;

    double calcularImc() {
        return peso / (altura * altura);
    }

    @Override
    public String toString() {
        return "Nome: " + nome +
                "\nAltura: " + altura +
                "\nPeso: " + peso +
                "\nIMC: " + calcularImc();
    }
}
