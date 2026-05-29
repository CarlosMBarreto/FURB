package unit3.list4;

import java.io.IOException;
import java.util.Scanner;

public class Exe1005 {

    public static void main(String[] args) throws IOException {

        try (Scanner sc = new Scanner(System.in)) {

            float n1 = sc.nextFloat();

            float n2 = sc.nextFloat();

            float media = (n1 * 35 / 110) + (n2 * 75 / 110);

            System.out.printf("MEDIA = %.5f\n", media);

        }
    }
}
