/*metodo de ordenação INSERÇÃO, neste metodo o vetor é percorrido e duas partes são separadas, a parte ordenada e a parte sem ordenação,a parte ordenada sempre
 aumenta em cada interação. 
 COMPLEXIDADE O(n²) no pior caso e O(n) no melhor caso. é um algoritmo ESTAVEL.*/
import java.util.Scanner;
public class Insercao 
{
    
    public static void ordenacaoInsercao(int[] vetor)
    {
        for(int i = 1; i < vetor.length; i++)
        {
            int temp = vetor[i];
            int j = i - 1;

            while(j >= 0 && vetor[j]>temp)
            {
                vetor[j+1] = vetor[j];
                j--;
            }
            vetor[j+1] = temp;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Informe o tamanho do vetor:");
        int n = sc.nextInt();

        //vetor criado
        int[] vetor = new int[n];
        //preencher vetor
        for (int i = 0; i < n; i++) 
        {
            vetor[i] = sc.nextInt();
        }
        //metodo de ordenação inserção
        ordenacaoInsercao(vetor);

        System.out.println("Vetor ordenado: ");
        for (int i = 0; i < n; i++) 
        {
            System.out.print(" " + vetor[i]);
        }

        sc.close();
    }
}
