public class ArvoreBinariaLista {
    No raiz;
    
    public class No {
        int valor;
        No esq;
        No dir;

        public No(int valor) {
            this.valor = valor;
            esq = null;
            dir = null;
        }
    }

    public ArvoreBinariaLista() {
        raiz = null;
    }

    // Método para adicionar um nó na árvore
    public void adicionar(int valor) {
        raiz = adicionarRecursivo(raiz, valor);
    }

    private No adicionarRecursivo(No atual, int valor) {
        if (atual == null) {
            return new No(valor);
        }

        if (valor < atual.valor) {
            atual.esq = adicionarRecursivo(atual.esq, valor);
        } else if (valor > atual.valor) {
            atual.dir = adicionarRecursivo(atual.dir, valor);
        } else {
            // valor já existe
            return atual;
        }

        return atual;
    }

    // Método para verificar se a árvore contém um determinado valor
    public boolean contemNo(int valor) {
        return contemNoRecursivo(raiz, valor);
    }

    private boolean contemNoRecursivo(No atual, int valor) {
        if (atual == null) {
            return false;
        }
        if (valor == atual.valor) {
            return true;
        }
        return valor < atual.valor
          ? contemNoRecursivo(atual.esq, valor)
          : contemNoRecursivo(atual.dir, valor);
    }

    // Método para percorrer a árvore (in-order traversal)
    public void percorrerEmOrdem(No no) {
        if (no != null) {
            percorrerEmOrdem(no.esq);
            System.out.print(" " + no.valor);
            percorrerEmOrdem(no.dir);
        }
    }

    
        public static void main(String[] args) 
        {
            ArvoreBinariaLista arvore = new ArvoreBinariaLista();
    
            arvore.adicionar(6);
            arvore.adicionar(4);
            arvore.adicionar(8);
            arvore.adicionar(3);
            arvore.adicionar(5);
            arvore.adicionar(7);
            arvore.adicionar(9);
    
            // Verificar se a árvore contém um valor específico
            System.out.println(arvore.contemNo(5)); // true
            System.out.println(arvore.contemNo(10)); // false
    
            // Percorrer a árvore em ordem
            arvore.percorrerEmOrdem(arvore.raiz);
        }
    }

