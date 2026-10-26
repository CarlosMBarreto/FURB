package BCC.Semestre2.POO.RevisaoProva.Aquecimento;

import java.util.ArrayList;

public class PrincipalCatalogo {

    public static void main(String[] args) {

        Midia f = new Filme("Interestelar", 20.0);
        Midia s = new Serie("Dark", 15.0, 3);

        ArrayList<Midia> catalogo = new ArrayList<>();
        catalogo.add(f);
        catalogo.add(s);

        catalogo.add(new Documentario("Our Planet", 10.0));

        double totalColega = 0;
        for (Midia m : catalogo) {
            if (m instanceof Serie) {
                totalColega += ((Serie) m).calcularCustoLegenda();
            }
        }
        System.out.println("Legenda (laço do colega): R$ " + totalColega);

        double totalLegenda = 0;
        for (Midia m : catalogo) {
            if (m instanceof Legendavel) {
                totalLegenda += ((Legendavel) m).calcularCustoLegenda();
            }
        }
        System.out.println("Legenda (laço corrigido): R$ " + totalLegenda);
    }
}
