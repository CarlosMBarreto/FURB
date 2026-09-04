import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class PlaylistTest {

    private Usuario usuario;
    private Playlist playlist;

    @BeforeEach
    void setUp() {
        usuario = new Usuario("carlos", "carlos@teste.com");
        playlist = new Playlist("Playlist", usuario);
    }

    // PL03
    @Test
    @DisplayName("Adicionar música em playlist vazia")
    void testeAdicionarMusicaEmPlaylistVazia() {
        Musica musica = new Musica("Musica A", "Artista A", 100);

        assertTrue(playlist.adicionar(musica));
        assertEquals(1, playlist.getQuantidade());
    }

    @Test
    @DisplayName("Adicionar música em playlist com espaço")
    void testeAdicionarMusicaEmPlaylistComEspaco() {
        Musica musica1 = new Musica("Musica A", "Artista A", 100);
        Musica musica2 = new Musica("Musica B", "Artista B", 200);

        assertTrue(playlist.adicionar(musica1));
        assertTrue(playlist.adicionar(musica2));
        assertEquals(2, playlist.getQuantidade());
    }

    @Test
    @DisplayName("Tentar adicionar música com playlist cheia")
    void testeAdicionarMusicaEmPlaylistCheia() {
        for (int i = 0; i < 100; i++) {
            Musica musica = new Musica("Musica" + i, "Artista" + i, i + 1);
            assertTrue(playlist.adicionar(musica));
        }

        Musica musica101 = new Musica("Musica101", "Artista101", 200);
        assertFalse(playlist.adicionar(musica101));
        assertEquals(100, playlist.getQuantidade());
    }

    // PL04
    @Test
    @DisplayName("Buscar música na primeira posição")
    void testeGetMusicaNoIndice0() {
        Musica musica = new Musica("Musica A", "Artista A", 10);
        playlist.adicionar(musica);

        assertEquals(musica, playlist.getNaPosicao(0));
    }

    @Test
    @DisplayName("Buscar posição com índice negativo")
    void testeGetPosicaoIndiceNegativo() {
        playlist.adicionar(new Musica("Musica A", "Artista A", 10));

        assertThrows(IndexOutOfBoundsException.class, () -> playlist.getNaPosicao(-1));
    }

    @Test
    @DisplayName("Buscar posição além da quantidade")
    void testeGetPosicaoAlemQuantidade() {
        playlist.adicionar(new Musica("Musica A", "Artista A", 10));
        playlist.adicionar(new Musica("Musica B", "Artista B", 20));

        assertThrows(IndexOutOfBoundsException.class, () -> playlist.getNaPosicao(2));
    }

    // PL05
    @Test
    @DisplayName("Remover música de uma posição válida")
    void testeRemoverPosicaoValidaReorganiza() {
        Musica queen = new Musica("Queen Song", "Queen", 100);
        Musica beatles = new Musica("Beatles Song", "Beatles", 200);
        Musica pinkFloyd = new Musica("Pink Floyd Song", "Pink Floyd", 300);
        playlist.adicionar(queen);
        playlist.adicionar(beatles);
        playlist.adicionar(pinkFloyd);

        playlist.removerNaPosicao(1);

        assertEquals(2, playlist.getQuantidade());
        assertEquals(pinkFloyd, playlist.getNaPosicao(1));
    }

    @Test
    @DisplayName("Remover a primeira música")
    void testeRemoverPrimeiraMusica() {
        Musica queen = new Musica("Queen Song", "Queen", 100);
        Musica beatles = new Musica("Beatles Song", "Beatles", 200);
        Musica pinkFloyd = new Musica("Pink Floyd Song", "Pink Floyd", 300);
        playlist.adicionar(queen);
        playlist.adicionar(beatles);
        playlist.adicionar(pinkFloyd);

        playlist.removerNaPosicao(0);

        assertEquals(2, playlist.getQuantidade());
        assertEquals(beatles, playlist.getNaPosicao(0));
    }

    @Test
    @DisplayName("Remover usando índice negativo")
    void testeRemoverIndiceNegativo() {
        playlist.adicionar(new Musica("Musica A", "Artista A", 100));

        assertThrows(IndexOutOfBoundsException.class, () -> playlist.removerNaPosicao(-1));
    }

    @Test
    @DisplayName("Remover usando índice além da quantidade")
    void testeRemoverIndiceAlemQuantidade() {
        playlist.adicionar(new Musica("Musica A", "Artista A", 100));
        playlist.adicionar(new Musica("Musica B", "Artista B", 200));
        playlist.adicionar(new Musica("Musica C", "Artista C", 300));

        assertThrows(IndexOutOfBoundsException.class, () -> playlist.removerNaPosicao(3));
    }
}