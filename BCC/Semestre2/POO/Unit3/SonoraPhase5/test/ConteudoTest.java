import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class ConteudoTest {

    private Musica musica;
    private Podcast podcast;

    @BeforeEach
    void setUp() {
        musica = new Musica("Bohemian Rhapsody", 354, "Queen", "A Night at the Opera");
        podcast = new Podcast("Heranca na pratica", 1800, "Ana Souza", 12);
    }

    @Test
    @DisplayName("Musica e Podcast herdam de Conteudo")
    void testeHeranca() {
        assertTrue(musica instanceof Conteudo);
        assertTrue(podcast instanceof Conteudo);
    }

    @Test
    @DisplayName("Ids vem do mesmo contador de Conteudo")
    void testeIdsCompartilhados() {
        Musica m = new Musica("A", 10, "X", "Y");
        Podcast p = new Podcast("B", 10, "Z", 1);
        assertEquals(m.getId() + 1, p.getId());
    }

    @Test
    @DisplayName("Reproduzir incrementa o contador de cada conteudo")
    void testeContadorReproducoes() {
        musica.reproduzir();
        musica.reproduzir();
        podcast.reproduzir();
        assertEquals(2, musica.getReproducoes());
        assertEquals(1, podcast.getReproducoes());
    }

    @Test
    @DisplayName("getCreditos de cada subclasse")
    void testeCreditos() {
        assertEquals("Queen (A Night at the Opera)", musica.getCreditos());
        assertEquals("Ep. 12 com Ana Souza", podcast.getCreditos());
    }

    @Test
    @DisplayName("reproduzir() imprime titulo e creditos")
    void testeMensagemReproduzir() {
        java.io.ByteArrayOutputStream saida = new java.io.ByteArrayOutputStream();
        java.io.PrintStream original = System.out;
        System.setOut(new java.io.PrintStream(saida));
        try {
            musica.reproduzir();
        } finally {
            System.setOut(original);
        }
        assertEquals("Reproduzindo: Bohemian Rhapsody - Queen (A Night at the Opera)",
                saida.toString().trim());
    }

    @Test
    @DisplayName("toString sobrescrito reaproveita a superclasse")
    void testeToString() {
        assertTrue(musica.toString().startsWith("[" + musica.getId() + "] Bohemian Rhapsody (354s)"));
        assertTrue(musica.toString().endsWith("Queen (A Night at the Opera)"));
        assertTrue(podcast.toString().contains("Ep. 12"));
        assertTrue(podcast.toString().contains("Ana Souza"));
    }

    @Test
    @DisplayName("Validacoes comuns (Conteudo) e especificas (Podcast)")
    void testeValidacoes() {
        assertThrows(IllegalArgumentException.class, () -> new Podcast("", 10, "Ana", 1));
        assertThrows(IllegalArgumentException.class, () -> new Podcast("T", 0, "Ana", 1));
        assertThrows(IllegalArgumentException.class, () -> new Podcast("T", 10, "Ana", 0));
        assertThrows(IllegalArgumentException.class, () -> new Podcast("T", 10, " ", 1));
        assertThrows(IllegalArgumentException.class, () -> new Musica("T", 10, "Art", ""));
        assertThrows(IllegalArgumentException.class, () -> musica.setTitulo(null));
        assertThrows(IllegalArgumentException.class, () -> musica.setDuracaoSegundos(-1));
    }

    @Test
    @DisplayName("reproduzir() e final")
    void testeReproduzirFinal() throws NoSuchMethodException {
        assertTrue(java.lang.reflect.Modifier.isFinal(Conteudo.class.getMethod("reproduzir").getModifiers()));
    }
}
