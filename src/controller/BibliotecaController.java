package controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.Biblioteca;
import model.Emprestimo;
import model.Livro;
import model.Usuario;

public class BibliotecaController {
    private Biblioteca biblioteca;
    private List<Emprestimo> emprestimos;
    private List<Usuario> usuarios;

    public BibliotecaController(Biblioteca biblioteca, List<Emprestimo> emprestimos, List<Usuario> usuarios) {
        this.biblioteca = biblioteca;
        this.emprestimos = emprestimos;
        this.usuarios = usuarios;
    }

    public void addLivro(Livro livro) {
        biblioteca.getLivros().add(livro);
    }

    public boolean removerLivro(int codigoLivro) {
        return biblioteca.getLivros().removeIf(l -> l.getCodigoLivro() == codigoLivro);
    }

    public String emprestarLivro(Livro livro, Usuario usuario) {
        if (livro.emprestar()) {
            LocalDate dataEmprestimo = LocalDate.now();
            LocalDate dataDevolucao = dataEmprestimo.plusDays(7);
            Emprestimo emprestimo = new Emprestimo(livro, usuario, dataEmprestimo, dataDevolucao);
            emprestimos.add(emprestimo);
            return "Livro emprestado com sucesso! Devolução até: " + dataDevolucao;
        }
        return "Livro indisponível para empréstimo.";
    }

    public String devolverLivro(Livro livro, Usuario usuario) {
        Emprestimo emprestimo = emprestimos.stream()
                .filter(e -> e.getLivro().getCodigoLivro() == livro.getCodigoLivro()
                        && e.getUsuario().getEmail().equalsIgnoreCase(usuario.getEmail()))
                .findFirst()
                .orElse(null);

        if (emprestimo != null) {
            emprestimos.remove(emprestimo);
            livro.devolver();
            return "Livro devolvido com sucesso!";
        } else {
            return "Este livro não está emprestado para este usuário.";
        }
    }

    public String atrasoDevolucao(Emprestimo emprestimo) {
        if (emprestimo.estaAtrasado()) {
            return "Atenção! O livro " + emprestimo.getLivro().getTitulo() +
                    " está com " + emprestimo.diasDeAtraso() + " dias de atraso.";
        } else {
            return "Nenhum atraso registrado para este empréstimo.";
        }
    }

    public List<Emprestimo> listarEmprestimosDoUsuario(Usuario usuario) {
        return emprestimos.stream()
                .filter(e -> e.getUsuario().getEmail().equalsIgnoreCase(usuario.getEmail()))
                .toList();
    }

    public Livro buscarLivroId(int codigoLivro) {
        return biblioteca.getLivros().stream()
                .filter(l -> l.getCodigoLivro() == codigoLivro)
                .findFirst()
                .orElse(null);
    }

    public Livro buscarLivroTitulo(String titulo) {
        return biblioteca.getLivros().stream()
                .filter(l -> l.getTitulo().equalsIgnoreCase(titulo))
                .findFirst()
                .orElse(null);
    }

    public List<Livro> buscarLivrosAutor(String autor) {
        return biblioteca.getLivros().stream()
                .filter(l -> l.getAutor().equalsIgnoreCase(autor))
                .toList();
    }

    public List<String> listarLivros() {
        return biblioteca.getLivros().stream()
                .map(Livro::toString)
                .toList();
    }

    public List<Emprestimo> listarEmprestimosAtivos() {
        return new ArrayList<>(emprestimos);
    }

    public List<Livro> getLivros() {
        return biblioteca.getLivros();
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    @Override
    public String toString() {
        return "[biblioteca=" + biblioteca.getNome() + ", livros=" + biblioteca.getLivros() + "]";
    }
}
