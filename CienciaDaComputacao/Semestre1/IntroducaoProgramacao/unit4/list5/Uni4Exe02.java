package unit4.list5;

import java.util.Scanner;

public class Uni4Exe02 {

    public static void main(String[] args) {
        
        try(Scanner sc = new Scanner(System.in)){

            System.out.print("Informe um número inteiro maior que 0:");
            int n = sc.nextInt();

            if(n % 2 == 0){
                System.out.println("Número é par");
            } else {
                System.out.println("Número é impar");
            }
        }
    }
}
