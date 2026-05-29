package unit3.list4;

import java.io.IOException;
import java.util.Scanner;

public class Exe1007 {

    public static void main(String[] args) throws IOException {

        try (Scanner sc = new Scanner(System.in)) {

            int A = sc.nextInt();

            int B = sc.nextInt();

            int C = sc.nextInt();

            int D = sc.nextInt();

            int diferenca = A * B - C * D;

            System.out.println("DIFERENCA = " + diferenca);

        }
    }
}
