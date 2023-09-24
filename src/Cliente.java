public class Cliente {
    private String nome;
    private String CPF;

    public Cliente (String nome, String CPF){ //construtor
        this.nome = nome;
        this.CPF = CPF;
    }

    public String getCPF(){ //retornador do CPF
        return CPF;
    }

    public String getNome(){
        return nome;
    }
}
