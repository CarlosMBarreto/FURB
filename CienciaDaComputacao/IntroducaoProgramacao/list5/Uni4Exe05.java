package CienciaDaComputacao.IntroducaoProgramacao.list5;

import java.util.Scanner;

public class Uni4Exe05 {

    public static void main(String[] args) {
        
        try(Scanner sc = new Scanner(System.in)){

            System.out.print("A cor é azul?\nR:");
            boolean cor = sc.nextBoolean();

            if (cor){
                System.out.println("Sim");
            } else {
                System.out.println("Não");
            }
        }
    }
}
