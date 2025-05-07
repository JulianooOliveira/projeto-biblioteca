package view;

import controller.BibliotecaController;
import java.util.ArrayList;
import model.Livro;

public class BibliotecaView {
    public static void main(String[] args) {
        BibliotecaController controller = new BibliotecaController(new ArrayList<>());

        Livro livro1 = new Livro("titulo", "Autor", 2013, 60);

        controller.addLivro(livro1);

        controller.listarLivros();
    }
}
