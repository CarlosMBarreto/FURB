import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class MusicaTest {

    private Musica musicaBase;

    @BeforeEach
    void setUp() {
        musicaBase = new Musica("Silent Orbit", "Echo Valley", 200);
    }

    // PL01
    @Test
    @DisplayName("Duração com minutos e segundos")
    void testeGetDuracaoSegundos125s() {
        Musica musica = new Musica("Fading Signal", "Nova Wire", 125);
        assertEquals("02:05", musica.getDuracaoFormatada());
    }

    @Test
    @DisplayName("Duração redonda em minutos")
    void testeGetDuracaoRedondaEmMinutos() {
        Musica musica = new Musica("Night Frequency", "Nova Wire", 90);
        assertEquals("01:30", musica.getDuracaoFormatada());
    }

    @Test
    @DisplayName("Menos de um minuto, com zero à esquerda")
    void testeGetDuracao5s() {
        Musica musica = new Musica("Glass Horizon", "Nova Wire", 5);
        assertEquals("00:05", musica.getDuracaoFormatada());
    }

    @Test
    @DisplayName("Dois dígitos nos minutos")
    void testeGetDuracao600s() {
        Musica musica = new Musica("Static Bloom", "Nova Wire", 600);
        assertEquals("10:00", musica.getDuracaoFormatada());
    }

    @Test
    @DisplayName("Valor logo abaixo de dez minutos")
    void testeGetDuracao599s() {
        Musica musica = new Musica("Velvet Circuit", "Nova Wire", 599);
        assertEquals("09:59", musica.getDuracaoFormatada());
    }

    // PL02
    @Test
    @DisplayName("Título vazio deve ser rejeitado")
    void testeGetTituloVazio() {
        assertThrows(IllegalArgumentException.class, () -> new Musica("", "The Drift", 355));
    }

    @Test
    @DisplayName("Título nulo deve ser rejeitado")
    void testeGetTituloNulo() {
        assertThrows(IllegalArgumentException.class, () -> new Musica(null, "The Drift", 355));
    }

    @Test
    @DisplayName("Artista vazio deve ser rejeitado")
    void testeGetArtistaVazio() {
        assertThrows(IllegalArgumentException.class, () -> new Musica("Neon Tide", "", 355));
    }

    @Test
    @DisplayName("Duração zero deve ser rejeitada")
    void testeGetDuracaoZero() {
        assertThrows(IllegalArgumentException.class, () -> new Musica("Neon Tide", "The Drift", 0));
    }

    @Test
    @DisplayName("Duração negativa deve ser rejeitada")
    void testeGetDuracaoNegativa() {
        assertThrows(IllegalArgumentException.class, () -> new Musica("Neon Tide", "The Drift", -10));
    }

    @Test
    @DisplayName("Dados válidos criam a música")
    void testeGetDadosValidos() {
        Musica musica = new Musica("Neon Tide", "The Drift", 355);
        assertEquals("Neon Tide", musica.getTitulo());
        assertEquals("The Drift", musica.getArtista());
        assertEquals(355, musica.getDuracaoSegundos());
        assertTrue(musica.getId() > 0);
    }

    // PL07
    @Test
    @DisplayName("Reproduzir música uma vez")
    void testeReproduzirUmaVez() {
        musicaBase.reproduzir();
        assertEquals(1, musicaBase.getReproducoes());
    }

    @Test
    @DisplayName("Reproduzir música duas vezes")
    void testeReproduzirDuasVezes() {
        musicaBase.reproduzir();
        musicaBase.reproduzir();
        assertEquals(2, musicaBase.getReproducoes());
    }

    @Test
    @DisplayName("Reproduzir música várias vezes")
    void testeReproduzirVariasVezes() {
        for (int i = 0; i < 5; i++) {
            musicaBase.reproduzir();
        }
        assertEquals(5, musicaBase.getReproducoes());
    }
}