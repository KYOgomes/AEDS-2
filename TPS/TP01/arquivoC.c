
#include <stdio.h>

void ler_arquivo_reverso(FILE *arq, float valorLido) {

  // Ler um número do arquivo
  if (fscanf(arq, "%g", &valorLido) != EOF) {
    // Fica chamando o método de forma recursiva pra ler os números de trás pra frente
    ler_arquivo_reverso(arq, valorLido);

    // Imprimi o número depois de chamar a função
    printf("%g\n", valorLido);
  }
}

int main() 
{
  int valorN = 0;
  float valorLido = 0;
  scanf("%d", &valorN);

  // abertura do arquivo para escrita
  FILE *arq = fopen("arq.txt", "w+");

  for (int i = 0; i < valorN; i++) {
    scanf("%f", &valorLido);
    fprintf(arq, "%f\n", valorLido);
  }

  // fechamento inicial do arquivo
  fclose(arq);

  //abertura do arquivo para leitura
  fopen("arq.txt", "r");

  //função que inverte o arquivo pra ler de trás pra frente
  ler_arquivo_reverso(arq, valorLido);

  //fechamento final do arquivo
  fclose(arq);
  return 0;
}