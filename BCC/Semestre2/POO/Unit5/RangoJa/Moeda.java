package BCC.Semestre2.POO.Unit5.RangoJa;

import java.util.Locale;

final class Moeda {

    private static final Locale PT_BR = Locale.forLanguageTag("pt-BR");

    private Moeda() {
    }

    static String formatar(double valor) {
        return String.format(PT_BR, "R$ %.2f", valor);
    }
}
