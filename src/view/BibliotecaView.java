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

        BibliotecaController controller = new BibliotecaController(livros, emprestimos);
        Scanner scanner = new Scanner(System.in);

        Usuario usuarioAtual = usuarios.get(0); // Simula login com o primeiro usuário da lista

        int opcao;
        do {
            System.out.println("\n=== SISTEMA BIBLIOTECA ===");
            System.out.println("Usuário logado: " + usuarioAtual.getNome());
            System.out.println("1. Cadastrar novo livro");
            System.out.println("2. Cadastrar novo usuário");
            System.out.println("3. Deletar livro");
            System.out.println("4. Listar livros");
            System.out.println("5. Buscar livro por título");
            System.out.println("6. Buscar livro por código");
            System.out.println("7. Buscar livros por autor");
            System.out.println("8. Emprestar livro");
            System.out.println("9. Devolver livro");
            System.out.println("10. Verificar atraso");
            System.out.println("11. Listar empréstimos atrasados");
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
                    scanner.nextLine(); // consumir quebra de linha

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

                    Usuario novoUsuario = new Usuario(nome, endereco, email, telefone);
                    usuarios.add(novoUsuario);
                    System.out.println("Usuário cadastrado com sucesso!");
                }

                case 3 -> {
                    System.out.print("Digite o código do livro a ser removido: ");
                    int codigo = scanner.nextInt();
                    boolean removido = controller.removerLivro(codigo);
                    System.out.println(removido ? "Livro removido com sucesso!" : "Livro não encontrado.");
                }

                case 4 -> controller.listarLivros().forEach(System.out::println);

                case 5 -> {
                    System.out.print("Digite o título: ");
                    String titulo = scanner.nextLine();
                    Livro livro = controller.buscarLivroTitulo(titulo);
                    System.out.println(livro != null ? livro : "Livro não encontrado.");
                }

                case 6 -> {
                    System.out.print("Digite o código: ");
                    int codigo = scanner.nextInt();
                    Livro livro = controller.buscarLivroId(codigo);
                    System.out.println(livro != null ? livro : "Livro não encontrado.");
                }

                case 7 -> {
                    System.out.print("Digite o autor: ");
                    String autor = scanner.nextLine();
                    List<Livro> encontrados = controller.buscarLivrosAutor(autor);
                    if (encontrados.isEmpty()) {
                        System.out.println("Nenhum livro encontrado.");
                    } else {
                        encontrados.forEach(System.out::println);
                    }
                }

                case 8 -> {
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

                case 9 -> {
                    System.out.print("Digite o código do livro a devolver: ");
                    int codigo = scanner.nextInt();
                    Livro livro = controller.buscarLivroId(codigo);
                    if (livro != null) {
                        System.out.println(controller.devolverLivro(livro));
                    } else {
                        System.out.println("Livro não encontrado.");
                    }
                }

                case 10 -> {
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

                case 11 -> {
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
