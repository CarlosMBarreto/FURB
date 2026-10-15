package BCC.Semestre2.POO.Unit5.RangoJa;

import java.util.Locale;

/**
 * Exceção verificável (estende Exception): lançada quando o cliente tenta usar
 * mais cashback do que possui. Quem lança precisa declarar "throws".
 */
public class SaldoInsuficienteException extends Exception {

    private static final long serialVersionUID = 1L;

    public SaldoInsuficienteException(double saldo, double valorSolicitado) {
        super(String.format(Locale.forLanguageTag("pt-BR"),
                "Saldo insuficiente: disponível R$ %.2f, solicitado R$ %.2f",
                saldo, valorSolicitado));
    }
}
