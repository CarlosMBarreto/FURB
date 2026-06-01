public class Sala {
    int numero;
    boolean assentos[][] = new boolean[4][6];

    public Sala(int numero, boolean assentos[][]) {
        this.numero = numero;
        this.assentos = assentos;
    }

    public void exibirMapa() {
        char[] letras = { 'A', 'B', 'C', 'D' };

        System.out.println("  1  2  3  4  5  6");
        for (int lin = 0; lin < assentos.length; lin++) {
            System.out.print(letras[lin]);
            for (int col = 0; col < assentos[lin].length; col++) {
                if (assentos[lin][col]) {
                    System.out.print("[X]");
                } else {
                    System.out.print("[ ]");
                }
            }
            System.out.println();
        }
    }

    public void reservar(int fileira, int coluna) {
        if (assentos[fileira][coluna]) {
            System.out.println("Assento já ocupado!");
        } else {
            assentos[fileira][coluna] = true;
            System.out.println("Reserva confirmada!");
        }
    }

    public void cancelar(int fileira, int coluna) {
        if (assentos[fileira][coluna]) {
            assentos[fileira][coluna] = false;
            System.out.println("Reserva cancelada!");
        } else {
            System.out.println("Assento vago!");
        }
    }

    public void percentualOcupacao() {
        int ocupados = 0;
        for (int i = 0; i < assentos.length; i++) {
            for (int j = 0; j < assentos[i].length; j++) {
                if (assentos[i][j]) {
                    ocupados++;
                }
            }
        }
        double porcentagem = (ocupados / 24.0) * 100;
        System.out.printf("%.2f%%\n", porcentagem);
    }
}
