package list5;

import java.util.Scanner;

public class Uni4Exe18 {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {

            System.out.print("Dia do vencimento:");
            int diaVencimento = sc.nextInt();

            System.out.print("Dia do pagamento:");
            int diaPagamento = sc.nextInt();

            System.out.print("Valor da prestação:");
            double valorPrestacao = sc.nextDouble();

            double desconto = valorPrestacao * 10 / 100;

            if(diaPagamento < diaVencimento){
                System.out.println("O pagamento está em dia. O valor da prestação = R$" + (valorPrestacao - desconto));
            } else if (diaPagamento > diaVencimento){
                int diaMulta = diaPagamento - diaVencimento;

                double valorMulta = (valorPrestacao * 0.02) * diaMulta;

                valorPrestacao = valorPrestacao + valorMulta;
                
                System.out.println("O pagamento está atrasado. Multa de 2% por dia de atraso. Valor da prestação = R$" + valorPrestacao);
            }
        }
    }
}
