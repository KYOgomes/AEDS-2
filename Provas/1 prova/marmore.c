#include <stdlib.h>
#include <stdio.h>
#include <string.h>

int main()
{
    int n;//num marmores
    int q;//num consultas
    int cont =1;
    do
    {
        scanf("%d", &n);
        scanf("%d", &q);
        if((n == 0)&&(q==0))
        {
            break;
        }

        int array[n];
        int x;

        //poe valores no array
        for(int i =0; i < n; i++)
        {
            scanf("%d", &x);
            array[i]=x;
        }

        //ordena array por seleção 
        for(int i = 0; i < n -1; i++)
        {
            int menor = i;
            for(int j = i+1; j < n; j++)
            {
                if(array[j] < array[i])
                {
                    menor = j;
                }
            }

                int temp = array[menor];
                array[menor] = array[i];
                array[i] = temp;
        }

        int busca;
        int numBusca[q];
        for(int i =0; i< q; i++)
        {
            scanf("%d", &busca);
            numBusca[i] = busca;
        }
            
        
        printf("CASE# %d\n", cont);
        cont++;
        for (int j = 0; j < q; j++) 
        {
            int encontrado = 0; // Variável para marcar se o elemento foi encontrado
            for (int i = 0; i < n; i++) {
                if (array[i] == numBusca[j]) {
                    printf("%d found at %d\n", numBusca[j], (i + 1));
                    encontrado = 1; // Marcando que o elemento foi encontrado
                    break; // Parar de procurar assim que encontrar o elemento
                }
            }
            if (!encontrado) {
                printf("%d not found\n", numBusca[j]);
            }
        }    
    }while((n > 0) && (q > 0));
    


    return 0;
}