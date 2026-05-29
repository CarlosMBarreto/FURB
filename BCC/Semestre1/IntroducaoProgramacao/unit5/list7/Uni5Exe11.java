package unit5.list7;

import java.util.Scanner;

public class Uni5Exe11 {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {

            int b = 0;
            int q = 1;

            for (int i = 1; i <= 16; i++) {
                
                b += q;
                q *= 3;
            }
            System.out.println(b);
        }
    }
}
