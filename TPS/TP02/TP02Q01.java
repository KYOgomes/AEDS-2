/**
 * Classe Jogadores
 * @author Caio Gomes Alcantara Glória - 763989
 * @version 1 04/2024
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TP02Q01 {

    public static void main(String args[]) {
        Personagem inicio = new Personagem();
        while (true) {
            String search = MyIO.readLine();
            if (search.equals("FIM"))
                break;

            inicio.setId(search);
            try {
                inicio.ler();
                inicio.imprimir();
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }
}

class Personagem {
    // Atributos
    private String id;
    private String nome;
    private List<String> nomeAlternativo;
    private String casa;
    private String ancestry;
    private String especie;
    private String patrono;
    private boolean hogwartsStaff;
    private String hogwartsStudent;
    private String nomeAtor;
    private boolean status;
    private LocalDate dataNascimento;
    private int anoNascimento;
    private String corOlho;
    private String genero;
    private String corCabelo;
    private boolean bruxo;

    // Construtores
    Personagem() {
        this("", "", new ArrayList<>(), "", "", "", "", false, "", "", false, null, 0, "", "", "", false);
    }

    Personagem(String id, String nome, List<String> nomeAlternativo, String casa, String ancestry, String especie,
            String patrono, boolean hogwartsStaff, String hogwartsStudent, String nomeAtor, boolean status,
            LocalDate dataNascimento, int anoNascimento, String corOlho, String genero, String corCabelo,
            boolean bruxo) {
        this.id = id;
        this.nome = nome;
        this.nomeAlternativo = nomeAlternativo;
        this.casa = casa;
        this.ancestry = ancestry;
        this.especie = especie;
        this.patrono = patrono;
        this.hogwartsStaff = hogwartsStaff;
        this.hogwartsStudent = hogwartsStudent;
        this.nomeAtor = nomeAtor;
        this.status = status;
        this.dataNascimento = dataNascimento;
        this.anoNascimento = anoNascimento;
        this.corOlho = corOlho;
        this.genero = genero;
        this.corCabelo = corCabelo;
        this.bruxo = bruxo;
    }

    // getters
    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public List<String> getNomeAlternativo() {
        return nomeAlternativo;
    }

    public String getCasa() {
        return casa;
    }

    public String getAncestry() {
        return ancestry;
    }

    public String getEspecie() {
        return especie;
    }

    public String getPatrono() {
        return patrono;
    }

    public boolean getHogwartsStaff() {
        return hogwartsStaff;
    }

    public String getHogwartsStudent() {
        return hogwartsStudent;
    }

    public String getNomeAtor() {
        return nomeAtor;
    }

    public boolean getStatus() {
        return status;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public int getAnoNascimento() {
        return anoNascimento;
    }

    public String getCorOlho() {
        return corOlho;
    }

    public String getGenero() {
        return genero;
    }

    public String getCorCabelo() {
        return corCabelo;
    }

    public boolean getBruxo() {
        return bruxo;
    }

    // setters
    public void setId(String id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNomeAlternativo(List<String> nomeAlternativo) {
        this.nomeAlternativo = nomeAlternativo;
    }

    public void setCasa(String casa) {
        this.casa = casa;
    }

    public void setAncestry(String ancestry) {
        this.ancestry = ancestry;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public void setPatrono(String patrono) {
        this.patrono = patrono;
    }

    public void setHogwartsStaff(boolean hogwartsStaff) {
        this.hogwartsStaff = hogwartsStaff;
    }

    public void setHogwartsStudent(String hogwartsStudent) {
        this.hogwartsStudent = hogwartsStudent;
    }

    public void setNomeAtor(String nomeAtor) {
        this.nomeAtor = nomeAtor;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setAnoNascimento(int anoNascimento) {
        this.anoNascimento = anoNascimento;
    }

    public void setCorOlho(String corOlho) {
        this.corOlho = corOlho;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setCorCabelo(String corCabelo) {
        this.corCabelo = corCabelo;
    }

    public void setBruxo(boolean bruxo) {
        this.bruxo = bruxo;
    }

    // metodo clone
    protected Personagem clone() throws CloneNotSupportedException {
        Personagem clone = new Personagem();
        clone.id = this.id;
        clone.nome = this.nome;
        clone.nomeAlternativo = this.nomeAlternativo;
        clone.casa = this.casa;
        clone.ancestry = this.ancestry;
        clone.especie = this.especie;
        clone.patrono = this.patrono;
        clone.hogwartsStaff = this.hogwartsStaff;
        clone.hogwartsStudent = this.hogwartsStudent;
        clone.nomeAtor = this.nomeAtor;
        clone.status = this.status;
        clone.dataNascimento = this.dataNascimento;
        clone.anoNascimento = this.anoNascimento;
        clone.corOlho = this.corOlho;
        clone.genero = this.genero;
        clone.corCabelo = this.corCabelo;
        clone.bruxo = this.bruxo;
        return clone;
    }

    // Imprimir
    public void imprimir() {
        System.out.println("[" + this.id + " ## " + this.nome + " ## {" + String.join(", ", this.nomeAlternativo)
                + "} ## "
                + this.casa + " ## " + this.ancestry + " ## " + this.especie + " ## " + this.patrono + " ## "
                + this.hogwartsStaff + " ## " + this.hogwartsStudent + " ## " + this.nomeAtor + " ## " + this.status
                + " ## " + this.dataNascimento + " ## " + this.anoNascimento + " ## " + this.corOlho + " ## "
                + this.genero + " ## " + this.corCabelo + " ## " + this.bruxo + "]");
    }

    // Ler
    public void ler() throws IOException {

        try {
            String nomeArquivo = "/tmp/characters.csv";
            FileReader fileReader = new FileReader(nomeArquivo);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String linha;
            boolean primeiraLinha = true; // Flag para controlar a primeira linha

            while ((linha = bufferedReader.readLine()) != null) {
                if (primeiraLinha) {
                    primeiraLinha = false;
                    continue; // Ignora a primeira linha com cabeçalhos
                }

                String[] campos = linha.split(",");
                String id = null;
                try {
                    id = campos[0];

                    if (id.equals(this.id)) {// O personagem com o ID desejado foi encontrado

                        this.nome = campos[1]; // Nome do personagem
                        this.nomeAlternativo = Arrays.asList(campos[2].split(", ")); // Apelidos do personagem

                        this.casa = (campos.length > 3 && !campos[3].isEmpty()) ? campos[3] : ""; // Casa do personagem
                        this.ancestry = (campos.length > 4 && !campos[4].isEmpty()) ? campos[4] : ""; // "Passado" do
                                                                                                      // personagem
                        this.especie = (campos.length > 5 && !campos[5].isEmpty()) ? campos[5] : ""; // Espécie do
                                                                                                     // personagem
                        this.patrono = (campos.length > 6 && !campos[6].isEmpty()) ? campos[6] : ""; // Patrono do
                                                                                                     // personagem

                        this.hogwartsStaff = (campos.length > 7) ? Boolean.parseBoolean(campos[7]) : false; // Funcionário
                                                                                                            // de
                                                                                                            // Hogwarts
                        this.hogwartsStudent = (campos.length > 8 && !campos[8].isEmpty()) ? campos[8] : ""; // Estudante
                                                                                                             // de
                                                                                                             // Hogwarts

                        this.nomeAtor = (campos.length > 9 && !campos[9].isEmpty()) ? campos[9] : ""; // Nome do Ator
                        this.status = (campos.length > 10) ? Boolean.parseBoolean(campos[10]) : false; // Vivo ou Morto

                        this.dataNascimento = (campos.length > 11 && !campos[11].isEmpty())
                                ? LocalDate.parse(campos[11], DateTimeFormatter.ofPattern("dd/MM/yyyy"))
                                : null; // Data de nascimento
                        this.anoNascimento = (campos.length > 12 && !campos[12].isEmpty())
                                ? Integer.parseInt(campos[12])
                                : 0; // Ano de nascimento

                        this.corOlho = (campos.length > 13 && !campos[13].isEmpty()) ? campos[13] : ""; // Cor do olho
                        this.genero = (campos.length > 14 && !campos[14].isEmpty()) ? campos[14] : ""; // Gênero
                        this.corCabelo = (campos.length > 15 && !campos[15].isEmpty()) ? campos[15] : ""; // Cor do
                                                                                                          // cabelo
                        this.bruxo = (campos.length > 17) ? Boolean.parseBoolean(campos[17]) : false; // Bruxo

                        break; // Para de ler o arquivo assim que encontrar o personagem
                    }

                } catch (NumberFormatException e) {
                    System.err.println("Erro ao converter um número: " + e.getMessage());
                }
            }

            bufferedReader.close();
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }
}
