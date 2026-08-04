package BCC.Semestre2.POO.Unit1.list1.Ex2;

public class Pessoa {
    double altura;
    double peso;

    double calcularImc() {
        return peso / Math.pow(altura, 2);
    }
}
