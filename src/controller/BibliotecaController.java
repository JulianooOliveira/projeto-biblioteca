package controller;

import java.util.List;

import model.Livro;

public class BibliotecaController {
    private List<Livro> livros;

    public BibliotecaController(List<Livro> livros) {
        this.livros = livros;
    }

    public void addLivro(Livro livro) {
        livros.add(livro);
    }

    public boolean removerLivro(int codigoLivro) {
        return livros.removeIf(l -> l.getCodigoLivro() == codigoLivro);
    }

    public Livro buscarLivro(int codigoLivro) {
        return livros.stream()
                .filter(l -> l.getCodigoLivro() == codigoLivro)
                .findFirst()
                .orElse(null);
    }

    public List<String> listarLivros() {
        return livros.stream()
                .map(Livro::toString)
                .toList();
    }

    @Override
    public String toString() {
        return "[livros=" + livros + "]";
    };

}
