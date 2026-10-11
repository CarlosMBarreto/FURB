/**
 * Herdanca ENTRE INTERFACES: Reproduzivel extends Cronometravel.
 * Tudo que e reproduzivel tambem e cronometravel (tem duracao) e,
 * alem disso, precisa saber reproduzir().
 */
public interface Reproduzivel extends Cronometravel {

    void reproduzir();
}