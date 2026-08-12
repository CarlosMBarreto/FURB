package BCC.Semestre2.POO.Unit1.list2.Ex3;

public class App {

    public static void main(String[] args) {
        ContaBancaria conta1 = new ContaBancaria();
        ContaBancaria conta2 = new ContaBancaria();

        conta1.setNumero("6");
        conta1.setTitular("Carlos");

        conta2.setNumero("7");
        conta2.setTitular("Giovana");

        conta1.depositar(1000);
        conta1.depositar(700);

        conta2.depositar(5000);

        conta2.sacar(3000);

        conta2.transferir(conta1, 1800);

        System.out.println(conta1);
        System.out.println(conta2);
    }
}
