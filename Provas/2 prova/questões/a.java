/* VAM DE ALUNOS
#include <stdio.h>
#include <string.h>
#include <stdlib.h>

typedef struct
{
    char nome[101];
    char regiao;
    int custo;
} Alunos;

int main()
{   
    int q; 
    scanf("%d", &q);
    Alunos pessoa[q];  
    for(int i = 0; i < q; i++)
    {
        scanf("%s %c %d", pessoa[i].nome, &pessoa[i].regiao, &pessoa[i].custo); 
    }   
    char nomes[q][101];

    //ordenar primeiro por custo, região (L, N, O, S)nesta ordem, e por fim nome.
    //bubbleSort O(n^2) no pior caso e O(n) no melhor caso
    for(int i = 0; i < q; i++)
    {
        for(int j = i+1; j < q; j++)
        {
            if(pessoa[i].custo > pessoa[j].custo)
            {
                Alunos temp = pessoa[i];
                pessoa[i] = pessoa[j];
                pessoa[j] = temp;
            }
            else if(pessoa[i].custo == pessoa[j].custo)
            {
                if(pessoa[i].regiao > pessoa[j].regiao)
                {
                    Alunos temp = pessoa[i];
                    pessoa[i] = pessoa[j];
                    pessoa[j] = temp;
                }
                else if(pessoa[i].regiao == pessoa[j].regiao)
                {
                    if(strcmp(pessoa[i].nome, pessoa[j].nome) > 0)
                    {
                        Alunos temp = pessoa[i];
                        pessoa[i] = pessoa[j];
                        pessoa[j] = temp;
                    }
                }
            }
        }
    }
    printf("------------------------------------\n");
    for(int i = 0; i < q; i++)
    {
        printf("%s\n", pessoa[i].nome);
    }
    return 0;
}
-------------------------------------------------------------------------------
BATUKE FILHO DA PUTA
import java.util.Scanner;
import java.util.ArrayList;
class Celula{
    int pos;
    Celula esq,dir,inf,sup;
    public Celula()
    {
        this.pos = 0;
        this.esq = this.dir = this.inf = this.sup = null;
    }
    public Celula(int x)
    {
        this.pos = x;
        this.esq = this.dir= this.inf= this.sup = null;
    }
}

class Matriz
{
    private Celula inicio;
    private int linha,coluna;
    public Matriz(int linhas, int colunas)
    {
        int count = 1;
        inicio = new Celula(count++);
        this.linha = linhas;
        this.coluna = colunas;
        Celula i = inicio;
        for(int j = 1; j<this.coluna; j++)
        {
            Celula nova = new Celula(count++);
            i.dir = nova;
            nova.esq = i;
            i = nova;
        }
        Celula linhaAnterior = inicio;
        for(int k = 1; k < this.linha; k++)
        {
            Celula novaLinha = new Celula(count++);
            linhaAnterior.inf = novaLinha;
            novaLinha.sup = linhaAnterior;
            Celula celulaAtualLinha = novaLinha;
            Celula celulaAcima = linhaAnterior;
            for(int j = 1; j<this.coluna;j++){
                Celula novaCelula = new Celula(count++);
                celulaAtualLinha.dir = novaCelula;
                novaCelula.esq = celulaAtualLinha;
                celulaAcima = celulaAcima.dir;
                celulaAcima.inf = novaCelula;
                novaCelula.sup = celulaAcima;
                celulaAtualLinha = novaCelula;
            }
            linhaAnterior=novaLinha;
        }
    }
    public void caminhar(int lin, int col){
        int s = 0;
        ArrayList<Integer> percorridos= new ArrayList<Integer>();
        int count = 0;
        Celula aux = inicio;
        //Setar posicao inicial
        for(int i = 0; i< lin; i++){
            aux = aux.inf;
        }
        for(int j = 0; j< col; j++){
            aux = aux.dir;
        }
        int passos = 1; 
        int qtd = 0;
        percorridos.add(aux.pos);
        qtd++;
        System.out.print(aux.pos+" ");
        while(qtd<this.linha*this.coluna){
           for(int i = 0; i< passos; i++){
            aux = aux.dir;
            System.out.print(aux.pos+" ");
            if(!percorridos.contains(aux.pos)){
                percorridos.add(aux.pos);
            }
            qtd++;
           }
           for(int i = 0; i< passos; i++){
            aux = aux.inf;
            System.out.print(aux.pos+" ");
            if(!percorridos.contains(aux.pos)){
                percorridos.add(aux.pos);
            }
            qtd++;
           }
           passos++;
           for(int i = 0; i< passos; i++){
            aux = aux.esq;
            System.out.print(aux.pos+" ");
            if(!percorridos.contains(aux.pos)){
                percorridos.add(aux.pos);
            }
            qtd++;
            if(qtd == (this.linha*this.coluna)){
                break;
               }
           }          
           if(qtd == (this.linha*this.coluna)){
            break;
           }
           for(int i = 0; i< passos; i++){
            aux = aux.sup;
            System.out.print(aux.pos+" ");
            if(!percorridos.contains(aux.pos)){
                percorridos.add(aux.pos);
            } 
            qtd++;
           }
           passos++;
        }
        System.out.println("\n" +qtd);
    }
}

public class batuke{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int lin = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        Matriz vizinhanca = new Matriz(lin,lin);
        vizinhanca.caminhar(x, y);
        sc.close();
    }
}
-----------------------------------------------------------------------------

*/