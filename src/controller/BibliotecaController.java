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

    public void removerLivro(Livro livro) {
        livros.remove(livro);
    }

    public List<String> listarLivros(){
        return livros.stream()
                        .map(l -> l.getTitulo())
                        .toList();
    }

    @Override
    public String toString() {
        return "BibliotecaController [livros=" + livros + "]";
    };

}
