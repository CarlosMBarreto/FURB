package BCC.Semestre2.POO.RevisaoProva.SetupGamer;

public class Entrega {
    private String cidade;
    private int prazoDias;

    public Entrega(String cidade, int prazoDias){
        this.cidade = cidade;
        this.prazoDias = prazoDias;
    }

    public String getCidade(){
        return cidade;
    }

    public int getPrazoDias(){
        return prazoDias;
    }
}
