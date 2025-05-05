package model;

public abstract class Livro {
    private String titulo, autor;
    private int anoPublicacao, exemplaresDisponiveis;

    public Livro(String titulo, String autor, int anoPublicacao, int exemplaresDisponiveis) {
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
        this.exemplaresDisponiveis = exemplaresDisponiveis;
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

    @Override
    public String toString() {
        return "CadastroLivro [titulo=" + titulo + ", autor=" + autor + ", anoPublicacao=" + anoPublicacao
                + ", exemplaresDisponiveis=" + exemplaresDisponiveis + "]";
    }

    protected abstract boolean add(String livro);

}
