#include <stdio.h>
#include <string.h>

typedef struct {
    char palavra[20];
    int valor;
} Mapa;

int busca(Mapa* mapa, int m, char* palavra) {
    for (int i = 0; i < m; i++) {
        if (strcmp(mapa[i].palavra, palavra) == 0) {
            return mapa[i].valor;
        }
    }
    return 0;
}

int main() {
    int m, n, valor;
    char palavra[20];
    Mapa mapa[1000];

    while (scanf("%d %d", &m, &n) != EOF) {
        for (int i = 0; i < m; i++) {
            scanf("%s %d", palavra, &valor);
            strcpy(mapa[i].palavra, palavra);
            mapa[i].valor = valor;
        }
        for (int i = 0; i < n; i++) {
            int salario = 0;
            while (scanf("%s", palavra) && strcmp(palavra, ".") != 0) {
                salario += busca(mapa, m, palavra);
            }
            printf("%d\n", salario);
        }
    }

    return 0;
}