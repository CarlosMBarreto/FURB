import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class App {

    private static Scanner scanner = new Scanner(System.in);
    private static Plataforma plataforma = new Plataforma();
    private static ArrayList<Playlist> playlists = new ArrayList<>();

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
                    case 8:
                        seguirUsuario();
                        break;
                    case 9:
                        deixarDeSeguirUsuario();
                        break;
                    case 10:
                        listarQuemUsuarioSegue();
                        break;
                    case 11:
                        trocarPlanoDoUsuario();
                        break;
                    case 12:
                        exibirResumoDoPlano();
                        break;
                    case 13:
                        demonstrarConteudos();
                        break;
                    case 0:
                        System.out.println("Encerrando o Sonora...");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Opção inválida.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Valor invalido. Digite um numero.");
            } catch (IllegalArgumentException | IndexOutOfBoundsException e) {
                System.out.println("Nao foi possivel concluir: " + e.getMessage());
            } catch (NoSuchElementException e) {
                System.out.println("Entrada encerrada. Encerrando o Sonora...");
                return;
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
        System.out.println("8 - Seguir usuário");
        System.out.println("9 - Deixar de seguir usuário");
        System.out.println("10 - Listar quem um usuário segue");
        System.out.println("11 - Trocar plano de um usuário");
        System.out.println("12 - Exibir resumo do plano de um usuário");
        System.out.println("13 - Demonstração: músicas e podcasts");
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

    private static double lerDouble(String mensagem) {
        while (true) {
            System.out.print(mensagem);
            String entrada = scanner.nextLine().trim().replace(',', '.');
            try {
                return Double.parseDouble(entrada);
            } catch (NumberFormatException e) {
                System.out.println("Valor invalido. Digite um numero (ex.: 19.90).");
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
        String album = lerString("Álbum: ");
        int duracao = lerInt("Duração em segundos: ");

        try {
            Musica musica = new Musica(titulo, duracao, artista, album);
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

        int idUsuario = lerInt("Id do usuário dono da playlist: ");
        Usuario dono = buscarUsuarioPorId(idUsuario);

        if (dono == null) {
            System.out.println("Usuário não encontrado!");
            return;
        }

        String nomePlaylist = lerString("Nome da playlist: ");
        Playlist playlist = new Playlist(nomePlaylist, dono);
        playlists.add(playlist);

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
                    playlist.adicionar(musica);
                    System.out.println("Música adicionada!");
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
            if (playlists.isEmpty()) {
                System.out.println("Nenhuma playlist cadastrada.");
                return;
            }
            System.out.print("Posicao da musica na playlist: ");
            int pos = Integer.parseInt(scanner.nextLine());
            Musica musica = playlists.get(0).getNaPosicao(pos);
            musica.reproduzir();
            System.out.println("Total de reproducoes de \"" + musica.getTitulo() + "\": "
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
        for (Playlist p : playlists) {
            System.out.println(p.getNome() + " - dono: " + p.getDono().getNome()
                    + " - " + p.getQuantidade() + " músicas - "
                    + p.getDuracaoTotalSegundos() + "s");
        }
    }

    private static void seguirUsuario() {
        int idQuemSegue = lerInt("Id de quem vai seguir: ");
        Usuario quemSegue = buscarUsuarioPorId(idQuemSegue);
        if (quemSegue == null) {
            System.out.println("Usuário não encontrado!");
            return;
        }

        int idSeguido = lerInt("Id do usuário a seguir: ");
        Usuario seguido = buscarUsuarioPorId(idSeguido);
        if (seguido == null) {
            System.out.println("Usuário não encontrado!");
            return;
        }

        quemSegue.seguir(seguido);
        System.out.println(quemSegue.getNome() + " agora segue " + seguido.getNome() + ".");
    }

    private static void deixarDeSeguirUsuario() {
        int idQuemSegue = lerInt("Id de quem vai deixar de seguir: ");
        Usuario quemSegue = buscarUsuarioPorId(idQuemSegue);
        if (quemSegue == null) {
            System.out.println("Usuário não encontrado!");
            return;
        }

        int idSeguido = lerInt("Id do usuário a deixar de seguir: ");
        Usuario seguido = buscarUsuarioPorId(idSeguido);
        if (seguido == null) {
            System.out.println("Usuário não encontrado!");
            return;
        }

        quemSegue.deixarDeSeguir(seguido);
        System.out.println(quemSegue.getNome() + " deixou de seguir " + seguido.getNome() + ".");
    }

    private static void listarQuemUsuarioSegue() {
        int id = lerInt("Id do usuário: ");
        Usuario usuario = buscarUsuarioPorId(id);
        if (usuario == null) {
            System.out.println("Usuário não encontrado!");
            return;
        }

        int quantidade = usuario.getQuantidadeSeguindo();
        if (quantidade == 0) {
            System.out.println(usuario.getNome() + " não segue ninguém.");
            return;
        }

        System.out.println(usuario.getNome() + " segue " + quantidade + " usuário(s):");
        for (int i = 0; i < quantidade; i++) {
            Usuario seguido = usuario.getSeguindoNaPosicao(i);
            System.out.println("- " + seguido.getNome());
        }
    }

    private static void trocarPlanoDoUsuario() {
        int id = lerInt("Id do usuário: ");
        Usuario usuario = buscarUsuarioPorId(id);
        if (usuario == null) {
            System.out.println("Usuário não encontrado!");
            return;
        }

        System.out.println("Planos: 1 - Gratuito | 2 - Individual | 3 - Família");
        int escolha = lerInt("Escolha o plano: ");

        Plano novoPlano;
        switch (escolha) {
            case 1:
                novoPlano = new PlanoGratuito();
                break;
            case 2:
                novoPlano = new PlanoIndividual(lerDouble("Preço mensal (R$): "));
                break;
            case 3:
                double preco = lerDouble("Preço mensal base (R$): ");
                int membros = lerInt("Quantidade de membros (1 a 6): ");
                novoPlano = new PlanoFamilia(preco, membros);
                break;
            default:
                System.out.println("Plano inválido.");
                return;
        }

        usuario.assinar(novoPlano);
        System.out.println(usuario.getNome() + " agora está no plano: " + usuario.getPlano().resumo());
    }

    private static void exibirResumoDoPlano() {
        int id = lerInt("Id do usuário: ");
        Usuario usuario = buscarUsuarioPorId(id);
        if (usuario == null) {
            System.out.println("Usuário não encontrado!");
            return;
        }

        Plano plano = usuario.getPlano();
        System.out.println(usuario.getNome() + " -> " + plano.resumo()
                + (plano.temAnuncios() ? " (com anúncios)" : " (sem anúncios)"));
    }

    private static void demonstrarConteudos() {
        Musica bohemian = new Musica("Bohemian Rhapsody", 354, "Queen", "A Night at the Opera");
        Musica imagine = new Musica("Imagine", 183, "John Lennon", "Imagine");
        Podcast podcast = new Podcast("Como funciona a heranca", 1800, "Ana Souza", 12);

        // Nao compila: Conteudo e abstrata.
        // Conteudo c = new Conteudo("Generico", 120);
        // Erro: "Conteudo is abstract; cannot be instantiated". Uma classe abstrata
        // representa um conceito generico (nao existe "conteudo" que nao seja musica
        // nem podcast), por isso o compilador proibe criar objetos dela.

        // Nao compila: Plano e abstrata.
        // Plano p = new Plano("Generico", 1);
        // Erro: "Plano is abstract; cannot be instantiated". Mesmo motivo: ninguem
        // assina um "plano" generico, so Gratuito, Individual ou Familia.

        // Nao compila: PlanoGratuito e final.
        // class PlanoGratuitoPlus extends PlanoGratuito { }
        // Erro: "cannot inherit from final PlanoGratuito". final em classe impede a
        // extensao, garantindo que ninguem sobrescreva temAnuncios() e tire os
        // anuncios do plano gratuito.

        System.out.println("\n--- toString() de cada conteúdo ---");
        System.out.println(bohemian);
        System.out.println(imagine);
        System.out.println(podcast);

        System.out.println("\n--- Reproduzindo (reproduzir() vem de Conteudo) ---");
        bohemian.reproduzir();
        bohemian.reproduzir();
        bohemian.reproduzir();
        imagine.reproduzir();
        podcast.reproduzir();
        podcast.reproduzir();

        System.out.println("\n--- Contador de reproduções ---");
        System.out.println(bohemian.getTitulo() + ": " + bohemian.getReproducoes());
        System.out.println(imagine.getTitulo() + ": " + imagine.getReproducoes());
        System.out.println(podcast.getTitulo() + ": " + podcast.getReproducoes());
    }

    private static Usuario buscarUsuarioPorId(int id) {
        for (int i = 0; i < plataforma.getTotalUsuarios(); i++) {
            Usuario u = plataforma.getUsuarioCadastrado(i);
            if (u.getId() == id) {
                return u;
            }
        }
        return null;
    }

    private static void imprimirMusica(Musica musica) {
        System.out.println(musica.getId() + " - " + musica.getTitulo() + " - " + musica.getArtista()
                + " - " + musica.getDuracaoFormatada() + " - reproduções: " + musica.getReproducoes());
    }
}