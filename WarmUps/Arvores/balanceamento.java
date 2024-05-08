/** Classe Jogadores
 * @author Caio Gomes Alcantara Glória - 763989
 * @version 08/05/2024
 */

class No {
    int valor;
    No esquerda, direita;

    public No(int item) {
        valor = item;
        esquerda = direita = null;
    }
}

class balanceamento {
    No raiz;

    balanceamento() {
        raiz = null;
    }

    void inserir(int valor) {
        raiz = inserirRec(raiz, valor);
    }

    No inserirRec(No raiz, int valor) {
        if (raiz == null) {
            raiz = new No(valor);
            return raiz;
        }

        if (valor < raiz.valor)
            raiz.esquerda = inserirRec(raiz.esquerda, valor);
        else if (valor > raiz.valor)
            raiz.direita = inserirRec(raiz.direita, valor);

        return raiz;
    }

    //CUSTO PARA BALANCEAR é O(n)
    void construirArvoreBalanceada(int[] valores, int inicio, int fim) {
        if (inicio <= fim) {
            int meio = (inicio + fim) / 2;
            inserir(valores[meio]);
            construirArvoreBalanceada(valores, inicio, meio - 1);
            construirArvoreBalanceada(valores, meio + 1, fim);
        }
    }

    void inorder() {
        inorderRec(raiz);
    }

    void inorderRec(No raiz) {
        if (raiz != null) {
            inorderRec(raiz.esquerda);
            System.out.print(raiz.valor + " ");
            inorderRec(raiz.direita);
        }
    }

    void imprimirArvore() {
        imprimirArvoreRec(raiz, 0);
    }

    void imprimirArvoreRec(No raiz, int espaco) {
        if (raiz == null)
            return;

        espaco += 10;

        imprimirArvoreRec(raiz.direita, espaco);

        System.out.print("\n");
        for (int i = 10; i < espaco; i++)
            System.out.print(" ");
        System.out.print(raiz.valor + "\n");

        imprimirArvoreRec(raiz.esquerda, espaco);
    }

    int altura() {
        return alturaRec(raiz);
    }

    // Função auxiliar recursiva para calcular a altura de um nó
    int alturaRec(No no) {
        if (no == null)
            return 0;
        else {
            int alturaEsquerda = alturaRec(no.esquerda);
            int alturaDireita = alturaRec(no.direita);

            // A altura é a maior altura entre a subárvore esquerda e a subárvore direita, mais 1 para contar o próprio nó
            return Math.max(alturaEsquerda, alturaDireita) + 1;
        }
    }

    public static void main(String[] args) {
        int[] valores = {1, 2, 3, 4, 5, 6, 7};
        balanceamento arvore = new balanceamento();
        arvore.construirArvoreBalanceada(valores, 0, valores.length - 1);

        System.out.println("Árvore In-Order:");
        arvore.inorder();
        System.out.println("Árvore Binária:");
        arvore.imprimirArvore();

        System.out.println("A altura da arvore e: " + arvore.altura());
    }
}
