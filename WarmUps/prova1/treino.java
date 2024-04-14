import java.util.*;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

    /*public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> lista = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            lista.add(sc.nextInt());
        }

        System.out.print("[");
        for(int j = 0; j < lista.size(); j++) {
            System.out.print(lista.get(j) + ", ");
        }
        System.out.print("]");
    }
}

for(int i =1; i <= n; i++)
{
    for(int j = 1; j<=i; j++)
    {
        a*= 2;
        b*= 2;
        c*=2;
    }
    b*=3;
    c*=3;
}
import java.util.*;

public class treino {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> lista = new ArrayList<>();
        int x = 69; // A inicialização de x é irrelevante, pois será substituída no loop
        while (x != 0) {
            x = sc.nextInt();
            if (x > 0) {
                lista.add(0, x); // Adiciona no início da lista
            } else if (x < 0) {
                lista.add(x); // Adiciona no final da lista
            }
        }
        System.out.println("Lista final: " + lista);
    }
}

int n =0;
int [] array = new int[100];
void inserir( int valor);
if(n < array.length)
{
    n++;
    array[array.length - n] = valor;
}*/

public class treino 
{
    /*private int[] fila;
    private int frente;
    private int tras;
    private int capacidade;

    public FilaCircular(int tamanho) 
    {
        this.fila = new int[tamanho];
        this.frente = -1;
        this.tras = -1;
        this.capacidade = tamanho;
    }

    public void enfileirar(int item) 
    {
        if ((tras + 1) % capacidade == frente) {
            System.out.println("Fila está cheia");
            return;
        } else if (estaVazia()) {
            frente++;
            tras++;
        } else {
            tras = (tras + 1) % capacidade;
        }

        fila[tras] = item;
    }

    public int desenfileirar() 
    {
        int item = -1;
        if (estaVazia()) {
            System.out.println("Fila está vazia");
        } else if (frente == tras) {
            item = fila[frente];
            frente = -1;
            tras = -1;
        } else {
            item = fila[frente];
            frente = (frente + 1) % capacidade;
        }
        return item;
    }

    public boolean estaVazia() 
    {
        return frente == -1;
    }

    public void imprimir() 
    {
        if (estaVazia()) {
            System.out.println("Fila está vazia");
        } else {
            if (tras >= frente) {
                for (int i = frente; i <= tras; i++) {
                    System.out.print(fila[i] + " ");
                }
            } else {
                for (int i = frente; i < capacidade; i++) {
                    System.out.print(fila[i] + " ");
                }
                for (int i = 0; i <= tras; i++) {
                    System.out.print(fila[i] + " ");
                }
            }
        }
    }*/

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String zezed = sc.nextLine();
        String caio = sc.nextLine();

        if(zezed.equals(caio))
        {
            System.out.println("enguais");
        }
        else
        {
            System.out.println("fake");
        }

    }
}