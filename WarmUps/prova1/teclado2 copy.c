#include <stdio.h>
#include <string.h>
//teclado quebrado beecrowd
int main() {
    char texto[100001]; 
    char saida[100001]; 
    int pos = 0; 
    int home = 0; 

    // Enquanto houver entrada
    while (scanf(" %[^\n]", texto)!= EOF) 
    {
        int tam = strlen(texto);
        
        // Limpa a saída e reseta a posição
        saida[0] = '\0';
        pos = 0;

        // Percorre o texto
        for (int i = 0; i < tam; i++) {
            // Se encontrou '[', muda a posição para o início
            if (texto[i] == '[') {
                home = 1;
                pos = 0;
            }
            // Se encontrou ']', muda a posição para o final
            else if (texto[i] == ']') {
                home = 0;
                pos = strlen(saida);
            }
            // Se não for '[' nem ']', adiciona o caractere na saída
            else {
                // Se a tecla "Home" estiver pressionada, adiciona o caractere na posição inicial
                if (home) {
                    memmove(saida + pos + 1, saida + pos, strlen(saida + pos) + 1); // Move os caracteres para a direita
                    saida[pos] = texto[i]; // Insere o caractere na posição inicial
                    pos++; // Atualiza a posição
                } else {
                    saida[pos] = texto[i]; // Adiciona o caractere na posição atual
                    pos++; // Atualiza a posição
                }
            }
        }
        // Imprime o texto Beiju
        printf("%s\n", saida);
    }

    return 0;
}
