
import java.util.Scanner;

public class Main {

    private static Scanner sc = new Scanner(System.in);

    private static Artista[] artistas = new Artista[50];
    private static int totalArtistas = 0;

    private static Album[] albuns = new Album[50];
    private static int totalAlbuns = 0;

    private static Musica[] musicas = new Musica[100];
    private static int totalMusicas = 0;

    private static Playlist[] playlists = new Playlist[50];
    private static int totalPlaylists = 0;

    private static Usuario[] usuarios = new Usuario[50];
    private static int totalUsuarios = 0;

    public static void main(String[] args) {
        int opcao;

        do {
            exibirMenu();
            opcao = sc.nextInt();
            switch (opcao) {
                case 1:
                    cadastrarArtista();
                    break;

                case 2:
                    cadastrarAlbum();
                    break;

                case 3:
                    cadastrarMusica();
                    break;

                case 4:
                    cadastrarPlaylist();
                    break;

                case 5:
                    cadastrarUsuario();
                    break;

                case 6:
                    adicionarMusicaEmPlaylist();
                    break;

                case 7:
                    adicionarPlaylistEmUsuario();
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        } while (opcao != 0);
    }

    private static void exibirMenu() {
        System.out.println("--- Sonora ---");
        System.out.println("1 - Cadastar Artista");
        System.out.println("2 - Cadastar Álbum");
        System.out.println("3 - Cadastar Música");
        System.out.println("4 - Cadastar Playlist");
        System.out.println("5 - Cadastar Usuário");
        System.out.println("6 - Adicionar música em Playlist");
        System.out.println("7 - Adicionar playlist em Usuário");
        System.out.println("8 - Listar tudo");
        System.out.println("0 - Sair");
    }

    private static void cadastrarArtista() {
        if (totalArtistas >= artistas.length) {
            System.out.println("Limite de artistas atingido.");
        } else {
            System.out.print("Nome do artista: ");
            String nomeArtista = sc.next();
            System.out.print("Gênero musical: ");
            String generoMusical = sc.next();
            System.out.print("País de origem: ");
            String paisOrigem = sc.next();

            Artista artista = new Artista(nomeArtista, generoMusical, paisOrigem);

            artistas[totalArtistas] = artista;
            totalArtistas++;

            System.out.println("Artista cadastrado com sucesso!");
        }
    }

    private static void cadastrarAlbum() {
        if (totalAlbuns >= albuns.length) {
            System.out.println("Limite de álbuns atingido.");
        } else if (totalArtistas == 0) {
            System.out.println("Cadastre um artista antes de cadastrar um album!");
        } else {
            System.out.print("Nome do álbum: ");
            String nomeAlbum = sc.next();
            System.out.print("Ano de lançamento: ");
            int ano = sc.nextInt();

            Artista artista = escolherArtista();

            Album album = new Album(nomeAlbum, ano, artista);
            albuns[totalAlbuns] = album;
            totalAlbuns++;
            System.out.println("Álbum cadastrado com sucesso.");
        }
    }

    private static void cadastrarMusica() {
        if (totalMusicas >= musicas.length) {
            System.out.println("Total de músicas atingidas.");
        } else {
            System.out.print("Titulo da música: ");
            String tituloMusica = sc.next();

            System.out.print("Minutos da música: ");
            int minutosMusica = sc.nextInt();

            System.out.print("Titulo da música: ");
            int segundosMusica = sc.nextInt();

            Artista artista = escolherArtista();

            Album album = escolherAlbum();

            Musica musica = new Musica(tituloMusica, minutosMusica, segundosMusica, artista, album);

            musicas[totalMusicas] = musica;
            totalMusicas++;

            System.out.println("Musica cadastrada com sucesso.");
        }
    }

    public static void cadastrarPlaylist() {
        if (totalPlaylists >= playlists.length) {
            System.out.println("Total de playlists atingidas.");
        } else {
            System.out.print("Nome da playlist:");
            String nomePlaylist = sc.next();

            Playlist playlist = new Playlist(nomePlaylist);

            playlists[totalPlaylists] = playlist;
            totalPlaylists++;
        }
        System.out.println("Playlist cadastrada com sucesso.");
    }

    public static void cadastrarUsuario() {
        if (totalUsuarios >= usuarios.length) {
            System.out.println("Total de usuarios atingidos.");
        } else {
            System.out.print("Nome do Usuario:");
            String nomeUsuario = sc.next();

            System.out.print("Email:");
            String emailUsuario = sc.next();

            Usuario usuario = new Usuario(nomeUsuario, emailUsuario);

            usuarios[totalUsuarios] = usuario;
            totalUsuarios++;
        }
        System.out.println("Usuario cadastrado com sucesso.");
    }

    private static void adicionarMusicaEmPlaylist() {

        Playlist playlist = escolherPlaylist();

        Musica musica = escolherMusica();

        boolean sucesso = playlist.adicionarMusica(musica);

        if (sucesso) {
            System.out.println("Música adicionada na playlist.");
        } else {
            System.out.println("A playlist ja esta cheia.");
        }
    }

    private static void adicionarPlaylistEmUsuario() {
        Usuario usuario = escolheUsuario();

        Playlist playlist = escolherPlaylist();

        boolean sucesso = usuario.adicionarPlaylist(playlist);

        if (sucesso) {
            System.out.println("Playlist adicionada no usuário.");
        } else {
            System.out.println("O usuário ja atingiu o limite de playlists.");
        }
    }

    private static Artista escolherArtista() {
        System.out.println("--- Artistas ---");
        for (int i = 0; i < totalArtistas; i++) {
            System.out.println("ID: " + artistas[i].getIdArtista() + " - " + artistas[i].getNomeArtista());
        }

        System.out.print("Digite o ID do artista:");
        int id = sc.nextInt();
        for (int i = 0; i < totalArtistas; i++) {
            if (artistas[i].getIdArtista() == id) {
                return artistas[i];
            }
        }
        System.out.println("Artista não encontrado.");
        return null;
    }

    private static Album escolherAlbum() {
        System.out.println("--- Albuns ---");
        for (int i = 0; i < totalAlbuns; i++) {
            System.out.println("ID: " + albuns[i].getIdAlbum() + " - " + albuns[i].getNomeAlbum());
        }

        System.out.println("Digite o ID do album: ");
        int id = sc.nextInt();
        for (int i = 0; i < totalAlbuns; i++) {
            if (albuns[i].getIdAlbum() == id) {
                return albuns[i];
            }
        }

        System.out.println("Album não encontrado.");
        return null;
    }

    private static Musica escolherMusica() {
        System.out.println("--- Músicas ---");
        for (int i = 0; i < totalMusicas; i++) {
            System.out.println("ID: " + musicas[i].getIdMusica() + " - " + musicas[i].getTituloMusica());
        }

        System.out.print("Digite o ID da música: ");
        int id = sc.nextInt();
        for (int i = 0; i < totalMusicas; i++) {
            if (musicas[i].getIdMusica() == id) {
                return musicas[i];
            }
        }

        System.out.println("Música não encontrada.");
        return null;
    }

    private static Playlist escolherPlaylist() {
        System.out.println("--- Playlists ---");
        for (int i = 0; i < totalPlaylists; i++) {
            System.out.println("ID: " + playlists[i].getIdPlaylist() + " - " + playlists[i].getNomePlaylist());
        }

        System.out.print("Digite o ID da playlist: ");
        int id = sc.nextInt();
        for (int i = 0; i < totalPlaylists; i++) {
            if (playlists[i].getIdPlaylist() == id) {
                return playlists[i];
            }
        }

        System.out.println("Playlist não encontrada.");
        return null;
    }

    private static Usuario escolheUsuario() {
        System.out.println("--- Usuarios ---");
        for (int i = 0; i < totalUsuarios; i++) {
            System.out.println("ID: " + usuarios[i].getIdUsuario() + " - " + usuarios[i].getNomeUsuario());
        }

        System.out.print("Digite o ID do usuário: ");
        int id = sc.nextInt();
        for (int i = 0; i < totalUsuarios; i++) {
            if (usuarios[i].getIdUsuario() == id) {
                return usuarios[i];
            }
        }

        System.out.println("Usuário não encontrado.");
        return null;
    }
}
