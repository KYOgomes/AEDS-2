
import java.io.*;
import java.net.URL;
import java.net.URLConnection;

public class html {
    public static void main(String[] args) {
        String nomePagina = "", endereco = "";

        while(true){
            nomePagina = MyIO.readLine();
            if(nomePagina.equals("FIM")){
                break;
            }
            endereco = MyIO.readLine();
            String site = getEndereco(endereco);
            MyIO.println(contadorLetras(nomePagina, site));
        }
    }

    public static String getEndereco(String html){
        try {
            // Cria uma URL com a string fornecida
            URL url = new URL (html);
    
            // Abre uma conexão com a URL
            URLConnection connection = url.openConnection();
    
            // Cria um BufferedReader para ler o conteúdo da página
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
    
            // Lê o conteúdo da página linha por linha
            StringBuilder conteudoPagina = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                conteudoPagina.append(line);
                conteudoPagina.append("\n");
            }
    
            // Fecha o BufferedReader
            reader.close();
    
            // Retorna o conteúdo da página como uma string
            return conteudoPagina.toString();

        } catch (IOException e) {
            e.printStackTrace();
            // Caso haja algum erro durante a leitura da página, retorne nulo e imprima o erro
            return null;
        }
    }   

    public static String contadorLetras(String nomePagina, String site){

        //contador para as letras
        int contA = 0, contE = 0, contI = 0, contO = 0, contU = 0, contAAgudo = 0, contEAgudo = 0, contIAgudo = 0, contOAgudo = 0, contUAgudo = 0;
        int contAInvert = 0, contEInvert = 0, contIInvert = 0, contOInvert = 0, contUInvert = 0, contATil = 0, contOTil = 0, contAChapeu = 0, contEChapeu = 0;
        int contIChapeu = 0, contOChapeu = 0, contUChapeu = 0, contConsoante = 0, contBarra = 0, contTable = 0;

        for (int pos = 0; pos < site.length(); pos++) {
            char letraLida = site.charAt(pos);

            if ((letraLida >= 'b' && letraLida <= 'z')
                    && (letraLida != 'e' && letraLida != 'i' && letraLida != 'o' && letraLida != 'u')) {
                contConsoante++;
            } else if (letraLida == 'a') {
                contA++;
            } else if (letraLida == 'e') {
                contE++;
            } else if (letraLida == 'i') {
                contI++;
            } else if (letraLida == 'o') {
                contO++;
            } else if (letraLida == 'u') {
                contU++;
            } else if (letraLida == 225) {//não reconhece colocando 'á'
                contAAgudo++;
            } else if (letraLida == 233) {//não reconhece colocando 'é'
                contEAgudo++;
            } else if (letraLida == 237) {//não reconhece colocando 'í'
                contIAgudo++;
            } else if (letraLida == 243) {//não reconhece colocando 'ó'
                contOAgudo++;
            } else if (letraLida == 250) {//não reconhece colocando 'ú'
                contUAgudo++;
            } else if (letraLida == 224) {//não reconhece colocando 'à'
                contAInvert++;
            } else if (letraLida == 232) {//não reconhece colocando 'è'
                contEInvert++;
            } else if (letraLida == 236) {//não reconhece colocando 'ì'
                contIInvert++;
            } else if (letraLida == 227) {//não reconhece colocando 'ã'
                contATil++;
            } else if (letraLida == 245) {//não reconhece colocando 'õ'
                contOTil++;
            } else if (letraLida == 226) {//não reconhece colocando 'â'
                contAChapeu++;
            } else if (letraLida == 234) {//não reconhece colocando 'ê'
                contEChapeu++;
            } else if (letraLida == 244) {//não reconhece colocando 'ô'
                contOChapeu++;
            } else if (letraLida == 60) {
                if (pos + 3 < site.length()) {
                    String tag = site.substring(pos, pos + 4);
                    if (tag.equals("<br>")) {
                        contBarra++;
                        contConsoante -= 2;
                    }
                }
                if (pos + 6 < site.length()) {
                    String tag = site.substring(pos, pos + 7);
                    if (tag.equals("<table>")) {
                        contTable++;
                        contA--;
                        contE--;
                        contConsoante -=3;
                    }
                }
            }
        }

        //Não existe ò, ù, î e û, por isso, continuaram como 0 e não entraram na verificão if else.
        String resposta = "a("+contA+") e("+contE+") i("+contI+") o("+contO+") u("+contU+") á("+contAAgudo+") é("+contEAgudo+") í("+contIAgudo+") ó("+contOAgudo+") ú("+contUAgudo+
        ") à("+contAInvert+") è("+contEInvert+") ì("+contIInvert+") ò("+contOInvert+") ù("+contUInvert+") ã("+contATil+") õ("+contOTil+") â("+contAChapeu+") ê("+contEChapeu+
        ") î("+contIChapeu+") ô("+contOChapeu+") û("+contUChapeu+") consoante("+contConsoante+") <br>("+contBarra+") <table>("+contTable+") " +nomePagina;
        
        return resposta;
    }
}