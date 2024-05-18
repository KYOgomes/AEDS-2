/*O algoritmo de ordenação MergeSort é um algoritmo de ordenação eficiente baseado em comparações que segue a abordagem dividir para conquistar. funciona de 
 * forma recursiva e acaba criando subarrays para serem ordenados em menor quantidade
 melhor e pior caso de O(n log n), bom para grandes conjuntos de dados!*/
 
import java.util.Scanner;
public class mergesort {

    public static void ordenaMerge(int[] array, int inicio, int fim) {
        if (inicio < fim) {
            int meio = (inicio + fim) / 2;
            ordenaMerge(array, inicio, meio);
            ordenaMerge(array, meio + 1, fim);
            merge(array, inicio, meio, fim);
        }
    }

    public static void merge(int[] array, int inicio, int meio, int fim) {
        int n1 = meio - inicio + 1;
        int n2 = fim - meio;

        // Cria arrays temporários
        int[] L = new int[n1];
        int[] R = new int[n2];

        // Copia os dados para os arrays temporários L[] e R[]
        for (int i = 0; i < n1; ++i)
            L[i] = array[inicio + i];
        for (int j = 0; j < n2; ++j)
            R[j] = array[meio + 1 + j];

        // Mescla os arrays temporários de volta em array[inicio..fim]
        int i = 0, j = 0;
        int k = inicio;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                array[k] = L[i];
                i++;
            } else {
                array[k] = R[j];
                j++;
            }
            k++;
        }

        // Copia os elementos restantes de L[], se houver
        while (i < n1) {
            array[k] = L[i];
            i++;
            k++;
        }

        // Copia os elementos restantes de R[], se houver
        while (j < n2) {
            array[k] = R[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Informe o tamanho do vetor:");
        int n = sc.nextInt();
        int[] vetor = new int[n];
        for(int i =0; i < vetor.length; i++)
        {
            vetor[i] = sc.nextInt();
        }

        ordenaMerge(vetor, 0, n - 1);

        System.out.println("Vetor ordenado:");
        for (int i = 0; i < n; i++) {
            System.out.print(vetor[i] + " ");
        }
        System.out.println();
        sc.close();
    }
}
