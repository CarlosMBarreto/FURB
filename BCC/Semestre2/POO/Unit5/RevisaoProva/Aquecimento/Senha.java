package BCC.Semestre2.POO.RevisaoProva.Aquecimento;

public class Senha {

    private int numero;
    private String setor;

    private static int totalEmitidas = 0;

    public Senha(String setor) {

        if (setor == null || setor.isEmpty()) {
            throw new IllegalArgumentException("Setor obrigatório");
        }
        this.setor = setor;

        this.numero = ++totalEmitidas;
    }

    public int getNumero() {
        return numero;
    }

    public String getSetor() {
        return setor;
    }


    public static int getTotalEmitidas() {
        return totalEmitidas;
    }

    @Override
    public String toString() {
        return numero + " - " + setor;
    }

}
