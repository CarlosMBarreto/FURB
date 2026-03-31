package list5;

import java.util.Scanner;

public class Uni4Exe04 {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {

            System.out.print("Informe um número flutuante maior que 0:");
            float n = sc.nextFloat();

            if(n % 1 > 0){
                System.out.println("Foram digitadas casas decimais.");
            } else {
                System.out.println("Não foram digitadas casas decimais.");
            }
        }
    }
}
