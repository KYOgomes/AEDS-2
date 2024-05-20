import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
public class ListaTelefonica {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = reader.readLine()) != null) {
            int N = Integer.parseInt(line);
            String[] phones = new String[N];
            for (int i = 0; i < N; i++) {
                phones[i] = reader.readLine();
            }
            // Sort the array of phone numbers
            Arrays.sort(phones);
            int totalEconomy = 0;
            for (int i = 0; i < N - 1; i++) {
                totalEconomy += commonPrefixLength(phones[i], phones[i + 1]);
            }
            System.out.println(totalEconomy);
        }
    }
    // Function to find the length of the common prefix between two strings
    public static int commonPrefixLength(String a, String b) {
        int minLength = Math.min(a.length(), b.length());
        int i = 0;

        while (i < minLength && a.charAt(i) == b.charAt(i)) {
            i++;
        }
        return i;
    }
}
