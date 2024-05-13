/** arvore binária, imprimir, pesquisar, iserir\remover e altura
 * @author Caio Gomes Alcantara Glória - 763989
 * @version 08/05/2024
 */
//arvore não balanceada, onde o primeiro elemento a ser adicionado sempre será a raiz
class No {
    int valor;
    No esquerda, direita;

    public No(int item) {
        valor = item;
        esquerda = direita = null;
    }
}

class ArvoreBinaria {
    No raiz;

    ArvoreBinaria() {
        raiz = null;
    }


    //CUSTO INSERIR E REMOVER
    //O(logn) quando balanceada. E em desbalanceada, o custo pode ser tão alto quanto 𝑂(𝑛)
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

    void remover(int valor) {
        raiz = removerRec(raiz, valor);
    }

    No removerRec(No raiz, int valor) {
        if (raiz == null) return raiz;

        if (valor < raiz.valor)
            raiz.esquerda = removerRec(raiz.esquerda, valor);
        else if (valor > raiz.valor)
            raiz.direita = removerRec(raiz.direita, valor);
        else {
            if (raiz.esquerda == null)
                return raiz.direita;
            else if (raiz.direita == null)
                return raiz.esquerda;

            raiz.valor = valorMinimo(raiz.direita);
            raiz.direita = removerRec(raiz.direita, raiz.valor);
        }

        return raiz;
    }

    int valorMinimo(No no) {
        int min = no.valor;
        while (no.esquerda != null) {
            min = no.esquerda.valor;
            no = no.esquerda;
        }
        return min;
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

    // Método para pesquisar um elemento na árvore, melhor caso O(1), pior caso O(n), caso medio O(lg n)
    boolean pesquisar(int valor) {
        return pesquisarRec(raiz, valor);
    }

    boolean pesquisarRec(No raiz, int valor) {
        if (raiz == null)
            return false;

        if (raiz.valor == valor)
            return true;

        if (valor < raiz.valor)
            return pesquisarRec(raiz.esquerda, valor);
        else
            return pesquisarRec(raiz.direita, valor);
    }

    // Função para calcular a altura da árvore
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
        ArvoreBinaria arvore = new ArvoreBinaria();

        arvore.inserir(1);
        arvore.inserir(2);
        arvore.inserir(3);
        arvore.inserir(4);
        arvore.inserir(5);
        arvore.inserir(6);
        arvore.inserir(7);

        System.out.println("Árvore In-Order:");
        arvore.inorder();

        /*System.out.println("\nRemovendo 2:");
        arvore.remover(7);
        System.out.println("Árvore In-Order após remoção:");
        arvore.inorder();*/

        System.out.println("\nRemovendo 10:");
        arvore.remover(10);
        System.out.println("Árvore In-Order após remoção:");
        arvore.inorder();

        System.out.println("Árvore Binária:");
        arvore.imprimirArvore();

        System.out.println("Altura da árvore: " + arvore.altura());

        int elemento = 10;
        if (arvore.pesquisar(elemento))
            System.out.println("\nO elemento " + elemento + " está presente na árvore.");
        else
            System.out.println("\nO elemento " + elemento + " não está presente na árvore.");
    }
}
