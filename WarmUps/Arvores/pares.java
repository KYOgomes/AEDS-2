/** arvore binária, balancemaneto 
 * @author Caio Gomes Alcantara Glória - 763989
 * @version 08/05/2024
 */
//Exercicio imprime todos os valores paras dentro da arvore
import java.util.Scanner;
class No {
    int valor;
    No esquerda, direita;

    public No(int item) {
        valor = item;
        esquerda = direita = null;
    }
}

class pares {
    No raiz;
    Scanner sc = new Scanner(System.in);

    pares() {
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

    boolean pesquisar(int valor) {
        System.out.println("digite o valor a ser buscado:");
        valor = sc.nextInt();
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

    public int par()
    {
        return parResp(raiz);
    }

    public int parResp(No no)
    {
        int resp = 0;
        if(no != null)
        {
            if(no.valor%2==0 )
            {
                System.out.println(no.valor);
                resp = 1;
            }

            resp += parResp(no.esquerda);
            resp += parResp(no.direita);
        }
        return resp;
    }
    public static void main(String[] args) {
        int[] valores = {1, 2, 3, 5, 6, 7, 8};
        pares arvore = new pares();
        arvore.construirArvoreBalanceada(valores, 0, valores.length - 1);

        //teste de metodos com o valor 4
        System.out.println("Árvore In-Order:");
        arvore.inorder();
        System.out.println("");
        System.out.println("-----------------------------------------");
        //inserir o valor 4.
        System.out.println("Valor 4 inserido:");
        arvore.inserir(4);
        arvore.imprimirArvore();

        System.out.println("Os numeros pares da arvore sao: ");
        arvore.par();

    }
}
