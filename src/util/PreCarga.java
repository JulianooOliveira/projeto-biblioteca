package util;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.Emprestimo;
import model.Livro;
import model.Usuario;

public class PreCarga {

    public static List<Livro> carregarLivros() {
        return LivroUtils.gerarLivros(); // já existente
    }

    public static List<Usuario> carregarUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario("João Silva", "Rua A, 123", "joao@email.com", "99999-9999"));
        usuarios.add(new Usuario("Maria Oliveira", "Av. Central, 456", "maria@email.com", "98888-8888"));
        usuarios.add(new Usuario("Carlos Souza", "Rua B, 789", "carlos@email.com", "97777-7777"));
        return usuarios;
    }

    public static List<Emprestimo> carregarEmprestimos(List<Livro> livros, List<Usuario> usuarios) {
        List<Emprestimo> emprestimos = new ArrayList<>();

        // Emprestimo atual, dentro do prazo
        emprestimos.add(new Emprestimo(
                livros.get(0), // Código Limpo
                usuarios.get(0),
                LocalDate.now().minusDays(3),
                LocalDate.now().plusDays(4)));

        // Emprestimo com atraso de 2 dias
        emprestimos.add(new Emprestimo(
                livros.get(1), // Padrões de Projeto
                usuarios.get(1),
                LocalDate.now().minusDays(10),
                LocalDate.now().minusDays(2)));

        // Emprestimo com atraso de 7 dias
        emprestimos.add(new Emprestimo(
                livros.get(2), // Engenharia de Software
                usuarios.get(2),
                LocalDate.now().minusDays(15),
                LocalDate.now().minusDays(7)));

        // Ajusta os exemplares disponíveis
        livros.get(0).emprestar();
        livros.get(1).emprestar();
        livros.get(2).emprestar();

        return emprestimos;
    }
}
