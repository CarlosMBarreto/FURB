/**
 * Contrato de tudo que tem duracao. Tem um metodo abstrato (getDuracaoSegundos)
 * e um metodo default (getDuracaoFormatada), que ja vem pronto para quem
 * implementar. O default so pode usar outros metodos da interface, porque
 * interfaces nao tem atributos.
 */
public interface Cronometravel {

    int getDuracaoSegundos();

    default String getDuracaoFormatada() {
        int total = getDuracaoSegundos();
        int minutos = total / 60;
        int segundos = total % 60;
        if (segundos < 10) {
            return minutos + ":0" + segundos;
        }
        return minutos + ":" + segundos;
    }
}