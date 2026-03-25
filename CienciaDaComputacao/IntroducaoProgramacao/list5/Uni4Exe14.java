package list5;

import java.util.Scanner;

public class Uni4Exe14 {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {

            System.out.print("Dia:");
            int dia = sc.nextInt();

            System.out.print("Mês:");
            int mes = sc.nextInt();

            System.out.print("Ano:");
            int ano = sc.nextInt();

            if(dia >= 1 && dia <= 31 && mes >= 1 && mes <= 12 && ano >= 1){
                if(mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12){
                    System.out.println("Válida");
                } else if(mes != 2 && dia < 31) {
                    System.out.println("Válida");
                } else if(mes == 2 && dia < 29){
                    System.out.println("Válida");
                } else if (dia == 29 && ano % 4 == 0 && !(ano % 100 == 0 && ano % 400 != 0)){
                    System.out.println("Válida");
                } else {
                    System.out.println("Não válida");
                }
            } else {
                System.out.println("Não válida");
            }
        }
    }
}