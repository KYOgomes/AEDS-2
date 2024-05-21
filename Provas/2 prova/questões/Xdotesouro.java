import java.util.Random;
import java.util.Scanner;

public class XdoTesouro {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        System.out.print("Digite o número de linhas e colunas da matriz: ");
        int n = sc.nextInt();
        // Criar a matriz flexível
        int[][] matriz = new int[n][n];
        // Preencher a matriz com números aleatórios e imprimir a matriz
        System.out.println("Matriz gerada:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matriz[i][j] = random.nextInt(100); // números aleatórios entre 0 e 99
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println();
        }
        int somaDiagonalPrincipal = 0;
        int somaDiagonalSecundaria = 0;
        // Somar os elementos das diagonais
        for (int i = 0; i < n; i++) {
            somaDiagonalPrincipal += matriz[i][i]; // Diagonal principal (\)
            somaDiagonalSecundaria += matriz[i][n - 1 - i]; // Diagonal secundária (/)
        }
        // Imprimir a soma das diagonais
        System.out.println("Soma da diagonal principal: " + somaDiagonalPrincipal);
        System.out.println("Soma da diagonal secundária: " + somaDiagonalSecundaria);
        System.out.println("Soma total das duas diagonais: " + (somaDiagonalPrincipal + somaDiagonalSecundaria));
        sc.close();
    }
}
