package unit3.list4;

import java.io.IOException;
import java.util.Scanner;

public class Exe1004 {

    public static void main(String[] args) throws IOException {

        try (Scanner sc = new Scanner(System.in)) {

            int a = sc.nextInt();

            int b = sc.nextInt();

            int PROD = a * b;

            System.out.println("PROD = " + PROD);

        }
    }
}
