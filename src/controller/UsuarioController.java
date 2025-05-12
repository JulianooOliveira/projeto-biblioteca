package controller;

import java.util.List;

import model.Usuario;

public class UsuarioController {
    private List<Usuario> usuarios;

    public UsuarioController(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public void addUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public boolean removerUsuarioPorNome(String nome) {
        return usuarios.removeIf(u -> u.getNome().equalsIgnoreCase(nome));
    }

    public Usuario buscarUsuarioPorEmail(String email) {
        return usuarios.stream()
                .filter(u -> u.getEmail().equalsIgnoreCase(email))
                .findFirst()
                .orElse(null);
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    @Override
    public String toString() {
        return "UsuarioController [usuarios=" + usuarios + "]";
    }

}
