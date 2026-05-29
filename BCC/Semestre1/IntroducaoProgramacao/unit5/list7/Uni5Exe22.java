package unit5.list7;

public class Uni5Exe22 {
    public static void main(String[] args) {

        double salario = 2000;
        double aumento = 0.015;

        for (int ano = 1996; ano <= 2026; ano++) {
            salario += salario * aumento;
            aumento *= 2;
        }

        System.out.println(salario);
    }
}