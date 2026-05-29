package unit5.list7;

public class Uni5Exe04 {

    public static void main(String[] args) {

        double S = 0;

        for (int i = 1; i <= 20; i++) {

            double numerador = 2 * i + 1;
            double denominador = i * (i + 1);

            S += numerador / denominador;
        }

        System.out.println("Valor de S: " + S);
    }
}
