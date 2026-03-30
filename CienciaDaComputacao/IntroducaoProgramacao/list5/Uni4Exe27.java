package list5;

import java.util.Scanner;

public class Uni4Exe27 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("horaChegada: ");
        int horaChegada = sc.nextInt();

        System.out.print("minChegada: ");
        int minChegada = sc.nextInt();

        System.out.print("horaSaida: ");
        int horaSaida = sc.nextInt();

        System.out.print("minSaida: ");
        int minSaida = sc.nextInt();

        if (horaChegada < 0 || horaChegada > 23
                || horaSaida < 0 || horaSaida > 23
                || minChegada < 0 || minChegada > 59
                || minSaida < 0 || minSaida > 59) {

            System.out.println("Horário inválido!");
        } else {

            int chegada = horaChegada * 60 + minChegada;
            int saida = horaSaida * 60 + minSaida;

            if (saida < chegada) {
                System.out.println("Horário de saída inválido!");
            } else {

                int totalMin = saida - chegada;

                int horas = totalMin / 60;
                int minutos = totalMin % 60;

                if (totalMin < 30) {
                    horas = 1;
                } else if (minutos >= 30) {
                    horas++;
                }

                double preco;

                if (horas <= 2) {
                    preco = horas * 5.0;
                } else if (horas > 2 && horas < 5) {
                    preco = horas * 7.5;
                } else {
                    preco = horas * 10.0;
                }

                System.out.printf("Preço cobrado = R$%.2f\n", preco);

                sc.close();
            }
        }
    }
}
