#include <stdio.h>
#include <stdbool.h>

#define MAXN 1005

int main() {
    int N, P;

    while (scanf("%d %d", &N, &P) == 2 && (N != 0 || P != 0)) {
        int pilhas[MAXN][MAXN];
        int topo[MAXN]; // indica a posição do topo atual de cada pilha
        int caixasDesempilhadas = 0;

        // Leitura das pilhas
        for (int i = 0; i < P; i++) {
            int Qi;
            scanf("%d", &Qi);

            for (int j = 0; j < Qi; j++) {
                scanf("%d", &pilhas[i][j]);
            }
            topo[i] = Qi - 1; // inicializa o topo como o índice do último elemento
        }

        // Joãozinho quer recuperar a caixa 1, que está no inventário inicialmente
        bool encontrado = false;

        // Verifica cada pilha da mais próxima até a mais distante
        for (int i = 0; i < P; i++) {
            // Procura a caixa 1 no topo da pilha i
            while (topo[i] >= 0 && pilhas[i][topo[i]] != 1) {
                topo[i]--;
                caixasDesempilhadas++;
            }

            // Se encontrou a caixa 1 no topo da pilha i, encerra a busca
            if (topo[i] >= 0 && pilhas[i][topo[i]] == 1) {
                encontrado = true;
                break;
            }
        }

        // Imprime o número de caixas desempilhadas, exceto a caixa 1
        if(caixasDesempilhadas == 1)
        {
            caixasDesempilhadas = 0;
        }
        printf("%d\n", caixasDesempilhadas);
    }

    return 0;
}