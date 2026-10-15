package BCC.Semestre2.POO.Unit5.RangoJa;

import java.util.ArrayList;
import java.util.Locale;

public class CentralCobranca {

    // Associação CentralCobranca -> Cobravel (0..*), papel "cobrancas".
    private ArrayList<Cobravel> cobrancas = new ArrayList<>();

    // Aceita qualquer Cobravel (Pedido, AssinaturaClube...).
    public void registrar(Cobravel cobranca) {
        if (cobranca == null) {
            throw new IllegalArgumentException("A cobrança não pode ser nula.");
        }
        cobrancas.add(cobranca);
    }

    // Um único laço, sem instanceof nem cast: polimorfismo via interface.
    public double calcularTotalAReceber() {
        double total = 0;
        for (Cobravel cobranca : cobrancas) {
            total += cobranca.calcularValorCobrar();
        }
        return total;
    }

    public int getQuantidadeCobrancas() {
        return cobrancas.size();
    }

    public String gerarRelatorio() {
        StringBuilder relatorio = new StringBuilder();
        for (Cobravel cobranca : cobrancas) {
            relatorio.append(cobranca.gerarComprovante()).append("\n");
        }
        relatorio.append(String.format(Locale.forLanguageTag("pt-BR"),
                "Total a receber: R$ %.2f", calcularTotalAReceber()));
        return relatorio.toString();
    }
}
