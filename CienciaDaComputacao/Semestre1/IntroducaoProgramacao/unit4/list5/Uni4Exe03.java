package unit4.list5;

import java.util.Scanner;

public class Uni4Exe03 {

    public static void main(String[] args) {
        
        try(Scanner sc = new Scanner(System.in)){

            System.out.print("Informe o 1° número inteiro:");
            int n1 = sc.nextInt();

            System.out.print("Informe o 2° número inteiro:");
            int n2 = sc.nextInt();

            if(n1 > n2){
                System.out.println("O maior número é " + n1);
            } else if(n2 > n1){
                System.out.println("O maior número é " + n2);
            } else {
                System.out.println("Os números são iguais");
            }
        }
    }
}
