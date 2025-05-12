package model;

public class Usuario extends Pessoa {

    public Usuario(String nome, String endereco, String email, String telefone) {
        super(nome, endereco, email, telefone);
    }

    @Override
    public String getIdentificacao() {
        return getEmail(); // Poderia ser CPF, ID etc.
    }

    @Override
    public String toString() {
        return "Usuario [nome=" + getNome() + ", endereco=" + getEndereco() + ", email=" + getEmail()
                + ", telefone=" + getTelefone() + "]";
    }
}
