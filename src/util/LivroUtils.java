package util;

import model.Livro;
import java.util.ArrayList;
import java.util.List;

public class LivroUtils {

    private static int proximoCodigo = 1;

    public static List<Livro> gerarLivros() {
        List<Livro> livros = new ArrayList<>();

        livros.add(criarLivro("Código Limpo", "Robert Cecil Martin", 2008, 100));
        livros.add(criarLivro("Padrões de Projeto - Soluções Reutilizáveis de Software Orientado a Objetos", "Erich Gamma", 1994, 50));
        livros.add(criarLivro("Engenharia de Software", "Roger Pressman", 1982, 150));
        livros.add(criarLivro("A Segunda Era das Máquinas", "Andrew McAfee", 2014, 30));
        livros.add(criarLivro("TI Barata, Resultados Caros", "Jorge Sidney Cardoso Junior", 2023, 800));
        livros.add(criarLivro("Refatoração - Aperfeiçoando o Projeto de Código Existente", "Kent Beck e Martin Fowler", 1999, 50));
        livros.add(criarLivro("O Programador Pragmático: De Aprendiz a Mestre", "Andy Hunt", 1999, 60));
        livros.add(criarLivro("Data Science Para Negócios", "Tom Fawcett", 2013, 150));
        livros.add(criarLivro("Tecnologias da Informação na Gestão", "António Valente de Andrade", 2014, 80));
        livros.add(criarLivro("Algoritmos Para Viver", "Brian Christian", 2016, 260));

        return livros;
    }

    private static Livro criarLivro(String titulo, String autor, int anoPublicacao, int exemplaresDisponiveis) {
        return new Livro(proximoCodigo++, titulo, autor, anoPublicacao, exemplaresDisponiveis);
    }
}
