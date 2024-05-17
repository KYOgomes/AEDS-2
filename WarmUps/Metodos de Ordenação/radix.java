/*O algoritmo de ordenação Radix Sort é um algoritmo de ordenação não comparativo que classifica os elementos comparando cada dígito individual dos números.
 * Os elementos são distribuídos em baldes (ou recipientes) com base no valor do dígito menos significativo.
COMPLEXIDADE: O(d * (n + k)) ou O(n)*/
public class radix {
    public static void radixSort(int[] vetor) {
        // Encontra o número máximo no vetor
        int max = Integer.MIN_VALUE;
        for (int num : vetor) {
            if (num > max) {
                max = num;
            }
        }

        // Aplica o Radix Sort para cada dígito, começando pelo menos significativo
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(vetor, exp);
        }
    }

    public static void countingSort(int[] vetor, int exp) {
        int n = vetor.length;
        int[] output = new int[n];
        int[] count = new int[10];

        // Inicializa o vetor de contagem
        for (int i = 0; i < 10; i++) {
            count[i] = 0;
        }

        // Conta a frequência de cada dígito
        for (int i = 0; i < n; i++) {
            count[(vetor[i] / exp) % 10]++;
        }

        // Atualiza a contagem para indicar a posição real do dígito no vetor ordenado
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Constrói o vetor de saída
        for (int i = n - 1; i >= 0; i--) {
            output[count[(vetor[i] / exp) % 10] - 1] = vetor[i];
            count[(vetor[i] / exp) % 10]--;
        }

        // Copia o vetor de saída para o vetor original
        System.arraycopy(output, 0, vetor, 0, n);
    }

    public static void main(String[] args) {
        int[] vetor = {170, 45, 75, 90, 802, 24, 2, 66};
        radixSort(vetor);

        System.out.println("Vetor ordenado:");
        for (int num : vetor) {
            System.out.print(num + " ");
        }
    }
}
