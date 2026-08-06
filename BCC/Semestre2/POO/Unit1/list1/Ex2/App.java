package BCC.Semestre2.POO.Unit1.list1.Ex2;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        
        try (Scanner sc = new Scanner(System.in)) {
            Pessoa usuario = new Pessoa();

            System.out.print("Altura: ");
            usuario.altura = sc.nextDouble();

            System.out.print("Peso: ");
            usuario.peso = sc.nextDouble();

            System.out.print("IMC: " + usuario.calcularImc());
        }
    }
}
