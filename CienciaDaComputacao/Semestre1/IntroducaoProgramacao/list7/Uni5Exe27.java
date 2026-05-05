package list7;

import java.util.Scanner;

public class Uni5Exe27 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {

            int maiorDia = 0, maiorProd = 0;
            int totalManha = 0, totalTarde = 0;

            while (true) {

                int dia;
                do {
                    System.out.print("Dia: ");
                    dia = sc.nextInt();
                    if (dia < 1 || dia > 30) System.out.println("Dia inválido");
                } while (dia < 1 || dia > 30);

                int manha = sc.nextInt();
                int tarde = sc.nextInt();

                int total = manha + tarde;

                double valor;
                if (dia <= 15) {
                    if (total > 100 && manha >= 30 && tarde >= 30)
                        valor = total * 0.80;
                    else
                        valor = total * 0.50;
                } else {
                    valor = manha * 0.40 + tarde * 0.30;
                }

                System.out.println("R$ " + valor);

                if (total > maiorProd) {
                    maiorProd = total;
                    maiorDia = dia;
                }

                totalManha += manha;
                totalTarde += tarde;

                System.out.print("Novo funcionário (1.sim 2.não)? ");
                if (sc.nextInt() == 2) break;
            }

            System.out.println("Maior produção no dia: " + maiorDia);
            System.out.println((totalManha > totalTarde) ? "Manhã" : "Tarde");
        }
    }
}