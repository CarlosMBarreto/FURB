import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class UsuarioTest {

    private Usuario carlos;
    private Usuario ana;
    private Usuario bruno;

    @BeforeEach
    void setUp() {
        carlos = new Usuario("Carlos", "carlos@teste.com");
        ana = new Usuario("Ana", "ana@teste.com");
        bruno = new Usuario("Bruno", "bruno@teste.com");
    }

    @Test
    @DisplayName("Usuário pode seguir outro usuário")
    void testeSeguirUsuario() {
        carlos.seguir(ana);

        assertEquals(1, carlos.getQuantidadeSeguindo());
        assertEquals(ana, carlos.getSeguindoNaPosicao(0));
    }

    @Test
    @DisplayName("Usuário não pode seguir a si mesmo")
    void testeNaoPodeSeguirASiMesmo() {
        assertThrows(IllegalArgumentException.class, () -> carlos.seguir(carlos));
        assertEquals(0, carlos.getQuantidadeSeguindo());
    }

    @Test
    @DisplayName("Usuário não pode seguir o mesmo usuário duas vezes")
    void testeNaoPodeSeguirDuplicado() {
        carlos.seguir(ana);

        assertThrows(IllegalArgumentException.class, () -> carlos.seguir(ana));
        assertEquals(1, carlos.getQuantidadeSeguindo());
    }

    @Test
    @DisplayName("Usuário pode deixar de seguir outro usuário")
    void testeDeixarDeSeguir() {
        carlos.seguir(ana);
        carlos.seguir(bruno);

        carlos.deixarDeSeguir(ana);

        assertEquals(1, carlos.getQuantidadeSeguindo());
        assertEquals(bruno, carlos.getSeguindoNaPosicao(0));
    }

    @Test
    @DisplayName("Não é possível deixar de seguir quem não é seguido")
    void testeDeixarDeSeguirUsuarioNaoSeguido() {
        assertThrows(IllegalArgumentException.class, () -> carlos.deixarDeSeguir(ana));
    }
}
