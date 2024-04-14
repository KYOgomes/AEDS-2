import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;

public class treino2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nInforme o tipo de armazenamento: \n \n1- para Fila \n2- para Pilha \n3- para Lista \n");
        int OP1 = sc.nextInt();

        switch (OP1) {
            case 1:

                // CASO UM- FILA
                System.out.println("\nQuantos numeros deseja por na sua Fila? ->");
                int N = sc.nextInt();
                Queue<Integer> fila = new LinkedList<>();

                // Adiciona os elementos na fila
                System.out.println("digite os numeros: ");
                for (int i = 0; i < N; i++) {
                    fila.add(sc.nextInt());
                }

                System.out.println(
                        "\nInforme o tipo de ordenação: \n\n1- para inserção \n2- para seleção \n3- para bolha \n");
                int subkey1 = sc.nextInt();

                // SUBCASO: escolha do tipo de ordenação
                switch (subkey1) 
                {
                    case 1:// INSERÇÃO!!!

                        Integer[] array = fila.toArray(new Integer[0]);

                        // Tamanho do array
                        int n = array.length;

                        // Loop para iterar sobre o array
                        for (int i = 1; i < n; i++) {
                            int chave = array[i];
                            int j = i - 1;

                            // Move os elementos do array[0..i-1], que são maiores que a chave,
                            // para uma posição à frente de sua posição atual
                            while (j >= 0 && array[j] > chave) {
                                array[j + 1] = array[j];
                                j = j - 1;
                            }
                            array[j + 1] = chave;
                        }

                        // Limpa a fila original
                        fila.clear();

                        // Adiciona os elementos ordenados de volta à fila
                        for (int i = 0; i < n; i++) {
                            fila.add(array[i]);
                        }

                        System.out.println("\nO conjunto foi ordenado POR INSERCAO com sucesso!");
                        System.out.println("\nDeseja imprimir o array ordenado? \n1- para Sim \n2- para Não \n");
                        int printOption = sc.nextInt();

                        switch (printOption) {
                            case 1:
                                System.out.println("\nArray Ordenado: " + fila);
                                System.out.println("\nDeseja buscar um valor no array ordenado? \n1- para Sim \n2- para Não \n");
                                int busca = sc.nextInt();
                                switch (busca) 
                                {
                                    case 1:
                                        System.out.println("qual tipo de busca deseja realizar?: \n1- para sequencial \n2- para binaria \n");
                                        int qualvaiser = sc.nextInt();
                                        switch(qualvaiser)
                                        {
                                            case 1: //pesquisa sequencial
                                            System.out.println("\nInforme o valor que deseja pesquisa: ");
                                            int valor = sc.nextInt();
                                            int tamanho = array.length;
                                            boolean encontrado = false;

                                            for (int i = 0; i < tamanho; i++) 
                                            {
                                                if (array[i] == valor) {
                                                    System.out.println("\nO valor-> " + valor + " <-foi encontrado na posição " + i);
                                                    encontrado = true;
                                                    break;
                                                }
                                            }

                                            if (!encontrado) 
                                            {
                                                System.out.println("\nO valor -> " + valor + " <- não foi encontrado.");
                                                break;
                                            }
                                                    
                                                break;

                                                case 2://pesquisa binaria
                                                Integer[] array2 = fila.toArray(new Integer[0]);
                                                System.out.println("\nInforme o valor que deseja pesquisa: ");
                                                int valor2 = sc.nextInt();
                                                boolean resp = false;
                                                int inicio = 0;
                                                int fim = array2.length - 1;
                                                int meio = 0;
                                                while (inicio <= fim) {
                                                    meio = (inicio + fim) / 2;
                                                    if (array2[meio] == valor2) {
                                                        resp = true;
                                                        break;
                                                    } else if (array2[meio] < valor2) {
                                                        inicio = meio + 1;
                                                    } else {
                                                        fim = meio - 1;
                                                    }
                                                }
                
                                                if (resp) {
                                                    System.out
                                                            .println("\nO valor-> " + valor2 + " <-foi encontrado na posição " + meio);
                                                } else {
                                                    System.out.println("\nO valor-> " + valor2 + " <-não foi encontrado.");
                                                }
                                                break;                                                
                                    
                                                default:
                                                System.out.println("Nehuma busca foi realizada!!");
                                                break;
                                        }
                                    case 2:
                                    System.out.println("\n____FIM____");
                                    break;
                                }

                            break;

                            case 2:
                                System.out.println("\nOk, não será impresso o array ordenado.");
                                System.out.println("\nDeseja buscar um valor no array ordenado? \n1- para Sim \n2- para Não \n");
                                int busca2 = sc.nextInt();
                                switch (busca2) 
                                {
                                    case 1:
                                        System.out.println("qual tipo de busca deseja realizar?: \n1- para sequencial \n2- para binaria \n");
                                        int qualvaiser = sc.nextInt();
                                        switch(qualvaiser)
                                        {
                                            case 1: 
                                            System.out.println("\nInforme o valor que deseja pesquisa: ");
                                            int valor = sc.nextInt();
                                            int tamanho = array.length;
                                            boolean encontrado = false;

                                            for (int i = 0; i < tamanho; i++) 
                                            {
                                                if (array[i] == valor) {
                                                    System.out.println("\nO valor-> " + valor + " <-foi encontrado na posição " + i);
                                                    encontrado = true;
                                                    break;
                                                }
                                            }

                                            if (!encontrado) 
                                            {
                                                System.out.println("\nO valor -> " + valor + " <- não foi encontrado.");
                                                break;
                                            }
                                                    
                                                break;

                                                case 2:
                                                Integer[] array2 = fila.toArray(new Integer[0]);
                                                System.out.println("\nInforme o valor que deseja pesquisa: ");
                                                int valor2 = sc.nextInt();
                                                boolean resp = false;
                                                int inicio = 0;
                                                int fim = array2.length - 1;
                                                int meio = 0;
                                                while (inicio <= fim) {
                                                    meio = (inicio + fim) / 2;
                                                    if (array2[meio] == valor2) {
                                                        resp = true;
                                                        break;
                                                    } else if (array2[meio] < valor2) {
                                                        inicio = meio + 1;
                                                    } else {
                                                        fim = meio - 1;
                                                    }
                                                }
                
                                                if (resp) {
                                                    System.out
                                                            .println("\nO valor-> " + valor2 + " <-foi encontrado na posição " + meio);
                                                } else {
                                                    System.out.println("\nO valor-> " + valor2 + " <-não foi encontrado.");
                                                }
                                                break;                                                
                                    
                                                default:
                                                System.out.println("Nehuma busca foi realizada!!");
                                                break;
                                        }
                                    case 2:
                                    System.out.println("\n____FIM____");
                                    break;
                                }
                                break;
                            default:
                                System.out.println("\nOpção inválida!");
                                break;
                        }
                        break;

                        
                        
                        
                        // ___________________________________________________________________________________________________________________________________________________
                    case 2:// SELEÇÃO!!!

                        // Converte a fila em um array para facilitar a manipulação
                        Integer[] array2 = fila.toArray(new Integer[0]);

                        // Tamanho do array
                        int n2 = array2.length;

                        // Loop para iterar sobre o array
                        for (int i = 0; i < n2 - 1; i++) {
                            // Encontra o índice do menor elemento restante
                            int indiceMenor = i;
                            for (int j = i + 1; j < n2; j++) {
                                if (array2[j] < array2[indiceMenor]) {
                                    indiceMenor = j;
                                }
                            }

                            // Troca o menor elemento com o primeiro não ordenado
                            int temp = array2[indiceMenor];
                            array2[indiceMenor] = array2[i];
                            array2[i] = temp;
                        }

                        // Limpa a fila original
                        fila.clear();

                        // Adiciona os elementos ordenados de volta à fila
                        for (int i = 0; i < n2; i++) {
                            fila.add(array2[i]);
                        }

                        System.out.println("\nO conjunto foi ordenado POR SELECAO com sucesso!");
                        System.out.println("\nDeseja imprimir o array ordenado? \n1- para Sim \n2- para Não \n");
                        int printOption2 = sc.nextInt();
                        switch (printOption2) {
                            case 1:
                                System.out.println("\nArray Ordenado: " + fila);
                                break;
                            case 2:
                                System.out.println("\nOk, não será impresso o array ordenado.");
                                break;
                            default:
                                System.out.println("\nOpção inválida!");
                                break;
                        }

                        // _______________________________________________________________________________________________________________________________________

                    case 3:// BOLHA!!!
                        Integer[] array3 = fila.toArray(new Integer[0]);

                        // Tamanho do array
                        int n3 = array3.length;

                        // Loop para iterar sobre o array
                        for (int i = 0; i < n3 - 1; i++) {
                            for (int j = 0; j < n3 - i - 1; j++) {
                                // Compara os elementos adjacentes
                                if (array3[j] > array3[j + 1]) {
                                    // Troca os elementos se estiverem na ordem errada
                                    int temp = array3[j];
                                    array3[j] = array3[j + 1];
                                    array3[j + 1] = temp;
                                }
                            }
                        }

                        // Limpa a fila original
                        fila.clear();

                        // Adiciona os elementos ordenados de volta à fila
                        for (int i = 0; i < n3; i++) {
                            fila.add(array3[i]);
                        }

                        System.out.println("\nO conjunto foi ordenado POR BOLHA com sucesso!");
                        System.out.println("\nDeseja imprimir o array ordenado? \n1- para Sim \n2- para Não \n");
                        int printOption3 = sc.nextInt();
                        switch (printOption3) {
                            case 1:
                                System.out.println("\nArray Ordenado: " + fila);
                                break;
                            case 2:
                                System.out.println("\nOk, não será impresso o array ordenado.");
                                break;
                            default:
                                System.out.println("\nOpção inválida!");
                                break;
                        }
                        break;

                    default:

                        System.out.println("\nOpção inválida!");

                        break;

                }
                break;

            case 2:
                System.out.println("\nQuantos numeros deseja por na sua Pilha? ->");
                int X = sc.nextInt();
                Stack<Integer> pilha = new Stack<>();

                System.out.println("digite os numeros: ");
                for (int i = 0; i < X; i++) {
                    pilha.push(sc.nextInt());
                }

                System.out.println(
                        "\nInforme o tipo de ordenação: \n\n1- para inserção \n2- para seleção \n3- para bolha \n");
                int key = sc.nextInt();

                switch (key) {
                    case 1:

                        Integer[] array = pilha.toArray(new Integer[0]);

                        // Tamanho do array
                        int n = array.length;

                        // Loop para iterar sobre o array
                        for (int i = 1; i < n; i++) {
                            int chave = array[i];
                            int j = i - 1;

                            // Move os elementos do array[0..i-1], que são maiores que a chave,
                            // para uma posição à frente de sua posição atual
                            while (j >= 0 && array[j] > chave) {
                                array[j + 1] = array[j];
                                j = j - 1;
                            }
                            array[j + 1] = chave;
                        }

                        // Limpa a pilha original
                        pilha.clear();

                        // Adiciona os elementos ordenados de volta à pilha
                        for (int i = 0; i < n; i++) {
                            pilha.add(array[i]);
                        }
                        System.out.println("\nO conjunto foi ordenado POR INSERCAO com sucesso!");
                        System.out.println("\nDeseja imprimir o array ordenado? \n1 para Sim \n2 para Não \n");
                        int printOption = sc.nextInt();
                        switch (printOption) {
                            case 1:
                                System.out.println("\nArray Ordenado: " + pilha);
                                break;
                            case 2:
                                System.out.println("\nOk, não será impresso o array ordenado.");
                                break;
                            default:
                                System.out.println("\nOpção inválida!");
                                break;
                        }

                        break;

                    case 2:

                        Integer[] array2 = pilha.toArray(new Integer[0]);

                        // Tamanho do array
                        int n2 = array2.length;

                        // Loop para iterar sobre o array
                        for (int i = 1; i < n2; i++) {
                            int chave = array2[i];
                            int j = i - 1;

                            // Move os elementos do array[0..i-1], que são maiores que a chave,
                            // para uma posição à frente de sua posição atual
                            while (j >= 0 && array2[j] > chave) {
                                array2[j + 1] = array2[j];
                                j = j - 1;
                            }
                            array2[j + 1] = chave;
                        }

                        // Limpa a pilha original
                        pilha.clear();

                        // Adiciona os elementos ordenados de volta à pilha
                        for (int i = 0; i < n2; i++) {
                            pilha.add(array2[i]);
                        }
                        System.out.println("\nO conjunto foi ordenado POR INSERCAO com sucesso!");
                        System.out.println("\nDeseja imprimir o array ordenado? \n1 para Sim \n2 para Não \n");
                        int printOption2 = sc.nextInt();
                        switch (printOption2) {
                            case 1:
                                System.out.println("\nArray Ordenado: " + pilha);
                                break;
                            case 2:
                                System.out.println("\nOk, não será impresso o array ordenado.");
                                break;
                            default:
                                System.out.println("\nOpção inválida!");
                                break;
                        }
                        break;

                    case 3:

                        Integer[] array3 = pilha.toArray(new Integer[0]);

                        // Tamanho do array3
                        int n3 = array3.length;

                        // Loop para iterar sobre o array3
                        for (int i = 1; i < n3; i++) {
                            int chave = array3[i];
                            int j = i - 1;

                            // Move os elementos do array3[0..i-1], que são maiores que a chave,
                            // para uma posição à frente de sua posição atual
                            while (j >= 0 && array3[j] > chave) {
                                array3[j + 1] = array3[j];
                                j = j - 1;
                            }
                            array3[j + 1] = chave;
                        }

                        // Limpa a pilha original
                        pilha.clear();

                        // Adiciona os elementos ordenados de volta à pilha
                        for (int i = 0; i < n3; i++) {
                            pilha.add(array3[i]);
                        }
                        System.out.println("\nO conjunto foi ordenado POR INSERCAO com sucesso!");
                        System.out.println("\nDeseja imprimir o array3 ordenado? \n1 para Sim \n2 para Não \n");
                        int printOption3 = sc.nextInt();
                        switch (printOption3) {
                            case 1:
                                System.out.println("\nArray Ordenado: " + pilha);
                                break;
                            case 2:
                                System.out.println("\nOk, não será impresso o array3 ordenado.");
                                break;
                            default:
                                System.out.println("\nOpção inválida!");
                                break;
                        }
                        break;

                    default:

                        System.out.println("\nOpção inválida!");

                        break;
                }
                break;

            case 3:
                System.out.println("\nQuantos numeros deseja por na sua Lista? ->");
                int TAM = sc.nextInt();
                Queue<Integer> lista = new LinkedList<>();

                System.out.println("digite os numeros: ");
                for (int i = 0; i < TAM; i++) {
                    lista.add(sc.nextInt());
                }

                System.out.println(
                        "\nInforme o tipo de ordenação: \n\n1 para inserção \n2 para seleção \n3 para bolha \n");
                key = sc.nextInt();

                switch (key) {
                    case 1:

                        Integer[] array = lista.toArray(new Integer[0]);

                        // Tamanho do array
                        int n = array.length;

                        // Loop para iterar sobre o array
                        for (int i = 1; i < n; i++) {
                            int chave = array[i];
                            int j = i - 1;

                            // Move os elementos do array[0..i-1], que são maiores que a chave,
                            // para uma posição à frente de sua posição atual
                            while (j >= 0 && array[j] > chave) {
                                array[j + 1] = array[j];
                                j = j - 1;
                            }
                            array[j + 1] = chave;
                        }

                        // Limpa a lista original
                        lista.clear();

                        // Adiciona os elementos ordenados de volta à lista
                        for (int i = 0; i < n; i++) {
                            lista.add(array[i]);
                        }
                        System.out.println("\nO conjunto foi ordenado POR INSERCAO com sucesso!");
                        System.out.println("\nDeseja imprimir o array ordenado? \n1 para Sim \n2 para Não \n");
                        int printOption = sc.nextInt();
                        switch (printOption) {
                            case 1:
                                System.out.println("\nArray Ordenado: " + lista);
                                break;
                            case 2:
                                System.out.println("\nOk, não será impresso o array ordenado.");
                                break;
                            default:
                                System.out.println("\nOpção inválida!");
                                break;
                        }
                        break;

                    case 2:

                        Integer[] array2 = lista.toArray(new Integer[0]);

                        // Tamanho do array2
                        int n2 = array2.length;

                        // Loop para iterar sobre o array2
                        for (int i = 1; i < n2; i++) {
                            int chave = array2[i];
                            int j = i - 1;

                            // Move os elementos do array2[0..i-1], que são maiores que a chave,
                            // para uma posição à frente de sua posição atual
                            while (j >= 0 && array2[j] > chave) {
                                array2[j + 1] = array2[j];
                                j = j - 1;
                            }
                            array2[j + 1] = chave;
                        }

                        // Limpa a lista original
                        lista.clear();

                        // Adiciona os elementos ordenados de volta à lista
                        for (int i = 0; i < n2; i++) {
                            lista.add(array2[i]);
                        }
                        System.out.println("\nO conjunto foi ordenado POR INSERCAO com sucesso!");
                        System.out.println("\nDeseja imprimir o array2 ordenado? \n1 para Sim \n2 para Não \n");
                        int printOption2 = sc.nextInt();
                        switch (printOption2) {
                            case 1:
                                System.out.println("\nArray2 Ordenado: " + lista);
                                break;
                            case 2:
                                System.out.println("\nOk, não será impresso o array2 ordenado.");
                                break;
                            default:
                                System.out.println("\nOpção inválida!");
                                break;
                        }
                        break;

                    case 3:

                        Integer[] array3 = lista.toArray(new Integer[0]);

                        // Tamanho do array3
                        int n3 = array3.length;

                        // Loop para iterar sobre o array3
                        for (int i = 1; i < n3; i++) {
                            int chave = array3[i];
                            int j = i - 1;

                            // Move os elementos do array3[0..i-1], que são maiores que a chave,
                            // para uma posição à frente de sua posição atual
                            while (j >= 0 && array3[j] > chave) {
                                array3[j + 1] = array3[j];
                                j = j - 1;
                            }
                            array3[j + 1] = chave;
                        }

                        // Limpa a lista original
                        lista.clear();

                        // Adiciona os elementos ordenados de volta à lista
                        for (int i = 0; i < n3; i++) {
                            lista.add(array3[i]);
                        }
                        System.out.println("\nO conjunto foi ordenado POR INSERCAO com sucesso!");
                        System.out.println("\nDeseja imprimir o array3 ordenado? \n1 para Sim \n3 para Não \n");
                        int printOption3 = sc.nextInt();
                        switch (printOption3) {
                            case 1:
                                System.out.println("\nArray3 Ordenado: " + lista);
                                break;
                            case 2:
                                System.out.println("\nOk, não será impresso o array3 ordenado.");
                                break;
                            default:
                                System.out.println("\nOpção inválida!");
                                break;
                        }
                        break;

                    default:

                        System.out.println("\nOpção inválida!");
                        break;
                }
                break;
            default:
                System.out.println("\nOpção inválida!");
                break;
        }

        sc.close();

    }
}