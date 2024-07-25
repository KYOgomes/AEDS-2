import java.util.ArrayList;
import java.util.Scanner;

public class Desempilhando_caixas_1438 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int N = scanner.nextInt();
            int P = scanner.nextInt();

            if (N == 0 && P == 0) {
                break;
            }

            // Array de listas para representar as pilhas de caixas
            ArrayList<Integer>[] pilhas = new ArrayList[P];

            // Leitura das pilhas
            for (int i = 0; i < P; i++) {
                int Qi = scanner.nextInt();
                pilhas[i] = new ArrayList<>();

                // Ler as caixas da pilha i
                for (int j = 0; j < Qi; j++) {
                    pilhas[i].add(scanner.nextInt());
                }
            }

            // Variável para contar as caixas desempilhadas
            int caixasDesempilhadas = 0;

            // Busca da caixa 1
            for (int i = 0; i < P; i++) {
                // Procurar a caixa 1 no topo da pilha i
                while (!pilhas[i].isEmpty() && pilhas[i].get(pilhas[i].size() - 1) != 1) {
                    pilhas[i].remove(pilhas[i].size() - 1);
                    caixasDesempilhadas++;
                }

                // Se encontrou a caixa 1, podemos parar
                if (!pilhas[i].isEmpty() && pilhas[i].get(pilhas[i].size() - 1) == 1) {
                    break;
                }
            }

            // Imprime o número de caixas desempilhadas, exceto a caixa 1
            if(caixasDesempilhadas == 1)
            {
                caixasDesempilhadas = 0;
                System.out.println(caixasDesempilhadas);
            }
            else
            {
                System.out.println(caixasDesempilhadas);
            }
            
        }

        scanner.close();
    }
}
