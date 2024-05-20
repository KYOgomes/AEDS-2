class No {
    int valor;
    No esquerda, direita;

    public No(int item) {
        valor = item;
        esquerda = direita = null;
    }
}

class ArvoreBST {
    No raiz;

    ArvoreBST() {
        raiz = null;
    }

    // Método para inserir um novo nó na árvore
    void inserir(int valor) {
        raiz = inserirRec(raiz, valor);
    }

    // Método auxiliar para inserir um novo nó na árvore
    No inserirRec(No raiz, int valor) {
        if (raiz == null) {
            raiz = new No(valor);
            return raiz;
        }

        if (valor < raiz.valor) {
            raiz.esquerda = inserirRec(raiz.esquerda, valor);
        } else if (valor > raiz.valor) {
            raiz.direita = inserirRec(raiz.direita, valor);
        }

        return raiz;
    }

    // Método para realizar a caminhada central e preencher o array ordenado
    void caminharCentral(No raiz, int[] array, Contador contador) {
        if (raiz != null) {
            caminharCentral(raiz.esquerda, array, contador);
            array[contador.index++] = raiz.valor;
            caminharCentral(raiz.direita, array, contador);
        }
    }

    // Classe auxiliar para manter o índice atual durante a caminhada central
    class Contador {
        int index = 0;
    }
}

public class TreeSort {
    public static void ordenar(int[] array) {
        ArvoreBST arvore = new ArvoreBST();
        
        // Inserir todos os elementos no BST
        for (int valor : array) {
            arvore.inserir(valor);
        }

        // Caminhar pela árvore em ordem e preencher o array
        ArvoreBST.Contador contador = arvore.new Contador();
        arvore.caminharCentral(arvore.raiz, array, contador);
    }

    public static void main(String[] args) {
        int[] array = {5, 3, 7, 1, 9, 4};
        
        System.out.println("Array original:");
        for (int valor : array) {
            System.out.print(valor + " ");
        }
        
        ordenar(array);
        
        System.out.println("\nArray ordenado:");
        for (int valor : array) {
            System.out.print(valor + " ");
        }
    }
}
