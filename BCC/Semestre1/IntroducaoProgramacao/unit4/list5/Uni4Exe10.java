package unit4.list5;

import java.util.Scanner;

public class Uni4Exe10 {

    public static void main(String[] args) {
        
        try(Scanner sc = new Scanner(System.in)){

            System.out.print("Idade de Marquinhos:");
            int idadeMarquinhos = sc.nextInt();

            System.out.print("Idade de Zezinho:");
            int idadeZezinho = sc.nextInt();

            System.out.print("Idade de Luluzinha:");
            int idadeLuluzinha = sc.nextInt();

            if(idadeLuluzinha < idadeMarquinhos && idadeLuluzinha < idadeZezinho){
                System.out.println("A Luluzinha é a caçula.");
            } else if(idadeZezinho < idadeMarquinhos && idadeZezinho < idadeLuluzinha){
                System.out.println("O Zezinho é a caçula.");
            } else if(idadeMarquinhos < idadeLuluzinha && idadeMarquinhos < idadeZezinho){
                System.out.println("O Marquinhos é a caçula.");
            }
            
        }
    }
}