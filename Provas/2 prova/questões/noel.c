#include <stdio.h>
#include <stdlib.h>
#include <string.h>

// Definindo uma estrutura para mapeamento de traduções
typedef struct TranslationMapper {
    char *idioma;
    char *saudacao;
} Mapper;

// Função que mapeia o país (idioma) para a saudação correspondente
char* mapearPaisParaSaudacao(Mapper* traducoes, int N, char *pais) {
    for(int i = 0; i < N; i++) {
        if(strcmp(pais, traducoes[i].idioma) == 0) {
            return traducoes[i].saudacao;
        }
    }
    return NULL;
}

void lerTraducoes(Mapper* traducoes, int N);
void liberarTraducoes(Mapper* traducoes, int N);

int main() {
    int N;
    scanf("%d", &N); // Lê o número de traduções
    Mapper traducoes[N]; // Cria um array de estruturas para armazenar as traduções
    lerTraducoes(traducoes, N); // Lê as traduções

    int M;
    scanf("%d", &M); // Lê o número de saudações a serem exibidas
    while (M--) {
        char nome[31];
        char pais[31];
        scanf(" %[^\n]", nome); // Lê o nome
        scanf("%s", pais); // Lê o país (idioma)
        
        char* saudacao = mapearPaisParaSaudacao(traducoes, N, pais); // Mapeia o país para a saudação correspondente
        
        printf("%s\n", nome); // Exibe o nome
        printf("%s\n", saudacao); // Exibe a saudação
    }
    
    liberarTraducoes(traducoes, N); // Libera a memória alocada para as traduções
    return 0;
}

// Função que lê as traduções da entrada padrão
void lerTraducoes(Mapper* traducoes, int N) {
    for(int i = 0; i < N; i++) {   
        char idioma[31], saudacao[31];
        scanf("%s", idioma); // Lê o idioma
        scanf(" %[^\n]", saudacao); // Lê a saudação
        
        traducoes[i].idioma = malloc(31 * sizeof(char)); // Aloca memória para o idioma
        strcpy(traducoes[i].idioma, idioma); // Copia o idioma para a estrutura
        
        traducoes[i].saudacao = malloc(31 * sizeof(char)); // Aloca memória para a saudação
        strcpy(traducoes[i].saudacao, saudacao); // Copia a saudação para a estrutura
    }
}

// Função que libera a memória alocada para as traduções
void liberarTraducoes(Mapper* traducoes, int N) {
    for (int i = 0; i < N; i++) {
        free(traducoes[i].idioma); // Libera a memória do idioma
        free(traducoes[i].saudacao); // Libera a memória da saudação
    }
}