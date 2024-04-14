import java.util.*;

public class etiquetasDeNoel {
    public static void main(String[] args) 
    {
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        
        String[] lista = new String[n * 2];

        for(int i = 0; i < lista.length; i++) 
        {
            lista[i] = sc.nextLine();
        }

        int m = sc.nextInt();
        sc.nextLine();

        int tam = m * 2;
        String[] lista2 = new String[tam];

        for(int i = 0; i < lista2.length; i++) 
        {
            lista2[i] = sc.nextLine();
        }

        for (int i = 0; i < lista2.length; i += 2) {
            String pais = lista2[i + 1];
            for (int j = 0; j < lista.length; j += 2) {
                if (pais.equals(lista[j])) {
                    System.out.println(lista2[i] + "\n" + lista[j + 1]);
                    System.out.println("");
                }
            }
        }
        sc.close();
    }
}
