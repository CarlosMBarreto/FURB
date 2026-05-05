package list7;

public class Uni5Exe10 {

    public static void main(String[] args) {

        int encontrados = 0;
        int numero = 1;

        while (encontrados < 10) {

            int temp = numero;
            int digitos = String.valueOf(numero).length();
            int metade = digitos / 2;

            int divisor = (int) Math.pow(10, metade);

            int parte1 = numero / divisor;
            int parte2 = numero % divisor;

            int soma = parte1 + parte2;

            if (soma * soma == numero) {
                System.out.println(numero);
                encontrados++;
            }

            numero++;
        }
    }
}