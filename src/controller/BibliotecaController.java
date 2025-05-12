package controller;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

import model.Emprestimo;
import model.Livro;
import model.Usuario;

public class BibliotecaController {
    private List<Livro> livros;
    private List<Emprestimo> emprestimos; // Lista de empréstimos

    public BibliotecaController(List<Livro> livros, List<Emprestimo> emprestimos) {
        this.livros = livros;
        this.emprestimos = emprestimos;
    }

    public void addLivro(Livro livro) {
        livros.add(livro);
    }

    public boolean removerLivro(int codigoLivro) {
        return livros.removeIf(l -> l.getCodigoLivro() == codigoLivro);
    }

    public String emprestarLivro(Livro livro, Usuario usuario) {
        if (livro.getExemplaresDisponiveis() > 0) {
            livro.setExemplaresDisponiveis(livro.getExemplaresDisponiveis() - 1);
            LocalDate dataEmprestimo = LocalDate.now();
            LocalDate dataDevolucao = dataEmprestimo.plusDays(7); // Emprestimo de 7 dias
            Emprestimo emprestimo = new Emprestimo(livro, usuario, dataEmprestimo, dataDevolucao);
            emprestimos.add(emprestimo);
            return "Livro emprestado com sucesso! Devolução até: " + dataDevolucao;
        }
        return "Livro indisponível para empréstimo.";
    }

    public String atrasoDevolucao(Livro emprestimo) {
        if (emprestimo.estaAtrasado()) {
            return "Atenção! O livro " + emprestimo.getTitulo() + " está com " + emprestimo.diasDeAtraso()
                    + " dias de atraso.";
        } else {
            System.out.println("Nenhum atraso registrado para este empréstimo.");
        }
        return null;
    }

    public String devolverLivro(Livro livro) {
        livro.setExemplaresDisponiveis(livro.getExemplaresDisponiveis() + 1);
        return "Livro devolvido com sucesso!";
    }

    public Livro buscarLivroId(int codigoLivro) {
        return livros.stream()
                .filter(l -> l.getCodigoLivro() == codigoLivro)
                .findFirst()
                .orElse(null);
    }

    public Livro buscarLivroTitulo(String titulo) {
        return livros.stream()
                .filter(l -> l.getTitulo().equalsIgnoreCase(titulo))
                .findFirst()
                .orElse(null);
    }

    public List<Livro> buscarLivrosAutor(String autor) {
        return livros.stream()
                .filter(l -> l.getAutor().equalsIgnoreCase(autor))
                .toList();
    }

    public List<String> listarLivros() {
        return livros.stream()
                .map(Livro::toString)
                .toList();
    }

    @Override
    public String toString() {
        return "[livros=" + livros + "]";
    }

    public Collection<Livro> getEmprestimos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getEmprestimos'");
    }
}
