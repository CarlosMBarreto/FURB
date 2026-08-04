package BCC.Semestre2.POO.Unit1.list1.Ex1;

public class App {

    public static void main(String[] args) {
        Pessoa p1 = new Pessoa();

        p1.altura = 1.75;
        p1.peso = 78;

        double p1Imc = p1.calcularImc();

        System.out.println("IMC p1: " + p1Imc);
    }
}
