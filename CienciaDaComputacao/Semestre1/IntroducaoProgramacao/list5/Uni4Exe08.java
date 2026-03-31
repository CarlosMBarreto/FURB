package list5;

import java.util.Scanner;

public class Uni4Exe08 {

    public static void main(String[] args) {
        
        try(Scanner sc = new Scanner(System.in)){

            System.out.print("Informe a letra:");
            char letra = sc.next().charAt(0);

            if((letra == 'a') || (letra == 'e') || (letra == 'i') || (letra == 'o') || (letra == 'u')){
                System.out.println("É vogal");
            } else {
                System.out.println("Não é vogal");
            }
        }
    }
}