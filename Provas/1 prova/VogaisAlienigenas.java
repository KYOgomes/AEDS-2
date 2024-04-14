import java.util.*;

public class VogaisAlienigenas 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        String vogais;
        String frase;

        while(sc.hasNextLine()) // while(true)
        {
            vogais = sc.nextLine();
            frase = sc.nextLine();
            int cont = 0; 

            for(int i =0; i <frase.length(); i++)
            {
                for(int j =0; j<vogais.length(); j++)
                {
                    if(vogais.charAt(j) == frase.charAt(i))
                    {
                        cont++;
                    }
                }
                
            }
            System.out.println(cont);
        }
        sc.close();
    }
}
