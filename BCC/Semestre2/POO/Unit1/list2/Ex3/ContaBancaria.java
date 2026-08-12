package BCC.Semestre2.POO.Unit1.list2.Ex3;

public class ContaBancaria {

    private String numero;
    private String titular;
    private double saldo;

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("Saldo atual conta(" + getNumero() + "): " + saldo);
        } else {
            System.out.println("Insira um valor de deposito positivo.");
        }
    }

    public void sacar(double valor) {
        if (valor <= 0) {
            System.out.println("Insira um valor de saque positivo.");
        } else {
            if (valor > saldo) {
                System.out.println("Saldo indisponivel.");
            } else {
                saldo -= valor;
                System.out.println("Saldo atual conta(" + getNumero() + "): " + saldo);
            }
        }
    }

    public void transferir(ContaBancaria ContaDestino, double valor) {
        if (valor <= 0) {
            System.out.println("Insira um valor de transferencia positivo.");
        } else {
            if (valor > saldo) {
                System.out.println("Saldo indisponivel.");
            } else {
                saldo -= valor;
                ContaDestino.saldo += valor;
                System.out.println("Saldo atual conta(" + getNumero() + "): " + saldo);
            }
        }
    }

    @Override
    public String toString() {
        return "\n\nNumero da conta: " + getNumero()
                + "\nTitular: " + getTitular()
                + "\nSaldo: " + getSaldo();
    }
}
