
import java.util.Scanner;

public class App {

    private static Scanner scanner = new Scanner(System.in);
    private static Plataforma plataforma = new Plataforma();

    private static Playlist[] playlists = new Playlist[100];
    private static int totalPlaylists = 0;

    public static void main(String[] args) {

        int opcao;

        while (true) {
            try {
                exibirMenu();
                opcao = lerInt("Escolha uma opção: ");
                switch (opcao) {
                    case 1:
                        cadastrarMusicaManualmente();
                        break;
                    case 2:
                        cadastrarUsuario();
                        break;
                    case 3:
                        criarPlaylistEAdicionarMusicas();
                        break;
                    case 4:
                        buscarMusicaPorId();
                        break;
                    case 5:
                        buscarMusicaPorTitulo();
                        break;
                    case 6:
                        reproduzirUmaMusica();
                        break;
                    case 7:
                        listarAcervo();
                        break;
                    case 0:
                        System.out.println("Encerrando o Sonora...");
                        scanner.close();
                        return;
                }

            } catch (NumberFormatException e) {
                System.out.println("Valor invalido. Digite um numero.");
            }
        }
    }

    private static void exibirMenu() {
        System.out.println("\n=== Sonora ===");
        System.out.println("1 - Cadastrar música manualmente");
        System.out.println("2 - Cadastrar usuário");
        System.out.println("3 - Criar playlist e adicionar músicas");
        System.out.println("4 - Buscar música por id");
        System.out.println("5 - Buscar música por título");
        System.out.println("6 - Reproduzir uma música");
        System.out.println("7 - Listar acervo");
        System.out.println("0 - Sair");
    }

    private static int lerInt(String mensagem) {
        while (true) {
            System.out.print(mensagem);
            String entrada = scanner.nextLine();
            try {
                return Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                System.out.println("Valor invalido. Digite um numero.");
            }
        }
    }

    private static String lerString(String mensagem) {
        System.out.print(mensagem);
        return scanner.nextLine();
    }

    private static void cadastrarMusicaManualmente() {
        String titulo = lerString("Título: ");
        String artista = lerString("Artista: ");
        int duracao = lerInt("Duração em segundos: ");

        try {
            Musica musica = new Musica(titulo, artista, duracao);
            plataforma.cadastrarMusica(musica);
            System.out.println("Música cadastrada com id " + musica.getId());
        } catch (IllegalArgumentException e) {
            System.out.println("Nao foi possivel cadastrar: " + e.getMessage());
        }
    }

    private static void cadastrarUsuario() {
        String nome = lerString("Nome: ");
        String email = lerString("Email: ");

        try {
            Usuario usuario = new Usuario(nome, email);
            plataforma.cadastrarUsuario(usuario);
            System.out.println("Usuario cadastrado com id " + usuario.getId());
        } catch (IllegalArgumentException e) {
            System.out.println("Nao foi possivel cadastrar: " + e.getMessage());
        }
    }

    private static void criarPlaylistEAdicionarMusicas() {
        if (plataforma.getTotalUsuarios() == 0) {
            System.out.println("Cadastre um usuário antes de criar uma playlist!");
            return;
        }

        if (totalPlaylists >= playlists.length) {
            System.out.println("Limite de playlists atingido!");
            return;
        }

        int idUsuario = lerInt("Id do usuário dono da playlist: ");
        Usuario dono = null;
        for (int i = 0; i < plataforma.getTotalUsuarios(); i++) {
            Usuario u = plataforma.getUsuarioCadastrado(i);
            if (u.getId() == idUsuario) {
                dono = u;
                break;
            }
        }

        if (dono == null) {
            System.out.println("Usuário não encontrado!");
            return;
        }

        String nomePlaylist = lerString("Nome da playlist: ");
        Playlist playlist = new Playlist(nomePlaylist, dono);
        playlists[totalPlaylists] = playlist;
        totalPlaylists++;

        System.out.println("Playlist criada. Agora adicione as músicas!");

        int idMusica;
        do {
            idMusica = lerInt("Id da música para adicionar (-1 para parar): ");
            if (idMusica != -1) {
                Musica musica = plataforma.buscarMusicaPorId(idMusica);
                if (musica == null) {
                    System.out.println("Música não encontrada!");
                } else if (playlist.contemMusica(musica)) {
                    System.out.println("Música já está na playlist!");
                } else {
                    boolean sucesso = playlist.adicionar(musica);
                    if (sucesso) {
                        System.out.println("Música adicionada!");
                    } else {
                        System.out.println("Não foi possível adicionar (playlist cheia).");
                    }
                }
            }
        } while (idMusica != -1);

        System.out.println("Playlist \"" + playlist.getNome() + "\" tem " + playlist.getQuantidade()
                + " músicas, duração total de " + playlist.getDuracaoTotalSegundos() + " segundos.");
    }

    private static void buscarMusicaPorId() {
        int id = lerInt("Id da música: ");
        Musica musica = plataforma.buscarMusicaPorId(id);

        if (musica == null) {
            System.out.println("Música não encontrada.");
        } else {
            imprimirMusica(musica);
        }
    }

    private static void buscarMusicaPorTitulo() {
        String titulo = lerString("Título da música: ");
        Musica musica = plataforma.buscarMusica(titulo);

        if (musica == null) {
            System.out.println("Música não encontrada.");
        } else {
            imprimirMusica(musica);
        }
    }

    private static void reproduzirUmaMusica() {
        try {
            if (totalPlaylists == 0) {
                System.out.println("Nenhuma playlist cadastrada.");
                return;
            }
            System.out.print("Posicao da musica na playlist: ");
            int pos = Integer.parseInt(scanner.nextLine());
            Musica musica = playlists[0].getNaPosicao(pos);
            musica.reproduzir();
            System.out.println("Reproduzindo \"" + musica.getTitulo() + "\". Total de reproducoes: "
                    + musica.getReproducoes());
        } catch (NumberFormatException e) {
            System.out.println("A posicao precisa ser um numero.");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Essa posicao nao existe na playlist: " + e.getMessage());
        } finally {
            System.out.println("--- Operacao de reproducao finalizada ---");
        }
    }

    private static void listarAcervo() {
        System.out.println("\n--- Acervo de músicas ---");
        for (int i = 0; i < plataforma.getTotalMusicas(); i++) {
            imprimirMusica(plataforma.getMusicaNoAcervo(i));
        }

        System.out.println("\n--- Usuários cadastrados ---");
        for (int i = 0; i < plataforma.getTotalUsuarios(); i++) {
            Usuario u = plataforma.getUsuarioCadastrado(i);
            System.out.println(u.getId() + " - " + u.getNome() + " (" + u.getEmail() + ")");
        }

        System.out.println("\n--- Playlists ---");
        for (int i = 0; i < totalPlaylists; i++) {
            Playlist p = playlists[i];
            System.out.println(p.getNome() + " - dono: " + p.getDono().getNome()
                    + " - " + p.getQuantidade() + " músicas - "
                    + p.getDuracaoTotalSegundos() + "s");
        }
    }

    private static void imprimirMusica(Musica musica) {
        System.out.println(musica.getId() + " - " + musica.getTitulo() + " - " + musica.getArtista()
                + " - " + musica.getDuracaoFormatada() + " - reproduções: " + musica.getReproducoes());
    }
}
