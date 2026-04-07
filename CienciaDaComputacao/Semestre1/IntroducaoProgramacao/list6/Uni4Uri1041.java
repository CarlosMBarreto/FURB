package list6;

import java.util.Scanner;

public class Uni4Uri1041 {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {

            double x = sc.nextDouble();
            double y = sc.nextDouble();

            if (x == 0 && y == 0) {
                System.out.println("Origem");
            } else if (x > 0 && y > 0) {
                System.out.println("Q1");
            } else if (x < 0 && y > 0) {
                System.out.println("Q2");
            } else if (x < 0 && y < 0) {
                System.out.println("Q3");
            } else if (x > 0 && y < 0) {
                System.out.println("Q4");
            } else if(x == 0 && y != 0){
                System.out.println("Eixo Y");
            } else if(x != 0 && y == 0){
                System.out.println("Eixo X");
            }
        }
    }
}
