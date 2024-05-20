import java.util.*;
import java.io.*;
public class Avistamento {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = reader.readLine().split(" ");
        int P = Integer.parseInt(firstLine[0]);
        int Q = Integer.parseInt(firstLine[1]);
        List<Relato> relatos = new ArrayList<>();
        for (int i = 0; i < Q; i++) {
            String[] line = reader.readLine().split(" ");
            String H = line[0];
            String N = line[1];
            int hour = Integer.parseInt(H.split(":")[0]);
            int minute = Integer.parseInt(H.split(":")[1]);
            // Convert time to total minutes
            int totalMinutes;
            if (hour == 23) {
                totalMinutes = hour * 60 + minute - 1440;  // 23:xx is treated as negative minutes before 00:00
            } else {
                totalMinutes = hour * 60 + minute;
            }
            if (-P <= totalMinutes && totalMinutes <= P) {
                relatos.add(new Relato(totalMinutes, i, N));
            }
        }
        // Sort the valid entries
        Collections.sort(relatos);
        // Print the result
        for (Relato relato : relatos) {
            System.out.println(relato.nome);
        }
    }
    static class Relato implements Comparable<Relato> {
        int totalMinutes;
        int order;
        String nome;
        Relato(int totalMinutes, int order, String nome) {
            this.totalMinutes = totalMinutes;
            this.order = order;
            this.nome = nome;
        }
        @Override
        public int compareTo(Relato other) {
            if (this.totalMinutes != other.totalMinutes) {
                return Integer.compare(this.totalMinutes, other.totalMinutes);
            } else {
                return Integer.compare(this.order, other.order);
            }
        }
    }
}
