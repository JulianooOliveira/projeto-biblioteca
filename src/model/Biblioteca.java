package model;

import java.util.List;

public class Biblioteca {
    private String nome;
    private List<Livro> livros;

    public Biblioteca(String nome, List<Livro> livros) {
        this.nome = nome;
        this.livros = livros;
    }

    public boolean cadastrarLivro(List<Livro> livro){
        for (Livro l : livros) {
            livros.add(l);
            return true;
        }
        return false;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }

    @Override
    public String toString() {
        return "Biblioteca [nome=" + nome + ", livros=" + livros + "]";
    }

}
