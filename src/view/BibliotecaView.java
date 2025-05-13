package view;

import controller.BibliotecaController;
import model.Emprestimo;
import model.Livro;
import model.Usuario;
import util.PreCarga;

import java.util.List;
import java.util.Scanner;

public class BibliotecaView {
    public static void main(String[] args) {
        List<Livro> livros = PreCarga.carregarLivros();
        List<Usuario> usuarios = PreCarga.carregarUsuarios();
        List<Emprestimo> emprestimos = PreCarga.carregarEmprestimos(livros, usuarios);

        BibliotecaController controller = new BibliotecaController(livros, emprestimos, usuarios);
        Scanner scanner = new Scanner(System.in);

        Usuario usuarioAtual = usuarios.get(0); // Simula login com o primeiro usuário da lista

        int opcao;
        do {
            System.out.println("\n=== SISTEMA BIBLIOTECA ===");
            System.out.println("Usuário logado: " + usuarioAtual.getNome());
            System.out.println("1. Cadastrar novo livro");
            System.out.println("2. Cadastrar novo usuário");
            System.out.println("3. Listar usuários");
            System.out.println("4. Deletar livro");
            System.out.println("5. Listar livros");
            System.out.println("6. Listar livros emprestados (do usuário)");
            System.out.println("7. Buscar livro por título");
            System.out.println("8. Buscar livro por código");
            System.out.println("9. Buscar livros por autor");
            System.out.println("10. Emprestar livro");
            System.out.println("11. Devolver livro");
            System.out.println("12. Verificar atraso");
            System.out.println("13. Listar empréstimos atrasados");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // consumir quebra de linha

            switch (opcao) {
                case 1 -> {
                    System.out.print("Título: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Autor: ");
                    String autor = scanner.nextLine();
                    System.out.print("Ano de publicação: ");
                    int ano = scanner.nextInt();
                    System.out.print("Exemplares disponíveis: ");
                    int exemplares = scanner.nextInt();
                    scanner.nextLine();

                    int novoCodigo = controller.getLivros().stream()
                            .mapToInt(Livro::getCodigoLivro)
                            .max()
                            .orElse(0) + 1;

                    Livro novoLivro = new Livro(novoCodigo, titulo, autor, ano, exemplares);
                    controller.addLivro(novoLivro);
                    System.out.println("Livro cadastrado com sucesso!");
                }

                case 2 -> {
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Endereço: ");
                    String endereco = scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    System.out.print("Telefone: ");
                    String telefone = scanner.nextLine();
                    int novoCodigoUsuario = controller.getUsuarios().stream()
                            .mapToInt(Usuario::getCodigoUsuario)
                            .max()
                            .orElse(0) + 1;

                    Usuario novoUsuario = new Usuario(novoCodigoUsuario, nome, endereco, email, telefone);
                    usuarios.add(novoUsuario);
                    System.out.println("Usuário cadastrado com sucesso!");
                }

                case 3 -> {
                    List<Usuario> todosUsuarios = controller.getUsuarios();
                    if (todosUsuarios.isEmpty()) {
                        System.out.println("Nenhum usuário cadastrado.");
                    } else {
                        System.out.println("Usuários cadastrados:");
                        todosUsuarios.forEach(u -> System.out.println(
                                "Código: " + u.getCodigoUsuario() +
                                        " | Nome: " + u.getNome() +
                                        " | Email: " + u.getEmail() +
                                        " | Telefone: " + u.getTelefone()));
                    }
                }

                case 4 -> {
                    System.out.print("Digite o código do livro a ser removido: ");
                    int codigo = scanner.nextInt();
                    boolean removido = controller.removerLivro(codigo);
                    System.out.println(removido ? "Livro removido com sucesso!" : "Livro não encontrado.");
                }

                case 5 -> controller.listarLivros().forEach(System.out::println);

                case 6 -> {
                    List<Emprestimo> emprestimosUsuario = controller.listarEmprestimosDoUsuario(usuarioAtual);
                    if (emprestimosUsuario.isEmpty()) {
                        System.out.println("Você não possui nenhum livro emprestado.");
                    } else {
                        System.out.println("Seus livros emprestados:");
                        emprestimosUsuario.forEach(e -> System.out.println(
                                e.getLivro().getTitulo() + " - devolução prevista: " + e.getDataDevolucao()));
                    }
                }

                case 7 -> {
                    System.out.print("Digite o título: ");
                    String titulo = scanner.nextLine();
                    Livro livro = controller.buscarLivroTitulo(titulo);
                    System.out.println(livro != null ? livro : "Livro não encontrado.");
                }

                case 8 -> {
                    System.out.print("Digite o código: ");
                    int codigo = scanner.nextInt();
                    Livro livro = controller.buscarLivroId(codigo);
                    System.out.println(livro != null ? livro : "Livro não encontrado.");
                }

                case 9 -> {
                    System.out.print("Digite o autor: ");
                    String autor = scanner.nextLine();
                    List<Livro> encontrados = controller.buscarLivrosAutor(autor);
                    if (encontrados.isEmpty()) {
                        System.out.println("Nenhum livro encontrado.");
                    } else {
                        encontrados.forEach(System.out::println);
                    }
                }

                case 10 -> {
                    System.out.print("Digite o código do livro para empréstimo: ");
                    int codigo = scanner.nextInt();
                    Livro livro = controller.buscarLivroId(codigo);
                    if (livro != null) {
                        String msg = controller.emprestarLivro(livro, usuarioAtual);
                        System.out.println(msg);
                    } else {
                        System.out.println("Livro não encontrado.");
                    }
                }

                case 11 -> {
                    System.out.print("Digite o código do livro a devolver: ");
                    int codigo = scanner.nextInt();
                    Livro livro = controller.buscarLivroId(codigo);
                    if (livro != null) {
                        System.out.println(controller.devolverLivro(livro, usuarioAtual));
                    } else {
                        System.out.println("Livro não encontrado.");
                    }
                }

                case 12 -> {
                    System.out.print("Digite o código do livro para verificar atraso: ");
                    int codigo = scanner.nextInt();
                    Emprestimo emprestimo = controller.getEmprestimos().stream()
                            .filter(e -> e.getLivro().getCodigoLivro() == codigo)
                            .findFirst()
                            .orElse(null);
                    if (emprestimo != null) {
                        System.out.println(controller.atrasoDevolucao(emprestimo));
                    } else {
                        System.out.println("Este livro não está emprestado.");
                    }
                }

                case 13 -> {
                    List<Emprestimo> atrasos = controller.getEmprestimos().stream()
                            .filter(Emprestimo::estaAtrasado)
                            .sorted()
                            .toList();
                    if (atrasos.isEmpty()) {
                        System.out.println("Nenhum empréstimo com atraso.");
                    } else {
                        System.out.println("Empréstimos em atraso:");
                        atrasos.forEach(e -> System.out.println(
                                e.getLivro().getTitulo() + " - " + e.getUsuario().getNome() +
                                        " - " + e.diasDeAtraso() + " dias de atraso"));
                    }
                }

                case 0 -> System.out.println("Encerrando o sistema...");
                default -> System.out.println("Opção inválida!");
            }

        } while (opcao != 0);

        scanner.close();
    }
}
