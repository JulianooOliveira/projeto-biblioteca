package model;

public class Livro implements Emprestavel {
    private String titulo, autor;
    private int codigoLivro, anoPublicacao, exemplaresDisponiveis;

    public Livro(int codigoLivro, String titulo, String autor, int anoPublicacao, int exemplaresDisponiveis) {
        this.codigoLivro = codigoLivro;
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
        this.exemplaresDisponiveis = exemplaresDisponiveis;
    }

    @Override
    public boolean emprestar() {
        if (exemplaresDisponiveis > 0) {
            exemplaresDisponiveis--;
            return true;
        }
        return false;
    }

    @Override
    public boolean devolver() {
        exemplaresDisponiveis++;
        return true;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public int getExemplaresDisponiveis() {
        return exemplaresDisponiveis;
    }

    public void setExemplaresDisponiveis(int exemplaresDisponiveis) {
        this.exemplaresDisponiveis = exemplaresDisponiveis;
    }

    public int getCodigoLivro() {
        return codigoLivro;
    }

    public void setCodigoLivro(int codigoLivro) {
        this.codigoLivro = codigoLivro;
    }

    @Override
    public String toString() {
        return "Livro [codigoLivro=" + codigoLivro + ", titulo=" + titulo + ", autor=" + autor + " anoPublicacao="
                + anoPublicacao + ", exemplaresDisponiveis="
                + exemplaresDisponiveis + "]";
    }

}
