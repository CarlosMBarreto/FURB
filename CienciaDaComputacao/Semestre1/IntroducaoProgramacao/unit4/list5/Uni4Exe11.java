package unit4.list5;

import java.util.Scanner;

public class Uni4Exe11 {

    public static void main(String[] args) {
        
        try(Scanner sc = new Scanner(System.in)){

            int n1 = sc.nextInt();

            int n2 = sc.nextInt();

            int n3 = sc.nextInt();

            if(n1 == n2 && n1 == n3){
                System.out.println("TRIGÊMEOS");
            } else if(n1 == n2 || n1 == n3){
                System.out.println("GÊMEOS");
            } else {
                System.out.println("APENAS IRMÃOS");
            }
        }
    }
}