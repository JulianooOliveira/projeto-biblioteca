## Sistema de Gerenciamento de Biblioteca

O sistema deve possuir todas as seguintes funcionalidades. Utilizar MVC e todos os pilares
de orientação a objetos (Herança, Polimorfismo, Abstração e Encapsulamento), deve conter
pelo menos uma interface e tratamento de erro.

## Funcionalidades Requeridas

**Menu**: O menu deve ser completo e de fácil utilização otimizado para rodar via console.

**Cadastro de Livros**: O cadastro de livros deve possuir informações como título, autor,
ano de publicação, número de exemplares disponíveis, entre outros.

**Pesquisa de Livros**: O sistema deve ser capaz de buscar de livros por código, título, autor
ou categoria, facilitando a localização de um livro específico.

**Cadastro de Usuários**: O sistema deve possuir um cadastro de usuários, com
informações como nome, telefone, endereço, e-mail, entre outros.

**Empréstimo de Livros**: O sistema deve possibilitar o empréstimo de livros para usuários
cadastrados, desde que já não tenha outros livros emprestados, para isso é necessário
verificar a disponibilidade de exemplares registrar a data de empréstimo e a data de
devolução prevista.

**Devolução de Livros**: A devolução de livros deve atualizar a quantidade de exemplares
disponíveis, registrar a data de devolução efetiva e calcular automaticamente o número de
dias em que o livro permaneceu emprestado.

**Atrasos**: O sistema deve registrar todos os livros devolvidos com atraso, organizando-os
em ordem decrescente de tempo de atraso (do maior para o menor).

**Relatórios**: O sistema deve gerar relatórios com informações relevantes, como: livros
atualmente emprestados, usuários com devoluções em atraso, livros mais populares, entre
outros dados importantes.

**Pré-carga**: O sistema deve conter uma classe específica responsável por realizar uma
pré-carga de dados, inserindo automaticamente cadastros de livros, usuários, empréstimos
e devoluções, com o objetivo de facilitar os testes do sistema.
