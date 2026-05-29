package unit6.list8;

import java.util.Scanner;

public class Uni6Exe05 {

    public static void main(String[] args) {
        String[] respostaRapaz = new String[5];
        String[] respostaMoca = new String[5];

        lerRespostas(respostaRapaz, respostaMoca);
        afinidade(respostaRapaz, respostaMoca);
    }

    public static void lerRespostas(String[] respostaRapaz, String[] respostaMoca) {
        try (Scanner sc = new Scanner(System.in)) {
            for (int i = 0; i < respostaRapaz.length; i++) {
                respostaRapaz[i] = sc.nextLine();
            }
            for (int i = 0; i < respostaMoca.length; i++) {
                respostaMoca[i] = sc.nextLine();
            }
        }
    }

    public static void afinidade(String[] respostaRapaz, String[] respostaMoca) {

        int afinidade = 0;

        for (int i = 0; i < respostaRapaz.length; i++) {
            if ((respostaRapaz[i].equals("SIM") && respostaMoca[i].equals("SIM")) || (respostaRapaz[i].equals("NÃO") && respostaMoca[i].equals("NÃO")) || (respostaRapaz[i].equals("IND") && respostaMoca[i].equals("IND"))) {
                afinidade += 3;
            } else if (respostaRapaz[i].equals("IND") || respostaMoca[i].equals("IND")){
                afinidade += 1;
            } else if ((respostaRapaz[i].equals("SIM") && respostaMoca[i].equals("NÃO")) || (respostaRapaz[i].equals("NÃO") && respostaMoca[i].equals("SIM"))){
                afinidade -= 2;
            }
        }
        
        if(afinidade == 15){
            System.out.println("Casem!");
        } else if (afinidade > 9 && afinidade <= 14){
            System.out.println("Vocês têm muita coisa em comum!");
        } else if (afinidade > 4 && afinidade <= 9){
            System.out.println("Talvez não dê certo :(");
        } else if (afinidade > -1 && afinidade <= 4){
            System.out.println("Vale um encontro.");
        } else if (afinidade >= -9 && afinidade < -1){
            System.out.println("Melhor não perder tempo");
        } else if (afinidade == -10){
            System.out.println("Vocês se odeiam!");
        }
    }
}
