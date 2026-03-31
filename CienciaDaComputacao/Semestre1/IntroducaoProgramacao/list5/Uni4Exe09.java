package list5;

import java.util.Scanner;

public class Uni4Exe09 {

    public static void main(String[] args) {
        
        try(Scanner sc = new Scanner(System.in)){

            int v1 = sc.nextInt();
            int v2 = sc.nextInt();

            if(v1 % v2 == 0 || v2 % v1 == 0){
                System.out.println("Os valores são múltiplos.");
            } else {
                System.out.println("Os valores não são múltiplos");
            }
        }
    }
}