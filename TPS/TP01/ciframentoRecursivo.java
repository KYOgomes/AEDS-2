import java.util.Scanner;
//ciframento de cesar recursiv
public class ciframentoRecursivo {

    public static String cifrar(String frase, int chave) {
        return cifrarRecursivo(frase, chave, 0, new StringBuilder());
    }

    private static String cifrarRecursivo(String frase, int chave, int index, StringBuilder resultado) {
        if (index == frase.length()) {
            return resultado.toString();
        }

        char caractere = frase.charAt(index);

        if (Character.isLetter(caractere)) {
            char base = Character.isLowerCase(caractere) ? 'a' : 'A';
            caractere = (char) (((caractere - base + chave) % 26) + base);
        }

        resultado.append(caractere);

        return cifrarRecursivo(frase, chave, index + 1, resultado);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a frase a ser cifrada: ");
        String frase = scanner.nextLine();

        System.out.print("Digite a chave de ciframento (um número inteiro): ");
        int chave = scanner.nextInt();

        String fraseCifrada = cifrar(frase, chave);
        System.out.println("Frase cifrada: " + fraseCifrada);

        scanner.close();
    }
}
