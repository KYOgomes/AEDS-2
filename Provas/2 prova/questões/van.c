#include <stdio.h>
#include <stdlib.h>
#include <string.h>

// Definição da struct
typedef struct {
    char nome[50];
    char regiao;
    float custo;
} Aluno;

int main() {
    int Q;
    scanf("%d", &Q);
    Aluno *alunos = (Aluno *)malloc(Q * sizeof(Aluno));
    getchar();

    // Leitura dos dados de cada aluno
    for (int i = 0; i < Q; i++) 
    {
        char entrada[100];
        fgets(entrada, sizeof(entrada), stdin);
        entrada[strcspn(entrada, "\n")] = 0;

        // Tokenização da string de entrada
        char *token = strtok(entrada, " ");
        strncpy(alunos[i].nome, token, sizeof(alunos[i].nome) - 1);
        alunos[i].nome[sizeof(alunos[i].nome) - 1] = '\0';

        token = strtok(NULL, " ");
        if (token == NULL || strlen(token) != 1) {
            fprintf(stderr, "Erro ao processar a entrada.\n");
            free(alunos);
            return 1;
        }
        alunos[i].regiao = token[0];

        token = strtok(NULL, " ");
        if (token == NULL) {
            fprintf(stderr, "Erro ao processar a entrada.\n");
            free(alunos);
            return 1;
        }
        alunos[i].custo = atof(token);
    }

    // Exibir a lista de alunos
    for (int i = 0; i < Q; i++) 
    {
        printf("%s\n", alunos[i].nome);
    }
    // Liberar a memória alocada
    free(alunos);

    return 0;
}
