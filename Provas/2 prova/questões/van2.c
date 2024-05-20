#include <stdio.h>
#include <string.h>
#include <stdlib.h>

typedef struct
{
    char nome[100];
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

    char nomes[q][100];

    //ordenar primeiro por custo, região e por fim nome
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
    
    for(int i = 0; i < q; i++)
    {
        printf("%s\n", pessoa[i].nome);
    }

    return 0;
}
