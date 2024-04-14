import java.util.Scanner;
//is em java
public class Is {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String palavra;

        do {
            palavra = sc.nextLine();
            if (palavra.equals("FIM")) {
                break;
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
        } while (!palavra.equals("FIM"));
        sc.close();
    }


    // Função para verificar se um caractere é uma vogal recurssivamente
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
