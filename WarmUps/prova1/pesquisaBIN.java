import java.util.*;
public class pesquisaBIN {
    //pesquisa binaria com apenas uma comparação entre elementos do vetor
    public static void funcBin(Int[] vetor, int valorBUSCA)
    {
        int inicio =0;
        int fim = vetor.length - 1;
        int meio;
        int diferença;
        boolean resp = false;
        while(inicio <= fim)
        {
            meio = (inicio + fim)/2;
            diferença = valorBUSCA - vetor[meio];
            if(diferença == 0)
            {
                resp = true;
                esq = vetor.length;
            }
            else if(diferença > 0)
            {
                inicio = meio + 1;
            }
            else
            {
                fim = meio - 1;
            }
        }
    }

    //pesquisa binaria normal!
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] VETOR = new int[n];

        for (int i = 0; i < n; i++) 
        {
            VETOR[i] = sc.nextInt();
        }

        int valorBUSCA = sc.nextInt();
        int inicio = 0;
        int fim = n - 1;
        int meio;
        int posicao = -1;
        while(inicio <= fim)
        {
            meio = (inicio + fim)/2;
            if(VETOR[meio]== valorBUSCA)
            {
                posicao = meio;
                System.out.println(posicao);
                break;
            }
            else if(VETOR[meio]<valorBUSCA)
            {
                inicio = meio + 1;
            }
            else
            {
                fim = meio - 1;
            }

        }
    }
}
