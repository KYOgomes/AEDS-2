import java.util.*;
class Rena implements Comparable<Rena> {
    String nome;
    int peso;
    int idade;
    double altura;
    public Rena(String nome, int peso, int idade, double altura) {
        this.nome = nome;
        this.peso = peso;
        this.idade = idade;
        this.altura = altura;
    }
    @Override
    public int compareTo(Rena outra) {
        if (this.peso != outra.peso) {
            return outra.peso - this.peso; // Peso decrescente
        }
        if (this.idade != outra.idade) {
            return this.idade - outra.idade; // Idade crescente
        }
        return this.nome.compareTo(outra.nome); // Nome lexicográfico
    }
}
public class elfoDasTrevas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // Número de casos de teste
        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt(); // Número total de renas
            int M = sc.nextInt(); // Número de renas que irão puxar o trenó
            List<Rena> renas = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                String nome = sc.next();
                int peso = sc.nextInt();
                int idade = sc.nextInt();
                double altura = sc.nextDouble();
                renas.add(new Rena(nome, peso, idade, altura));
            }
            Collections.sort(renas);
            System.out.println("CENARIO {" + t + "}");
            for (int i = 0; i < M; i++) {
                System.out.println((i + 1) + " - " + renas.get(i).nome);
            }
        }
        sc.close();
    }
}
