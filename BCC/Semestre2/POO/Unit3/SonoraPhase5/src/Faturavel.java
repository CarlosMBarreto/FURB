/**
 * INTERFACE: um "contrato". Quem implementa Faturavel promete ter o metodo
 * calcularMensalidade(), ou seja, "sei dizer quanto dinheiro eu gero por mes".
 * Plano e Anuncio nao tem parentesco (nenhum herda do outro), mas os dois
 * cumprem esse contrato. Por isso a Plataforma consegue somar os dois
 * usando um unico ArrayList<Faturavel>.
 */
public interface Faturavel {

    double calcularMensalidade();
}