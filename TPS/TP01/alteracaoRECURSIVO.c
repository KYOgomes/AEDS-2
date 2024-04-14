#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <string.h>

//ponteiros para alterar a strings
char replaceChar(char *frase, char letra1, char letra2) {
    if (*frase == '\0') {
        return;
    }

    if (*frase == letra1) {
        *frase = letra2;
    }

    replaceChar(frase + 1, letra1, letra2);
}

void recursiveAlteration(char *frase, char letra1, char letra2) {
    if (strcmp(frase, "FIM") == 0) {
        return;
    }

    for (int i = 0; i < strlen(frase); i++) {
        if (frase[i] == letra1) {
            frase[i] = letra2;
        }
    }

    printf("%s\n", frase);

    scanf("%s", frase); // Pedindo nova entrada
    recursiveAlteration(frase, letra1, letra2);
}

int main() {
    char frase[100];
    char letra1, letra2;

    srand(time(NULL));

    scanf("%s", frase);


    scanf(" %c", &letra1);

    scanf(" %c", &letra2);

    recursiveAlteration(frase, letra1, letra2);

    return 0;
}
