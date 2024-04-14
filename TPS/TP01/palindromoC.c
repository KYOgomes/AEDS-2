#include <stdio.h>
#include <string.h>
//palindromo em c, comparando as palavras e invertendo elas para ver se são iguaiss
int main(void) {

  char palavra1[1000], palavra2[1000];
  char auxiliar[] = "FIM";

  scanf(" %[^\n\r]", palavra1);

  //Loop de repetição pra comparar as palavras enquanto a palavra não for FIM 
  while(strcmp(palavra1, auxiliar) != 0){

    //pega uma variável pro tamanho do vetor
    int tamanho = strlen(palavra1);

    int aux = 0;
    int aux2 = tamanho;

  //FOR para inverter a String, mexendo em cada posição do array.
    for(int i = tamanho; i>0; i--){
      palavra2[aux2 - 1] = palavra1[aux];
      aux++;
      aux2--;
    }

//Indica que o tamanho da palavra termina no \0, ou seja, quando muda pra próxima palavra
    palavra2[tamanho] = '\0'; 

//IF para comparar se as palavras são iguais
    if(strcmp(palavra1, palavra2) == 0){
      printf("SIM\n");
    }else{
      printf("NAO\n");
    }

    scanf(" %[^\n\r]", palavra1); 
  }
  return 0;
}