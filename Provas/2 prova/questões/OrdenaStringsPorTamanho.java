import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
public class OrdenaStringsPorTamanho {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < N; i++) {
            String linha = scanner.nextLine();
            String[] strings = linha.split(" ");
            // Ordenar as strings pelo comprimento, preservando a ordem original em caso de empate
            Arrays.sort(strings, new Comparator<String>() {
                @Override
                public int compare(String s1, String s2) {
                    return Integer.compare(s2.length(), s1.length()); // Inverter a ordem para decrescente
                }
            });
            // Imprime as strings ordenadas, separadas por um espaço
            for (int j = 0; j < strings.length; j++) {
                if (j > 0) {
                    System.out.print(" ");
                }
                System.out.print(strings[j]);
            }
            System.out.println(); // Nova linha após cada caso de teste
        }
        scanner.close();
    }
}
