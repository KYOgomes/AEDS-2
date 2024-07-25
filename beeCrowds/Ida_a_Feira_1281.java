import java.util.*;
//saída errada
public class Ida_a_Feira_1281 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine(); // Consumir a linha restante após o inteiro

        for (int k = 0; k < N; ++k) {
            int M = sc.nextInt();
            sc.nextLine(); // Consumir a linha restante após o inteiro
            Map<String, Double> precos = new HashMap<>();

            for (int i = 0; i < M; ++i) {
                String fruta = sc.next();
                double preco = sc.nextDouble();
                sc.nextLine(); // Consumir a linha restante após os dados da fruta
                precos.put(fruta, preco);
            }

            int P = sc.nextInt();
            sc.nextLine(); // Consumir a linha restante após o inteiro
            double resposta = 0.0;

            for (int i = 0; i < P; ++i) {
                String fruta = sc.next();
                int quantidade = sc.nextInt();
                sc.nextLine(); // Consumir a linha restante após os dados da quantidade
                resposta += quantidade * precos.get(fruta);
            }

            System.out.printf("R$ %.2f\n", resposta);
        }

        sc.close();
    }
}
