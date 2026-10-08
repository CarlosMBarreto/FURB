/*
 * PARA PENSAR: depois das duas rodadas, sobra aqui apenas o calculo da mensalidade
 * (e o construtor que fixa nome "Individual" e 1 dispositivo). Se o calculo simples
 * subisse para PlanoPago, esta classe ficaria vazia.
 * Em geral, uma classe que fica vazia depois da generalizacao e sinal de que ela
 * talvez nem precise existir. Mesmo assim, aqui ela se mantem porque:
 *  1) PlanoPago e abstrata e nao pode ser instanciada, entao precisa haver uma
 *     subclasse concreta que represente o plano Individual;
 *  2) "Individual" e um conceito do dominio (nome e limite de dispositivos proprios);
 *  3) a mensalidade do Individual e uma regra que pode mudar sem afetar o Familia.
 * Por isso a hierarquia foi mantida como pedida.
 */
public class PlanoIndividual extends PlanoPago {

    public PlanoIndividual(double precoMensal) {
        super("Individual", 1, precoMensal);
    }

    @Override
    public double calcularMensalidade() {
        return getPrecoMensal();
    }
}
