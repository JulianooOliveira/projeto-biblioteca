package view;

import controller.BibliotecaController;
import model.Livro;
import util.LivroUtils;

public class BibliotecaView {
    public static void main(String[] args) {
        BibliotecaController controller = new BibliotecaController(LivroUtils.gerarLivros());

        controller.listarLivros().forEach(System.out::println);
        // System.out.println("Livro encontrado: ");
        // Livro livroEncontrado = controller.buscarLivro(9);
        // System.out.println(livroEncontrado);

    }
}
