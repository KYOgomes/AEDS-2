
/* Partição: Escolhe um elemento como pivô e particiona o array em dois subarrays, um com elementos menores que o pivô e outro com elementos maiores.
Recursão: Aplica recursivamente o passo de partição nos subarrays até que todo o array esteja ordenado.
Combinação: Não há etapa explícita de combinação, já que os subarrays são ordenados in-place.
COMPLEXIDADE: O(n lg n) melhor caso e O(n^2) no pior caso*/

import java.util.Scanner;

public class quicksort {
    private static void ordenaQuick(int[] array, int baixo, int alto) {
        if (baixo < alto) {
            int pivô = particionar(array, baixo, alto);
            ordenaQuick(array, baixo, pivô - 1);
            ordenaQuick(array, pivô + 1, alto);
        }
    }

    private static int particionar(int[] array, int baixo, int alto) {
        int pivô = array[alto];
        int i = baixo - 1;

        for (int j = baixo; j < alto; j++) {
            if (array[j] < pivô) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        int temp = array[i + 1];
        array[i + 1] = array[alto];
        array[alto] = temp;

        return i + 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Informe o tamanho do vetor:");
        int n = sc.nextInt();
        int[] vetor = new int[n];

        for (int i = 0; i < n; i++) {
            vetor[i] = sc.nextInt();
        }

        ordenaQuick(vetor, 0, n - 1);

        System.out.println("Vetor ordenado:");
        for (int i = 0; i < n; i++) {
            System.out.print(vetor[i] + " ");
        }
        System.out.println();

        sc.close();

    }
}
