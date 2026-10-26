package BCC.Semestre2.POO.Unit5.RangoJa;

public class SaldoInsuficienteException extends Exception {

    public SaldoInsuficienteException(double saldoDisponivel, double valorSolicitado) {
        super("Saldo insuficiente: disponível " + Moeda.formatar(saldoDisponivel)
                + ", solicitado " + Moeda.formatar(valorSolicitado));
    }
}
