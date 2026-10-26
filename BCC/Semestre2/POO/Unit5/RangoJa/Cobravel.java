package BCC.Semestre2.POO.Unit5.RangoJa;

public interface Cobravel {

    double calcularValorCobrar();

    default String gerarComprovante() {
        return "Valor a cobrar: " + Moeda.formatar(calcularValorCobrar());
    }
}
