import java.util.*;

class Celula {
    int pos;
    Celula esq, dir, inf, sup;

    public Celula() {
        this.pos = 0;
        this.esq = this.dir = this.inf = this.sup = null;
    }

    public Celula(int x) {
        this.pos = x;
        this.esq = this.dir = this.inf = this.sup = null;
    }
}

class Matriz {
    private Celula inicio;
    private int linha, coluna;

    public Matriz(int linhas, int colunas) {
        int count = 1;
        inicio = new Celula(count++);
        this.linha = linhas;
        this.coluna = colunas;
        Celula i = inicio;
        for (int j = 1; j < this.coluna; j++) {
            Celula nova = new Celula(count++);
            i.dir = nova;
            nova.esq = i;
            i = nova;
        }
        Celula linhaAnterior = inicio;
        for (int k = 1; k < this.linha; k++) {
            Celula novaLinha = new Celula(count++);
            linhaAnterior.inf = novaLinha;
            novaLinha.sup = linhaAnterior;
            Celula celulaAtualLinha = novaLinha;
            Celula celulaAcima = linhaAnterior;
            for (int j = 1; j < this.coluna; j++) {
                Celula novaCelula = new Celula(count++);
                celulaAtualLinha.dir = novaCelula;
                novaCelula.esq = celulaAtualLinha;
                celulaAcima = celulaAcima.dir;
                celulaAcima.inf = novaCelula;
                novaCelula.sup = celulaAcima;
                celulaAtualLinha = novaCelula;
            }
            linhaAnterior = novaLinha;
        }
    }

    public void caminhar(int lin, int col) {
        List<Integer> percorridos = new ArrayList<>();
        Queue<Integer> fila = new LinkedList<>();
        Celula aux = inicio;

        // Setar posicao inicial
        for (int i = 0; i < lin; i++) {
            aux = aux.inf;
        }
        for (int j = 0; j < col; j++) {
            aux = aux.dir;
        }

        // Caminhar na diagonal principal (\)
        Celula diagonalPrincipal = aux;
        while (diagonalPrincipal != null) {
            percorridos.add(diagonalPrincipal.pos);
            fila.add(diagonalPrincipal.pos);
            diagonalPrincipal = (diagonalPrincipal.inf != null && diagonalPrincipal.dir != null) ? diagonalPrincipal.inf.dir : null;
        }

        // Caminhar na diagonal secundária (/)
        Celula diagonalSecundaria = aux;
        while (diagonalSecundaria != null) {
            if (!percorridos.contains(diagonalSecundaria.pos)) {
                percorridos.add(diagonalSecundaria.pos);
                fila.add(diagonalSecundaria.pos);
            }
            diagonalSecundaria = (diagonalSecundaria.sup != null && diagonalSecundaria.dir != null) ? diagonalSecundaria.sup.dir : null;
        }

        // Imprimir lista de percorridos
        System.out.println("Lista de valores percorridos: " + percorridos);

        // Imprimir valores da fila
        System.out.print("Valores na fila: ");
        while (!fila.isEmpty()) {
            System.out.print(fila.poll() + " ");
        }
        System.out.println();
    }
}

public class Xdotesouro {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int lin = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        Matriz vizinhanca = new Matriz(lin, lin);
        vizinhanca.caminhar(x, y);
        sc.close();
    }
}