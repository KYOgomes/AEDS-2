import java.util.*;

public class Olimpiadas_de_Natal_2018 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, int[]> medalCount = new HashMap<>();

        while (scanner.hasNext()) {
            String prova = scanner.nextLine();
            String ouro = scanner.nextLine();
            String prata = scanner.nextLine();
            String bronze = scanner.nextLine();
            if (scanner.hasNext()) {
                scanner.nextLine(); // para consumir a linha em branco entre as provas (exceto EOF)
            }

            // Adicionar medalhas de ouro
            medalCount.putIfAbsent(ouro, new int[3]);
            medalCount.get(ouro)[0]++;

            // Adicionar medalhas de prata
            medalCount.putIfAbsent(prata, new int[3]);
            medalCount.get(prata)[1]++;

            // Adicionar medalhas de bronze
            medalCount.putIfAbsent(bronze, new int[3]);
            medalCount.get(bronze)[2]++;
        }

        List<Map.Entry<String, int[]>> list = new ArrayList<>(medalCount.entrySet());
        list.sort((o1, o2) -> {
            int total1 = o1.getValue()[0] + o1.getValue()[1] + o1.getValue()[2];
            int total2 = o2.getValue()[0] + o2.getValue()[1] + o2.getValue()[2];
            if (total1 != total2) {
                return total2 - total1;
            } else if (o1.getValue()[0] != o2.getValue()[0]) {
                return o2.getValue()[0] - o1.getValue()[0];
            } else if (o1.getValue()[1] != o2.getValue()[1]) {
                return o2.getValue()[1] - o1.getValue()[1];
            } else {
                return o2.getValue()[2] - o1.getValue()[2];
            }
        });

        // Imprimir o quadro de medalhas
        System.out.println("Quadro de Medalhas");
        for (Map.Entry<String, int[]> entry : list) {
            String pais = entry.getKey();
            int[] medals = entry.getValue();
            System.out.println(pais + " " + medals[0] + " " + medals[1] + " " + medals[2]);
        }
    }
}