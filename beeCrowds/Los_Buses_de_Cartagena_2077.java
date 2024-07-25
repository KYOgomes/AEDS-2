import java.util.*;

public class Los_Buses_de_Cartagena_2077 {

    static int N, M;
    static List<Integer>[] adj;
    static int[] pairU, pairV, dist;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt(); // número de instâncias

        while (T-- > 0) {
            M = scanner.nextInt(); // número de ônibus
            N = scanner.nextInt(); // número de passageiros

            // Lendo horários de partida dos ônibus
            String[] horariosOnibus = new String[M];
            for (int i = 0; i < M; i++) {
                horariosOnibus[i] = scanner.next();
            }

            // Lendo horários preferidos dos passageiros
            String[][] horariosPassageiros = new String[N][];
            for (int i = 0; i < N; i++) {
                int K = scanner.nextInt();
                horariosPassageiros[i] = new String[K];
                for (int j = 0; j < K; j++) {
                    horariosPassageiros[i][j] = scanner.next();
                }
            }

            // Determinar o número mínimo de passageiros necessários
            int minPassageiros = 0;
            for (int pass = 1; pass <= N; pass++) {
                if (podeAtenderTodosComPassageiros(pass, horariosOnibus, horariosPassageiros)) {
                    minPassageiros = pass;
                    break;
                }
            }

            System.out.println(minPassageiros);
        }

        scanner.close();
    }

    // Função para verificar se é possível atender todos os passageiros com 'numPassageiros' passageiros
    static boolean podeAtenderTodosComPassageiros(int numPassageiros, String[] horariosOnibus, String[][] horariosPassageiros) {
        adj = new List[N];
        for (int i = 0; i < N; i++) {
            adj[i] = new ArrayList<>();
        }

        // Construir grafo de bipartição com arestas de passageiros para ônibus
        for (int p = 0; p < N; p++) {
            for (int t = 0; t < horariosPassageiros[p].length; t++) {
                String horarioPassageiro = horariosPassageiros[p][t];
                for (int b = 0; b < M; b++) {
                    if (horarioPassageiro.equals(horariosOnibus[b])) {
                        adj[p].add(b);
                        break; // cada passageiro só precisa viajar uma vez por dia
                    }
                }
            }
        }

        // Aplicar algoritmo de emparelhamento máximo para verificar se é possível cobrir todos os passageiros
        pairU = new int[N];
        pairV = new int[M];
        dist = new int[N];

        Arrays.fill(pairU, -1);
        Arrays.fill(pairV, -1);

        int matching = 0;
        while (bfs()) {
            for (int u = 0; u < N; u++) {
                if (pairU[u] == -1 && dfs(u)) {
                    matching++;
                }
            }
        }

        return matching == numPassageiros;
    }

    // Algoritmo BFS para encontrar caminhos aumentantes
    static boolean bfs() {
        Queue<Integer> queue = new LinkedList<>();
        for (int u = 0; u < N; u++) {
            if (pairU[u] == -1) {
                dist[u] = 0;
                queue.offer(u);
            } else {
                dist[u] = Integer.MAX_VALUE;
            }
        }
        boolean foundAugmentingPath = false;
        while (!queue.isEmpty()) {
            int u = queue.poll();
            if (dist[u] < Integer.MAX_VALUE) {
                for (int v : adj[u]) {
                    int nextU = pairV[v];
                    if (nextU == -1) {
                        foundAugmentingPath = true;
                    } else if (dist[nextU] == Integer.MAX_VALUE) {
                        dist[nextU] = dist[u] + 1;
                        queue.offer(nextU);
                    }
                }
            }
        }
        return foundAugmentingPath;
    }

    // Algoritmo DFS para tentar emparelhar um vértice u
    static boolean dfs(int u) {
        for (int v : adj[u]) {
            int nextU = pairV[v];
            if (nextU == -1 || (dist[nextU] == dist[u] + 1 && dfs(nextU))) {
                pairU[u] = v;
                pairV[v] = u;
                return true;
            }
        }
        return false;
    }
}
