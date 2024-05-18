
/*O algoritmo de ordenação HeapSort é um algoritmo baseado em comparações que utiliza uma estrutura de dados chamada heap. Um heap máximo é uma árvore binária 
em que o valor de cada nó é maior ou igual ao valor de seus filhos.  
COMPLEXIDADE: O(n log n) isto pois o heapfy tem complexidade de o(n) e reorganiza-los tem complexidade de O(lg n)*/

import java.util.Scanner;

public class heapsort {
    public static void ordenaHeap(int[] vetor) {
        int n = vetor.length;

        // Construir heap (reorganizar array)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(vetor, n, i);

        // Um por um extrair um elemento do heap
        for (int i=n-1; i>=0; i--)
        {
            // Move o atual root para o fim
            int temp = vetor[0];
            vetor[0] = vetor[i];
            vetor[i] = temp;

            // chama max heapify no heap reduzido
            heapify(vetor, i, 0);
        }
    }

    public static void heapify(int[] vetor, int n, int i) {
        int maior = i;
        int esq = 2 * i + 1;
        int dir = 2 * i + 2;

        if (esq < n && vetor[esq] > vetor[maior])
            maior = esq;

        // Se o filho da direita for maior que o maior até agora
        if (dir < n && vetor[dir] > vetor[maior])
            maior = dir;

        // Se o maior não for a raiz
        if (maior != i) {
            int temp = vetor[i];
            vetor[i] = vetor[maior];
            vetor[maior] = temp;

            // Reorganiza o heap afetado
            heapify(vetor, n, maior);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] vetor = new int[n];

        for (int i = 0; i < n; i++) {
            vetor[i] = sc.nextInt();
        }

        ordenaHeap(vetor);
        System.out.println("Vetor ordenado:");
        for (int i = 0; i < vetor.length; i++) {
            System.out.print(vetor[i] + " ");
        }
        sc.close();
    }
}