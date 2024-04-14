#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>

int main() {
    srand(time(NULL));
    char frase[1000];
    char frase_final[1000];

    do {
        fgets(frase, sizeof(frase), stdin);
        frase[strcspn(frase, "\n")] = '\0'; // Remover o caractere de nova linha do final da string

        if(strcmp(frase, "FIM") == 0)
            break;

        char letra1 = 'a' + rand() % 26;
        char letra2 = 'a' + rand() % 26;

        for(int i = 0; i < strlen(frase); i++) {
            if(frase[i] == letra1)
                frase_final[i] = letra2;
            else
                frase_final[i] = frase[i];
        }

        frase_final[strlen(frase)] = '\0'; // Garantir que a string resultante esteja terminada

        printf("%s\n", frase_final);

    } while(strcmp(frase, "FIM") != 0);

    return 0;
}
