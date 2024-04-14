import java.util.Random;
import java.util.Scanner;
//alteração aletória, escolhe uma letra aleatoria da string e troca a mesma por outra aleatoria TODAS as vezes que a mesma ocorre
public class alteracaoAleatoria {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        Random gerador = new Random();
        String frase;
        String Final="";

        do
        {
            frase = sc.nextLine();
            if(frase.equals("FIM"))
            {
                break;
            }
            char letra1;
            char letra2;
            StringBuilder frases = new StringBuilder();
            //escolher uma letra aleatoria da string e trocar a mesma por outra aleatoria
            letra1 = (char)('a' + (Math.abs(gerador.nextInt()) % 26));
            letra2 = (char)('a' + (Math.abs(gerador.nextInt()) % 26));

            for (int i = 0; i < frase.length(); i++) 
            {
                if (frase.charAt(i) == letra1) 
                {
                    frases.append(letra2);
                } else {
                    frases.append(frase.charAt(i));
                }
            }
            System.out.println(frases.toString());
            
        }while(!(frase.equals("FIM")));
        sc.close();
    }
}