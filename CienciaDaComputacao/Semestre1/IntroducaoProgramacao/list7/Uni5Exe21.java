package list7;

public class Uni5Exe21 {
    public static void main(String[] args) {

        double chico = 1.50, ze = 1.10;
        int anos = 0;

        while (ze <= chico) {
            chico += 0.02;
            ze += 0.03;
            anos++;
        }

        System.out.println(anos);
    }
}