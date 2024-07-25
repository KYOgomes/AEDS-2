import java.util.*;
import java.io.*;

public class Pontos_de_Feno_1261 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] line = br.readLine().split(" ");
        int numPalavras = Integer.parseInt(line[0]);
        int qtsCargos = Integer.parseInt(line[1]);
        
        Map<String, Integer> cargos = new HashMap<>();
        for (int i = 0; i < numPalavras; i++) {
            line = br.readLine().split(" ");
            String cargo = line[0];
            int comissao = Integer.parseInt(line[1]);
            cargos.put(cargo, comissao);
        }
        
        while (qtsCargos-- > 0) {
            int qtsSalarioTotal = 0;
            String texto;
            while (!(texto = br.readLine()).equals(".")) {
                String[] palavras = texto.split(" ");
                for (String palavra : palavras) {
                    if (cargos.containsKey(palavra)) {
                        qtsSalarioTotal += cargos.get(palavra);
                    }
                }
            }
            System.out.println(qtsSalarioTotal);
        }
        
        br.close();
    }
}