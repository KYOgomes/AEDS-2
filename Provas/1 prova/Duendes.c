#include <stdio.h>
#include <string.h>

// Estrutura para representar um duende
typedef struct 
{
    char nome[21];
    int idade;
} Duende;

// Função para trocar dois duendes de posição em um array
void trocar(Duende *a, Duende *b) {
    Duende temp = *a;
    *a = *b;
    *b = temp;
}

// Função para ordenar um array de duendes
void ordenarDuendes(Duende *duendes, int n) 
{
    for (int i = 0; i < n-1; i++) {
        for (int j = 0; j < n-i-1; j++) {
            // Se as idades são iguais, ordenar por nome em ordem ascendente
            if (duendes[j].idade == duendes[j+1].idade && strcmp(duendes[j].nome, duendes[j+1].nome) > 0) 
            {
                trocar(&duendes[j], &duendes[j+1]);
            }
            // Ordenar por idade em ordem descendente
            else if (duendes[j].idade < duendes[j+1].idade) {
                trocar(&duendes[j], &duendes[j+1]);
            }
        }
    }
}

int main() 
{
    int n;
    scanf("%d", &n);

    Duende duendes[n];
    for (int i = 0; i < n; i++) {
        scanf("%s %d", duendes[i].nome, &duendes[i].idade);
    }

    ordenarDuendes(duendes, n);

    int numTimes = n / 3;
    int duendesPorTime = n / numTimes;

    for (int i = 0; i < numTimes; i++) {
        printf("Time %d\n", i + 1);
        for (int j = 0; j < 3; j++) {
            int index = i + j * numTimes;
            printf("%s %d\n", duendes[index].nome, duendes[index].idade);
        }
        printf("\n");
    }

    return 0;
}
