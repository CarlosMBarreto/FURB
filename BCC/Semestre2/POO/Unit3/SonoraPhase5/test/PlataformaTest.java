import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class PlataformaTest {

    private Plataforma plataforma;
    private Musica musicaCadastrada;

    @BeforeEach
    void setUp() {
        plataforma = new Plataforma();
        musicaCadastrada = new Musica("Neon Tide", "The Drift", 355);
        plataforma.cadastrarMusica(musicaCadastrada);
    }

    // PL06
    @Test
    @DisplayName("Buscar música cadastrada pelo título")
    void testeBuscarMusicaPorTitulo() {
        assertEquals(musicaCadastrada, plataforma.buscarMusica("Neon Tide"));
    }

    @Test
    @DisplayName("Buscar música cadastrada pelo ID")
    void testeBuscarMusicaPorId() {
        assertEquals(musicaCadastrada, plataforma.buscarMusicaPorId(musicaCadastrada.getId()));
    }

    @Test
    @DisplayName("Buscar música por título inexistente")
    void testeBuscarMusicaTituloInexistente() {
        assertNull(plataforma.buscarMusica("Musica Inexistente"));
    }

    @Test
    @DisplayName("Buscar música por ID inexistente")
    void testeBuscarMusicaIdInexistente() {
        assertNull(plataforma.buscarMusicaPorId(-1));
    }

    // PL08 - bônus
    @Test
    @DisplayName("IDs de músicas são sequenciais")
    void testeIdsMusicasSequenciais() {
        Musica m1 = new Musica("Fading Signal", "Nova Wire", 100);
        Musica m2 = new Musica("Night Frequency", "The Drift", 200);
        Musica m3 = new Musica("Glass Horizon", "Echo Valley", 300);

        assertEquals(m1.getId() + 1, m2.getId());
        assertEquals(m2.getId() + 1, m3.getId());
    }

    @Test
    @DisplayName("IDs de usuários são independentes dos ids de músicas")
    void testeIdsUsuarioIndependentesDeMusica() {
        int idMusicaAntes = new Musica("Static Bloom", "Nova Wire", 100).getId();
        Usuario u1 = new Usuario("Carlin", "carlin@teste.com");
        Usuario u2 = new Usuario("Ana", "ana@teste.com");
        int idMusicaDepois = new Musica("Velvet Circuit", "The Drift", 100).getId();

        assertEquals(u1.getId() + 1, u2.getId());
        assertEquals(idMusicaAntes + 1, idMusicaDepois);
    }

    @Test
    @DisplayName("Criar novas músicas após usuários")
    void testeCriarMusicasAposUsuarios() {
        Musica m1 = new Musica("Silent Orbit", "Nova Wire", 100);
        Usuario u1 = new Usuario("Ana", "ana@teste.com");
        Musica m2 = new Musica("Hollow Sky", "The Drift", 200);

        assertEquals(m1.getId() + 1, m2.getId());
    }
}