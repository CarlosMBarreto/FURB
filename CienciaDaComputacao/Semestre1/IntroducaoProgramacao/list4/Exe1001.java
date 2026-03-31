package list4;

import java.io.IOException;
import java.util.Scanner;

public class Exe1001 {

    public static void main(String[] args) throws IOException {

        try (Scanner input = new Scanner(System.in)) {

            int A, B;

            A = input.nextInt();
            B = input.nextInt();

            int X = A + B;

            System.out.println("X = " + X);
        }
    }
}
