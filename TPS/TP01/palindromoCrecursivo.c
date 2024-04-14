#include <stdio.h>
#include <string.h>
//funciona pfvr
// Função recursiva para verificar se uma string é um palíndromo
int verificarPalindromo(char palavra1[], int inicio, int fim) {
    // Se chegarmos ao fim da string ou se a string tem apenas um caractere, é um palíndromo
    if (inicio >= fim) {
        return 1;
    }

    // Se o caractere atual for diferente do caractere correspondente no final, não é um palíndromo
    if (palavra1[inicio] != palavra1[fim]) {
        return 0;
    }

    // Chamada recursiva para verificar os caracteres restantes
    return verificarPalindromo(palavra1, inicio + 1, fim - 1);
}

int main(void) {
    char palavra1[1000];
    char auxiliar[] = "FIM";

    scanf(" %[^\n\r]", palavra1);

    // Loop de repetição para verificar se cada palavra é um palíndromo
    while(strcmp(palavra1, auxiliar) != 0) {
        int tamanho = strlen(palavra1);

        // Chama a função recursiva para verificar se a palavra é um 
        
        if (verificarPalindromo(palavra1, 0, tamanho - 1)) {
            printf("SIM\n");
        } else {
            printf("NAO\n");
        }

        scanf(" %[^\n\r]", palavra1);
    }
    
    return 0;
}
