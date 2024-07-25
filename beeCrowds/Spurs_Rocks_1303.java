import java.util.*;

class Equipe {
    int qtsPontos;
    int marcadas;
    int sofridas;
    int id;

    public Equipe(int id) {
        this.id = id;
    }
}

public class Spurs_Rocks_1303 {
    static final int MAXSIZE = 105;
    static Equipe[] times = new Equipe[MAXSIZE];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int instancia = 0;
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            if (n == 0) break;

            if (instancia != 0) System.out.println();

            int tmp = n * (n - 1) / 2;
            for (int i = 0; i < tmp; ++i) {
                int id1 = sc.nextInt();
                int pt1 = sc.nextInt();
                int id2 = sc.nextInt();
                int pt2 = sc.nextInt();

                if (times[id1] == null) times[id1] = new Equipe(id1);
                if (times[id2] == null) times[id2] = new Equipe(id2);

                if (pt1 > pt2) {
                    times[id1].qtsPontos += 2;
                    times[id2].qtsPontos += 1;
                } else {
                    times[id2].qtsPontos += 2;
                    times[id1].qtsPontos += 1;
                }

                times[id1].marcadas += pt1;
                times[id1].sofridas += pt2;
                times[id2].marcadas += pt2;
                times[id2].sofridas += pt1;
            }

            Arrays.sort(times, 1, n + 1, Spurs_Rocks_1303::compara);

            boolean flag = false;
            System.out.printf("Instancia %d\n", ++instancia);
            for (int i = 1; i <= n; ++i) {
                if (flag) System.out.printf(" %d", times[i].id);
                else System.out.printf("%d", times[i].id);
                flag = true;
            }

            System.out.println();
            Arrays.fill(times, null);
        }

        sc.close();
    }

    static int compara(Equipe a, Equipe b) {
        if (a.qtsPontos == b.qtsPontos) {
            if (a.sofridas == 0) a.sofridas = 1;
            if (b.sofridas == 0) b.sofridas = 1;

            double ratioA = (double) a.marcadas / a.sofridas;
            double ratioB = (double) b.marcadas / b.sofridas;

            if (ratioA == ratioB) {
                if (a.marcadas == b.marcadas) {
                    return Integer.compare(b.id, a.id);
                } else {
                    return Integer.compare(b.marcadas, a.marcadas);
                }
            } else {
                return Double.compare(ratioB, ratioA);
            }
        } else {
            return Integer.compare(b.qtsPontos, a.qtsPontos);
        }
    }
}