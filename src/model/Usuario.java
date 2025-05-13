package model;

public class Usuario extends Pessoa {
    private int codigoUsuario;

    public Usuario(int codigoUsuario, String nome, String endereco, String email, String telefone) {
        super(nome, endereco, email, telefone);
        this.codigoUsuario = codigoUsuario;
    }

    public int getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(int codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    @Override
    public String getIdentificacao() {
        return getEmail();
    }

    @Override
    public String toString() {
        return "Usuario [nome=" + getNome() + ", endereco=" + getEndereco() + ", email=" + getEmail()
                + ", telefone=" + getTelefone() + "]\n";
    }

}
