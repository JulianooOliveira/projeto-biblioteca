package model;

public abstract class Pessoa {
    private String nome;
    private String endereco;
    private String email;
    private String telefone;

    public Pessoa(String nome, String endereco, String email, String telefone) {
        this.nome = nome;
        this.endereco = endereco;
        this.email = email;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public abstract String getIdentificacao();

    @Override
    public String toString() {
        return "Pessoa [nome=" + nome + ", endereco=" + endereco + ", email=" + email + ", telefone=" + telefone + "]";
    }
}
