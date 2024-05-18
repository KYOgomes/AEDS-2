/* Metodo de ordenação por SELEÇÂO, neste metodo selecionamos o primeiro elemento do array como o MENOR, entao o comparamos com os demais (em J) para confirmar 
tal afirmação, ou negalá, apos confirmar que o mesmo é o menor, o elemento i aumenta 1 e assim por diante. 
COMPLEXIDADE O(n^2) em ambos os casos*/

import java.util.Scanner;

public class selecao {
    public static void ordenacaoSelecao(int[] vetor) {
        int n = vetor.length;
        for (int i = 0; i < n - 1; i++) {
            int menor = i;

            for (int j = i + 1; j < n; j++) {
                if (vetor[j] < vetor[menor]) {
                    menor = j;
                }
            }

            int temp = vetor[menor];
            vetor[menor] = vetor[i];
            vetor[i] = temp;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Informe o tamanho do vetor:");
        int n = sc.nextInt();
        int[] vetor = new int[n];

        System.out.println("Informe os elementos do vetor:");
        for (int i = 0; i < n; i++) {
            vetor[i] = sc.nextInt();
        }

        ordenacaoSelecao(vetor);

        System.out.println("Vetor ordenado: ");
        for (int i = 0; i < n; i++) {
            System.out.print(" " + vetor[i]);
        }
        sc.close();
    }
}
