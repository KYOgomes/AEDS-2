class Contato{
    private String nome, telefone, email;
    private int cpf;

    public Contato(){ this("\0", "\0", "\0", 0); }

    public Contato(String nome, String telefone, String email, int cpf){
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.cpf = cpf;
    }

    //gets

    public String getNome(){return this.nome;}

    public String getTelefone(){return this.telefone;}

    public String getEmail(){return this.email;}

    public int getCpf(){ return this.cpf;}

    //sets

    public void setNome(String nome){this.nome = nome;}

    public void setTelefone(String telefone){this.telefone = telefone;}

    public void setEmail(String email){this.email = email;}

    public void setCpf(int cpf){this.cpf = cpf;}
}

class Celula{
    private Contato contato;
    private Celula prox;

    //construtor

    public Celula(){
        this(new Contato());
    }

    public Celula(Contato contato){
        this.contato = contato;
        this.prox = null;
    }

    //gets

    public Celula getProx(){return this.prox;}
    public Contato getContato(){return this.contato;}

    //sets

    public void setProx(Celula prox){this.prox = prox;}
    public void setContato(Contato contato){this.contato = contato;}
}

class No{
    private char letra;
    private No esq, dir;
    private Celula primeiro, ultimo;

    //construtor

    public No(char letra){
        this(letra, null, null);
    }

    public No(char letra, No esq, No dir){
        this.letra = letra;
        this.esq = esq;
        this.dir = dir;
        this.primeiro = new Celula();
        this.ultimo = this.primeiro;
    }

    //gets

    public char getLetra(){return this.letra;}   
    public No getNoesq(){return this.esq;}
    public No getNodir(){return this.dir;}

    //sets

    public void setLetra(char letra){this.letra = letra;}
    public void setNoesq(No esq){this.esq = esq;}
    public void setNodir(No dir){this.dir = dir;}


    public void inserirnofim(Contato contato){
        ultimo.setProx(new Celula(contato));
        ultimo = ultimo.getProx();
    }

    public String pesquisarContato(String nome){
        Celula i;
        for(i = primeiro; i.getContato().getNome().compareTo(nome) != 0 && i != null; i = i.getProx());
        if(i == null){

            return null;
        }

        return i.getContato().getNome();
    }

    public int pesquisarContato(int cpf){
        Celula i;
        for(i = primeiro; i.getContato().getCpf() != cpf && i != null; i = i.getProx());
        if(i == null){

            return 0;
        }

        return i.getContato().getCpf();
    }
}

class Agenda{
    private No raiz;

    public Agenda() throws Exception{
        this.raiz = null;
        inserirNo("Danieli");
        inserirNo("Gabriela");
        inserirNo("Roberta");
        inserirNo("Samuel");
        inserirNo("Humberto");
    }

    public void inserirNo(String nome)throws Exception{
        try{
            raiz = inserirNo(nome, raiz);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public No inserirNo(String nome, No i) throws Exception{
        char letra = Character.toUpperCase(nome.charAt(0));
        if(i == null){
            i = new No(letra);
        }else if(i.getLetra() > letra){
            i.setNoesq(inserirNo(nome, i.getNoesq()));
        }else if(i.getLetra() < letra){
            i.setNodir(inserirNo(nome, i.getNodir()));
        }else{
            throw new Exception("Erro ao inserir, tente novamente");
        }
        return i;
    }

    public void inserirContato(Contato contato)throws Exception{
        try{
            inserirContato(contato, raiz);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void inserirContato(Contato contato, No i)throws Exception{
        char letra = Character.toUpperCase(contato.getNome().charAt(0));
        if(i == null){
            throw new Exception("Arvore varia");
        }else if(i.getLetra() > letra){
            inserirContato(contato, i.getNoesq());
        }else if(i.getLetra() < letra){
            inserirContato(contato, i.getNodir());
        }
        i.inserirnofim(contato);
    }

    public String pesquisaNo(String nome)throws Exception{
        String resp = "false";
        try{
            resp = pesquisarNo(nome, raiz);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return resp;
    }

    public String pesquisarNo(String nome, No i) throws Exception{
        String resp = "false";
        char letra = Character.toUpperCase(nome.charAt(0));
        if(i == null){
            throw new Exception("Arvore vazia");
        }else if(i.getLetra() > letra){
            pesquisarNo(nome, i.getNoesq());
        }else if(i.getLetra() < letra){
            pesquisarNo(nome, i.getNodir());
        }

        resp = i.pesquisarContato(nome);
        return resp;
    }


}

public class arvoreComLista{
    public static void main(String[]args)throws Exception
    {
        Agenda agenda = new Agenda();
        Contato contato = new Contato("Danieli", "3140028922", "danielzin@gmail.com", 14431878);
        agenda.inserirContato(contato);
        System.out.println(agenda.pesquisaNo("Danieli"));
        contato = new Contato("Kokkah", "3140028922", "danielzin@gmail.com", 14431878);
        agenda.inserirContato(contato);
        System.out.println(agenda.pesquisaNo("Kokkah"));

    }
}