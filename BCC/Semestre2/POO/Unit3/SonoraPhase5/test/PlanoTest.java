import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class PlanoTest {

    @Test
    @DisplayName("Plano gratuito: sem custo, com anuncios, 1 dispositivo")
    void testePlanoGratuito() {
        Plano p = new PlanoGratuito();
        assertEquals("Gratuito", p.getNome());
        assertEquals(1, p.getMaxDispositivos());
        assertTrue(p.temAnuncios());
        assertEquals(0.0, p.calcularMensalidade());
        assertEquals("Gratuito: R$ 0.0 por mes, 1 dispositivo(s)", p.resumo());
    }

    @Test
    @DisplayName("Plano individual: mensalidade igual ao preco")
    void testePlanoIndividual() {
        Plano p = new PlanoIndividual(21.90);
        assertEquals("Individual", p.getNome());
        assertFalse(p.temAnuncios());
        assertEquals(21.90, p.calcularMensalidade(), 0.001);
        assertEquals("Individual: R$ 21.9 por mes, 1 dispositivo(s)", p.resumo());
    }

    @Test
    @DisplayName("Plano familia: adicional por membro extra")
    void testePlanoFamilia() {
        Plano p = new PlanoFamilia(34.90, 3);
        assertEquals("Familia", p.getNome());
        assertEquals(6, p.getMaxDispositivos());
        assertFalse(p.temAnuncios());
        assertEquals(34.90 + 4.90 * 2, p.calcularMensalidade(), 0.001);
    }

    @Test
    @DisplayName("Preco nao positivo e rejeitado nos planos pagos")
    void testePrecoInvalido() {
        assertThrows(IllegalArgumentException.class, () -> new PlanoIndividual(0));
        assertThrows(IllegalArgumentException.class, () -> new PlanoFamilia(-5, 2));
        PlanoPago pago = new PlanoIndividual(10);
        assertThrows(IllegalArgumentException.class, () -> pago.setPrecoMensal(-1));
        assertEquals(10, pago.getPrecoMensal(), 0.001);
    }

    @Test
    @DisplayName("Membros do plano familia devem ser de 1 a 6")
    void testeMembrosInvalidos() {
        assertThrows(IllegalArgumentException.class, () -> new PlanoFamilia(30, 0));
        assertThrows(IllegalArgumentException.class, () -> new PlanoFamilia(30, 7));
        assertEquals(6, new PlanoFamilia(30, 6).getQuantidadeMembros());
    }

    @Test
    @DisplayName("Hierarquia: planos pagos herdam de PlanoPago, gratuito direto de Plano")
    void testeHierarquia() {
        assertEquals(PlanoPago.class, PlanoIndividual.class.getSuperclass());
        assertEquals(PlanoPago.class, PlanoFamilia.class.getSuperclass());
        assertEquals(Plano.class, PlanoGratuito.class.getSuperclass());
        assertEquals(Plano.class, PlanoPago.class.getSuperclass());
    }

    @Test
    @DisplayName("Modificadores abstract e final")
    void testeModificadores() {
        assertTrue(java.lang.reflect.Modifier.isAbstract(Plano.class.getModifiers()));
        assertTrue(java.lang.reflect.Modifier.isAbstract(PlanoPago.class.getModifiers()));
        assertTrue(java.lang.reflect.Modifier.isAbstract(Conteudo.class.getModifiers()));
        assertTrue(java.lang.reflect.Modifier.isFinal(PlanoGratuito.class.getModifiers()));
        assertTrue(java.lang.reflect.Modifier.isFinal(findResumo().getModifiers()));
    }

    private java.lang.reflect.Method findResumo() {
        try {
            return Plano.class.getMethod("resumo");
        } catch (NoSuchMethodException e) {
            throw new AssertionError(e);
        }
    }

    @Test
    @DisplayName("Usuario novo comeca no plano gratuito")
    void testeUsuarioComecaGratuito() {
        Usuario u = new Usuario("Ana", "ana@teste.com");
        assertTrue(u.getPlano() instanceof PlanoGratuito);
    }

    @Test
    @DisplayName("Usuario pode assinar outro plano")
    void testeAssinar() {
        Usuario u = new Usuario("Ana", "ana@teste.com");
        Plano individual = new PlanoIndividual(19.90);
        u.assinar(individual);
        assertSame(individual, u.getPlano());
    }

    @Test
    @DisplayName("Assinar plano nulo lanca excecao e mantem o plano atual")
    void testeAssinarNulo() {
        Usuario u = new Usuario("Ana", "ana@teste.com");
        Plano atual = u.getPlano();
        assertThrows(IllegalArgumentException.class, () -> u.assinar(null));
        assertSame(atual, u.getPlano());
    }
}
