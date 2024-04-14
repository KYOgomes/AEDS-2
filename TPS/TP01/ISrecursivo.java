import java.util.Scanner;
//is em java recursivo
public class ISrecursivo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        recursiveCheck(sc);
        sc.close();
    }

    public static void recursiveCheck(Scanner sc) {
        String palavra = sc.nextLine();

        if (palavra.equals("FIM")) {
            return;
        }

        boolean x1 = true;
        boolean x2 = true;
        boolean x3 = true;
        boolean x4 = true;

        for (int i = 0; i < palavra.length(); i++) {
            char c = palavra.charAt(i);
            if (!isVogal(c)) {
                x1 = false;
            }
            if (!isConsoante(c)) {
                x2 = false;
            }
            if (!isInteiro(c)) {
                x3 = false;
            }
            if (!isReal(c)) {
                x4 = false;
            }
        }

        // Imprimindo os resultados
        if (x1) {
            System.out.print("SIM ");
        } else {
            System.out.print("NAO ");
        }

        if (x2) {
            System.out.print("SIM ");
        } else {
            System.out.print("NAO ");
        }

        if (x3) {
            System.out.print("SIM ");
        } else {
            System.out.print("NAO ");
        }

        if (x4) {
            System.out.print("SIM");
        } else {
            System.out.print("NAO");
        }

        System.out.println();

        recursiveCheck(sc);
    }

    //funções para verificar se um caractere é uma vogal, consoante, inteiro ou real
    // Função para verificar se um caractere é uma vogal
    public static boolean isVogal(char c) {
        return "aeiouAEIOU".indexOf(c) != -1;
    }

    // Função para verificar se um caractere é uma consoante
    public static boolean isConsoante(char c) {
        return Character.isLetter(c) && !isVogal(c);
    }

    // Função para verificar se um caractere é um número inteiro
    public static boolean isInteiro(char c) {
        return Character.isDigit(c);
    }

    // Função para verificar se um caractere é um número real
    public static boolean isReal(char c) {
        return Character.isDigit(c) || c == '.';
    }
}
