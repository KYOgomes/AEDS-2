/*O metodo de ordenação por BOLHA, O algoritmo de ordenação por bolha funciona comparando repetidamente pares de elementos adjacentes e os trocando de posição 
se estiverem na ordem errada. Esse processo é repetido até que nenhum swap seja necessário, o que indica que o vetor está ordenado. 
COMPLEXIDADE: O(n) no melhor caso e O(n^2) no pior caso*/

import java.util.Scanner;

public class bubble {
    public static void ordenacaoBolha(int[] vetor) 
    {
        int n = vetor.length;
        boolean swapped; // Flag para indicar se houve troca em uma iteração
        // Loop externo para percorrer o vetor
        for (int i = 0; i < n - 1; i++) {
            swapped = false; // Inicializa a flag como falso para esta iteração

            // Loop interno para comparar pares adjacentes e trocar, se necessário
            for (int j = 0; j < n - 1 - i; j++) {
                if (vetor[j] > vetor[j + 1]) {
                    // Troca os elementos
                    int temp = vetor[j];
                    vetor[j] = vetor[j + 1];
                    vetor[j + 1] = temp;
                    swapped = true; // Define a flag como true, indicando que ocorreu uma troca
                }
            }
            // Se nenhuma troca ocorreu durante uma iteração, o vetor está ordenado e
            // podemos sair do loop
            if (!swapped) {
                break;
            }
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

        ordenacaoBolha(vetor);

        System.out.println("Vetor ordenado:");
        for (int i = 0; i < n; i++) {
            System.out.print(vetor[i] + " ");
        }
        System.out.println();
        sc.close();
    }
}
