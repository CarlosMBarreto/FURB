package BCC.Semestre2.POO.Unit5.RangoJa;

import java.util.ArrayList;
import java.util.List;

public class CentralCobranca {

    private final List<Cobravel> cobrancas = new ArrayList<>();

    public void registrar(Cobravel cobravel) {
        if (cobravel == null) {
            throw new IllegalArgumentException("Cobrança não pode ser nula");
        }
        cobrancas.add(cobravel);
    }

    public int getQuantidadeCobrancas() {
        return cobrancas.size();
    }

    public double calcularTotalAReceber() {
        double total = 0;
        for (Cobravel c : cobrancas) {
            total += c.calcularValorCobrar();
        }
        return total;
    }

    public String gerarRelatorio() {
        StringBuilder sb = new StringBuilder();
        for (Cobravel c : cobrancas) {
            sb.append(c.gerarComprovante()).append("\n");
        }
        sb.append("Total a receber: ").append(Moeda.formatar(calcularTotalAReceber()));
        return sb.toString();
    }
}
