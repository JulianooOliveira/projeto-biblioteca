package util;

import model.Livro;
import java.util.ArrayList;
import java.util.List;

public class LivroUtils {
    public static List<Livro> gerarLivros() {
        int proximoCodigo = 1;
        List<Livro> livros = new ArrayList<>();

        livros.add(new Livro(proximoCodigo++, "Código Limpo", "Robert Cecil Martin", 2008, 100));
        livros.add(new Livro(proximoCodigo++, "Padrões de Projeto - Soluções Reutilizáveis de Software Orientado a Objetos", "Erich Gamma", 1994, 50));
        livros.add(new Livro(proximoCodigo++, "Engenharia de Software", "Roger Pressman", 1982, 150));
        livros.add(new Livro(proximoCodigo++, "A Segunda Era das Máquinas", "Andrew McAfee", 2014, 30));
        livros.add(new Livro(proximoCodigo++, "TI Barata, Resultados Caros", "Jorge Sidney Cardoso Junior", 2023, 800));
        livros.add(new Livro(proximoCodigo++, "Refatoração - Aperfeiçoando o Projeto de Código Existente", "Kent Beck e Martin Fowler", 1999, 50));
        livros.add(new Livro(proximoCodigo++, "O Programador Pragmático: De Aprendiz a Mestre", "Andy Hunt", 1999, 60));
        livros.add(new Livro(proximoCodigo++, "Data Science Para Negócios", "Tom Fawcett", 2013, 150));
        livros.add(new Livro(proximoCodigo++, "Tecnologias da Informação na Gestão", "António Valente de Andrade", 2014, 80));
        livros.add(new Livro(proximoCodigo++, "Algoritmos Para Viver", "Brian Christian", 2016, 260));

        return livros;
    }
}
