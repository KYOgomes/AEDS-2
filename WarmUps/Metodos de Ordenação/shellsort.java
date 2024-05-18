
/*O algoritmo de ordenação ShellSort é uma extensão do algoritmo de inserção que permite a troca de elementos distantes.
 * COMPLEXIDADE: O(n^2)
 */

import java.util.Scanner;

public class shellsort {
    public static void ordenaShell(int[] vetor)
    {
        int h = 1; 
        do
        {
            h = (h*3) + 1;
        } while(h < vetor.length);

        do{
            h/=3;
            for(int cor = 0; cor < h; cor++)
            {
                insercaoPorCor(cor, h, vetor);
            }
        }while(h!=1);
    }

    public static void insercaoPorCor(int cor, int h, int[] vetor) 
    {
        for(int i = (h + cor); i < vetor.length; i+=h)
        {
            int temp = vetor[i];
            int j = i - h;
            while ((j >= 0) && (vetor[j] > temp)) 
            {
                vetor[j + h] = vetor[j];
                j-=h;
            }
            vetor[j + h] = temp;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Informe o tamanho do vetor:");
        int n = sc.nextInt();
        int[] vetor = new int[n];
        for (int i = 0; i < n; i++) {
            vetor[i] = sc.nextInt();
        }

        ordenaShell(vetor);
        System.out.println("Vetor ordenado: ");
        for (int i = 0; i < n; i++) {
            System.out.print(" " + vetor[i]);
        }
        sc.close();
    }
}
