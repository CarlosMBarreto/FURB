package BCC.Semestre2.POO.Unit5.RangoJa;

import java.util.Locale;

/**
 * Contrato de tudo que gera cobrança (Pedido e AssinaturaClube),
 * mesmo sem terem parentesco entre si.
 */
public interface Cobravel {

    double calcularValorCobrar();

    default String gerarComprovante() {
        return String.format(Locale.forLanguageTag("pt-BR"),
                "Valor a cobrar: R$ %.2f", calcularValorCobrar());
    }
}
