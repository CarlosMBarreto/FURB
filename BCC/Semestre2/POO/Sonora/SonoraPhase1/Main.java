
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

                    break;
                default:
                    System.out.println("Opção inválida.");
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

    private static Artista escolherArtista() {
        System.out.println("--- Artistas disponiveis ---");
        for (int i = 0; i < artistas.length; i++) {
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
}
