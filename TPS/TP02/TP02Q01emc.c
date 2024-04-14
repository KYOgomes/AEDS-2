#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>
#include <time.h>

#define MAX_NOME 100
#define MAX_NOME_ALT 200
#define MAX_LINHA 1000

struct tm dataNascimento;

typedef struct {
    char id[MAX_NOME];
    char nome[MAX_NOME];
    char nomeAlternativo[MAX_NOME_ALT];
    char casa[MAX_NOME];
    char ancestry[MAX_NOME];
    char especie[MAX_NOME];
    char patrono[MAX_NOME];
    bool hogwartsStaff;
    char hogwartsStudent[MAX_NOME];
    char nomeAtor[MAX_NOME];
    bool status;
    int anoNascimento;
    char corOlho[MAX_NOME];
    char genero[MAX_NOME];
    char corCabelo[MAX_NOME];
    bool bruxo;
} Personagem;

void imprimir(Personagem personagem) {
    printf("[%s ## %s ## {%s} ## %s ## %s ## %s ## %s ## %d ## %s ## %s ## %d ## %d/%d/%d ## %d ## %s ## %s ## %s ## %d]\n",
           personagem.id, personagem.nome, personagem.nomeAlternativo, personagem.casa, personagem.ancestry,
           personagem.especie, personagem.patrono, personagem.hogwartsStaff, personagem.hogwartsStudent,
           personagem.nomeAtor, personagem.status, dataNascimento.tm_mday, dataNascimento.tm_mon + 1,
           dataNascimento.tm_year + 1900, personagem.anoNascimento, personagem.corOlho, personagem.genero,
           personagem.corCabelo, personagem.bruxo);
}

void ler(Personagem *personagem, char *id) {
    FILE *arquivo = fopen("/tmp/characters.csv", "r");
    if (arquivo == NULL) {
        perror("Erro ao abrir o arquivo");
        exit(EXIT_FAILURE);
    }

    char linha[MAX_LINHA];
    bool primeiraLinha = true;
    while (fgets(linha, sizeof(linha), arquivo) != NULL) {
        if (primeiraLinha) {
            primeiraLinha = false;
            continue; // Ignora a primeira linha com cabeçalhos
        }

        char *token;
        token = strtok(linha, ",");
        if (strcmp(token, id) == 0) {
            strcpy(personagem->nome, strtok(NULL, ","));
            strcpy(personagem->nomeAlternativo, strtok(NULL, ","));
            strcpy(personagem->casa, strtok(NULL, ","));
            strcpy(personagem->ancestry, strtok(NULL, ","));
            strcpy(personagem->especie, strtok(NULL, ","));
            strcpy(personagem->patrono, strtok(NULL, ","));
            personagem->hogwartsStaff = (bool)atoi(strtok(NULL, ","));
            strcpy(personagem->hogwartsStudent, strtok(NULL, ","));
            strcpy(personagem->nomeAtor, strtok(NULL, ","));
            personagem->status = (bool)atoi(strtok(NULL, ","));
            strptime(strtok(NULL, ","), "%d/%m/%Y", &dataNascimento);
            personagem->anoNascimento = atoi(strtok(NULL, ","));
            strcpy(personagem->corOlho, strtok(NULL, ","));
            strcpy(personagem->genero, strtok(NULL, ","));
            strcpy(personagem->corCabelo, strtok(NULL, ","));
            personagem->bruxo = (bool)atoi(strtok(NULL, ","));
            break; // Para de ler o arquivo assim que encontrar o personagem
        }
    }

    fclose(arquivo);
}

int main() {
    char search[MAX_NOME];
    Personagem personagem;

    while (1) {
        fgets(search, sizeof(search), stdin);
        search[strcspn(search, "\n")] = 0; // Remover o caractere de nova linha

        if (strcmp(search, "FIM") == 0) {
            break;
        }

        strcpy(personagem.id, search);
        ler(&personagem, search);
        imprimir(personagem);
    }

    return 0;
}
