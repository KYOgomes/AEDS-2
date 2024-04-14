import java.util.*;
//questao beecrowd pokemon
public class Pokemon
{
    public static void ordena(String[] pokemons)
    {
        //ordenar com o seleção    
        for(int i = 0; i < pokemons.length - 1; i++)
        {
            int menor = i;
            for(int j = i + 1; j < pokemons.length; j++)
            {
                if(pokemons[j].compareTo(pokemons[menor]) < 0)
                {
                    menor = j;
                }
            }
            String aux = pokemons[i];
            pokemons[i] = pokemons[menor];
            pokemons[menor] = aux;
        }
    } 

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //numero de pokemons capturados
        int n = sc.nextInt();
        int cont = 1;
        int total;
        sc.nextLine();

        //criar um array de strings para guardar os nomes dos pokemons
        String[] pokemons = new String[n];

        for(int i = 0; i < n; i++)
        {
            pokemons[i] = sc.nextLine();
        }

        //ordenar o arrray de strings
        ordena(pokemons);

        for(int i = 1; i < n; i++)
        {
            if(!pokemons[i].equals(pokemons[i - 1]))
            {
                cont++;
            }
        }
        total = 151 - cont;

        System.out.println("Falta(m) " + total + " pokemons.");
        sc.close();
    }
}