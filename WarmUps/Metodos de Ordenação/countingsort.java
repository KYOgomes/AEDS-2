/*O algoritmo Counting Sort é um algoritmo de ordenação eficiente para classificar elementos cujo intervalo (faixa) é conhecido e pequeno. 
Funciona contando o número de elementos distintos e calculando sua posição no array de saída.  
COMPLEXIDADE: Melhor caso: O(n)
Pior caso (array de contagens): O(n + R)
Pior caso (hash table de contagens): O(n)*/
import java.util.Scanner;
public class countingsort {
    public static void countingSort(int[] array, int max) {
        int[] count = new int[max + 1];

        // Conta ocorrências de cada elemento
        for (int num : array) {
            count[num]++;
        }

        // Calcula a posição de cada elemento no array ordenado
        for (int i = 1; i <= max; i++) {
            count[i] += count[i - 1];
        }

        // Constrói o array ordenado
        int[] sortedArray = new int[array.length];
        for (int i = array.length - 1; i >= 0; i--) {
            sortedArray[count[array[i]] - 1] = array[i];
            count[array[i]]--;
        }

        // Copia o array ordenado de volta para o array original
        System.arraycopy(sortedArray, 0, array, 0, array.length);
    }

    public static void main(String[] args) {        
        Scanner sc = new Scanner(System.in);
        int[] array = {4, 2, 2, 8, 3, 3, 1};
        int max = 8; // Intervalo máximo de valores

        countingSort(array, max);

        System.out.println("Array ordenado:");
        for (int num : array) 
        {
            System.out.print(num + " ");
        }
        sc.close();
    }
}
