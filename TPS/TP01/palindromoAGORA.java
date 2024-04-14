import java.util.Scanner;
//palindromo em java, verifica se a string é um palindromo, isto é, se ela é igual de trás pra frent
public class palindromoAGORA {
    public static void main(String[] args)
    {
        Scanner sc= new Scanner(System.in);
        String a;
        do
        {
            a = sc.nextLine();
            String b = "";

            if( a.equals("FIM"))
            {
                return;
            }

            for(int i = a.length() - 1; i>=0; i--)
            {
                b+= a.charAt(i);
            }

            
            int cont =0; 

            for(int j =0; j < a.length(); j++)
            {
                if(a.charAt(j) == b.charAt(j))
                {
                    cont++;
                }
            }

            if(cont == a.length())
            {
                System.out.println("SIM");
            }
            else 
            {
                System.out.println("NAO");
            }
        }while (!a.equals("FIM"));
        
        sc.close();
    }
}