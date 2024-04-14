import java.util.Scanner;
//palindromo java recursivo
public class Palindromorecursivo {

    public static boolean verificarPalindromo(String str) {
        // Se a string for vazia ou tiver apenas um caractere, é um palíndromo
        if (str.length() <= 1) {
            return true;
        }
        // Verifica se o primeiro e o último caractere são iguais
        if (str.charAt(0) != str.charAt(str.length() - 1)) {
            return false;
        }
        // Chama recursivamente verificando o palíndromo da substring entre o primeiro e último caractere
        return verificarPalindromo(str.substring(1, str.length() - 1));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;

        do {
            input = scanner.nextLine();
            if (!input.equals("FIM")) {
                // Verifica se a entrada é um palíndromo e imprime o resultado
                if (verificarPalindromo(input)) {
                    System.out.println("SIM");
                } else {
                    System.out.println("NAO");
                }
            }
        } while (!input.equals("FIM"));

        scanner.close();
    }
}