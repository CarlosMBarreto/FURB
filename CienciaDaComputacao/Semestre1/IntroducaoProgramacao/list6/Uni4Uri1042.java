package list6;

import java.util.Scanner;

public class Uni4Uri1042 {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {

            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            int maior = 0;
            int medio = 0;
            int menor = 0;

            if (a > b && a > c && b > c) {
                maior = a;
                medio = b;
                menor = c;
            } else if (b > a && b > c && c > a) {
                maior = b;
                medio = c;
                menor = a;
            } else if (c > a && c > b && a > b) {
                maior = c;
                medio = a;
                menor = b;
            } else if (b > a && b > c && a > c){
                maior = b;
                medio = a;
                menor = c;
            } else if (a > b && a > c && c > b){
                maior = a;
                medio = c;
                menor = b;
            } else if(c > a && c > b && b > a){
                maior = c;
                medio = b;
                menor = a;
            }

            System.out.println(menor + "\n" + medio + "\n" + maior);

            System.out.println("\n" + a + "\n" + b + "\n" + c);
        }
    }
}
