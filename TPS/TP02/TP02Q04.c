#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include <string.h>
#include <wchar.h>
#include <locale.h>

#define MAX_PERSONAGENS 1000
#define MAX_STRING_LENGTH 500

typedef struct s_Personagem {
    char *id;
    char *name;
    char *alternateNames;
    char *house;
    char *ancestry;
    char *species;
    char *patronus;
    bool hogwartsStaff;
    bool hogwartsStudent;
    char *actorName;
    bool alive;
    char *alternateActors;
    char *dateOfBirth;
    int yearOfBirth;
    char *eyeColour;
    char *gender;
    char *hairColour;
    bool wizard;
} Personagem;

void newPersonagem(Personagem *personagem) {
    personagem->id = NULL;
    personagem->name = NULL;
    personagem->alternateNames = NULL;
    personagem->house = NULL;
    personagem->ancestry = NULL;
    personagem->species = NULL;
    personagem->patronus = NULL;
    personagem->hogwartsStaff = false;
    personagem->hogwartsStudent = false;
    personagem->actorName = NULL;
    personagem->alive = false;
    personagem->alternateActors = NULL;
    personagem->dateOfBirth = NULL;
    personagem->yearOfBirth = 0;
    personagem->eyeColour = NULL;
    personagem->gender = NULL;
    personagem->hairColour = NULL;
    personagem->wizard = false;
}

void freePersonagem(Personagem *personagem) {
    free(personagem->id);
    free(personagem->name);
    free(personagem->alternateNames);
    free(personagem->house);
    free(personagem->ancestry);
    free(personagem->species);
    free(personagem->patronus);
    free(personagem->actorName);
    free(personagem->alternateActors);
    free(personagem->dateOfBirth);
    free(personagem->eyeColour);
    free(personagem->gender);
    free(personagem->hairColour);
}

bool checarData(const char *data) {
    // Implemente sua lógica de verificação de data aqui
}

void padronizarData(char *data) {
    // Implemente sua lógica para padronizar a data aqui
}

void imprimir(const Personagem *personagem) {
    // Implemente sua lógica de impressão do personagem aqui
}

Personagem *lerPersonagem(const char *filename, const char *id_procurado) {
    // Implemente sua lógica para ler o personagem do arquivo CSV aqui
}

int main() {
    setlocale(LC_CTYPE, "UTF-8");
    char path[] = "/tmp/characters.csv";
    char id[MAX_STRING_LENGTH];

    Personagem personagens[MAX_PERSONAGENS];
    int numPersonagens = 0;

    printf("Digite o ID do personagem ou 'FIM' para sair:\n");
    while (fgets(id, sizeof(id), stdin) != NULL) {
        id[strcspn(id, "\n")] = '\0'; // Remover o caractere de nova linha

        if (strcmp(id, "FIM") == 0) {
            break;
        }

        if (numPersonagens >= MAX_PERSONAGENS) {
            printf("Número máximo de personagens alcançado. Saindo...\n");
            break;
        }

        Personagem *personagem = lerPersonagem(path, id);
        if (personagem != NULL) {
            personagens[numPersonagens++] = *personagem;
            free(personagem);
        }

        printf("\nDigite o próximo ID do personagem ou 'FIM' para sair:\n");
    }

    // Imprimir os personagens lidos
    for (int i = 0; i < numPersonagens; i++) {
        imprimir(&personagens[i]);
    }

    // Liberar a memória alocada para os personagens
    for (int i = 0; i < numPersonagens; i++) {
        freePersonagem(&personagens[i]);
    }

    return 0;
}
