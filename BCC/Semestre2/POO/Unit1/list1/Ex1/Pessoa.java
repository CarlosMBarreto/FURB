package BCC.Semestre2.POO.Unit1.list1.Ex1;

public class Pessoa {
    double altura;
    double peso;

    double calcularImc() {
        return peso / Math.pow(altura, 2);
    }
}
