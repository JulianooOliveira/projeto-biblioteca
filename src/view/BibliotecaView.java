package view;

import controller.BibliotecaController;
import model.Livro;
import model.Usuario;
import model.Emprestimo;
import util.LivroUtils;
import java.util.Scanner;
import java.util.ArrayList;

public class BibliotecaView {
    public static void main(String[] args) {
        BibliotecaController controller = new BibliotecaController(LivroUtils.gerarLivros(), new ArrayList<>());
        Scanner scanner = new Scanner(System.in);

        // Criando um usuário de exemplo
        Usuario usuario = new Usuario("João Silva", "Rua A, 123", "joao@email.com", "99999-9999");

        // Exibindo os livros disponíveis
        System.out.println("Livros disponíveis na biblioteca:");
        controller.listarLivros().forEach(System.out::println);

        System.out.println("\n");
        System.out.print("Digite o código do livro para empréstimo: ");
        int codigoLivro = scanner.nextInt();
        Livro livroEncontrado = controller.buscarLivroId(codigoLivro);
        if (livroEncontrado != null) {
            String mensagem = controller.emprestarLivro(livroEncontrado, usuario);
            System.out.println(mensagem);
        } else {
            System.out.println("Livro não encontrado.");
        }

        // Verificar se o livro está atrasado
        System.out.print("Digite o código do livro para verificar atraso: ");
        codigoLivro = scanner.nextInt();

        livroEncontrado = controller.buscarLivroId(codigoLivro);
        //if (livroEncontrado != null) {
         //   Livro emprestado = controller.getEmprestimos().stream().findFirst();

            //if (emprestimo != null) {
                //controller.atrasoDevolucao(emprestimo);
            //} else {
                //System.out.println("Este livro não está emprestado.");
            //}
        //} else {
            //System.out.println("Livro não encontrado.");
       // }

        scanner.close();
    }
}
