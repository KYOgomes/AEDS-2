import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class arquivo {
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        // numero de valores a serem lidos
        int n = sc.nextInt();

        // cria um arquivo chamado "arquivo.txt"
        File arq = new File("2arquivo.txt");

        try {
            // Cria ou sobrescreve o arquivo
            FileWriter fw = new FileWriter(arq, false);
            for (int i = 0; i < n; i++) {
                double num = sc.nextDouble();
                if (num == Math.floor(num)) {
                    // se o número for um inteiro, escreva-o sem o ponto decimal
                    fw.write(Integer.toString((int) num));
                } else {
                    // caso contrário, escreva-o como está
                    fw.write(Double.toString(num));
                }
                fw.write(System.lineSeparator());
            }
            fw.close();

            // lê os valores do arquivo e armazena em uma lista
            Scanner fr = new Scanner(arq);

            // cria uma lista para armazenar os valores
            List<Double> numeros = new ArrayList<>();

            // lê os valores do arquivo enquando houver linhas
            while (fr.hasNextLine()) {
                String line = fr.nextLine();
                try {
                    // tenta analisar a linha como um inteiro
                    int num = Integer.parseInt(line);
                    numeros.add((double) num);
                } catch (NumberFormatException e) {
                    // se a linha não puder ser analisada como um inteiro, tenta analisá-la como um
                    // double
                    double num = Double.parseDouble(line);
                    numeros.add(num);
                }
            }
            fr.close();

            // imprime os valores de trás para frente
            for (int i = numeros.size() - 1; i >= 0; i--) {
                double num = numeros.get(i);
                if (num == Math.floor(num)) {
                    // se o número for um inteiro, imprima-o como um inteiro
                    System.out.println((int) num);
                } else {
                    // caso contrário, imprima-o como está
                    System.out.println(num);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        sc.close();
    }
}