package Prova1;

import java.util.Scanner;

public class VooBem {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {

            System.out.print("Nome do passageiro: ");
            String nomePassageiro = sc.next();

            System.out.print("Classe(1-Econ, 2-Exec, 3-Prim): ");
            int opcao = sc.nextInt();

            System.out.print("Peso da bagagem(kg): ");
            double pesoBagagem = sc.nextDouble();

            String classe = "";
            double franquia = 0;
            double tarifa = 0;
            String status = "";
            double pesoExcedente = 0;
            double taxaAdicional = 0;

            switch (opcao) {
                case 1:
                    classe = "Econômica";
                    franquia = 23;
                    tarifa = 15;
                    break;
                case 2:
                    classe = "Executiva";
                    franquia = 32;
                    tarifa = 10;
                    break;
                case 3:
                    classe = "Primeira Classe";
                    franquia = 46;
                    tarifa = 7;
                    break;
            }

            if (pesoBagagem > franquia) {
                pesoExcedente = pesoBagagem - franquia;
                taxaAdicional = pesoExcedente * tarifa;
                status = "Bagagem excedente \nExcesso: " + pesoExcedente + " kg";
            } else {
                System.out.println("A bagagem está dentro do limite.");
                status = "Dentro do limite Taxa adicional: R$ " + taxaAdicional;
            }

            System.out.println("--- Check-in VooBem ---");
            System.out.println("Passageiro: " + nomePassageiro);
            System.out.println("Classe: " + classe);
            System.out.println("Franquia: " + franquia + " kg");
            System.out.println("Peso da bagagem: " + pesoBagagem + " kg");
            System.out.println("Status: " + status);
            System.out.println("Taxa adicional: R$ " + taxaAdicional);
            
            if(taxaAdicional == 0) {
                System.out.println("Boa viagem!");
            } else {
                System.out.println("Dirija-se ao caixa para pagamento antes do embarque.");
            }
        }
    }
}
