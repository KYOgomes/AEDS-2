#include <stdio.h>
#include <string.h>
#include <stdlib.h>

typedef struct
{
    char nome[101];
    char regiao;
    int custo;
} Alunos;

int main()
{   
    int q; 
    scanf("%d", &q);
    Alunos pessoa[q];  
    for(int i = 0; i < q; i++)
    {
        scanf("%s %c %d", pessoa[i].nome, &pessoa[i].regiao, &pessoa[i].custo); 
    }   

    char nomes[q][101];

    //ordenar primeiro por custo, região (L, N, O, S)nesta ordem, e por fim nome.
    //bubbleSort O(n^2) no pior caso e O(n) no melhor caso
    for(int i = 0; i < q; i++)
    {
        for(int j = i+1; j < q; j++)
        {
            if(pessoa[i].custo > pessoa[j].custo)
            {
                Alunos temp = pessoa[i];
                pessoa[i] = pessoa[j];
                pessoa[j] = temp;
            }
            else if(pessoa[i].custo == pessoa[j].custo)
            {
                if(pessoa[i].regiao > pessoa[j].regiao)
                {
                    Alunos temp = pessoa[i];
                    pessoa[i] = pessoa[j];
                    pessoa[j] = temp;
                }
                else if(pessoa[i].regiao == pessoa[j].regiao)
                {
                    if(strcmp(pessoa[i].nome, pessoa[j].nome) > 0)
                    {
                        Alunos temp = pessoa[i];
                        pessoa[i] = pessoa[j];
                        pessoa[j] = temp;
                    }
                }
            }
        }
    }
    printf("------------------------------------\n");
    for(int i = 0; i < q; i++)
    {
        printf("%s\n", pessoa[i].nome);
    }
    return 0;
}