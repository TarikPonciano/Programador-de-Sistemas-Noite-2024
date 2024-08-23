package biblioteca;

import java.sql.*;

public class Setup {
    public static void main(String[] args) {
        String host = "jdbc:mysql://localhost:3306";
        String user = "root";
        String password = "Aluno";

        Connection con = null;
        Statement st = null;

        try {
            con = DriverManager.getConnection(host, user, password);

            st = con.createStatement();

            st.execute("DROP DATABASE IF EXISTS bibliotecaapp");
            st.execute("CREATE DATABASE bibliotecaapp");
            st.execute("USE bibliotecaapp");

            System.out.println("Banco criado com sucesso!");

            // Criar tabela livro, cliente, aluguel

            // Tabela livro:
            st.execute(
                    "CREATE TABLE livro (id_livro INT NOT NULL AUTO_INCREMENT PRIMARY KEY, nome_livro VARCHAR(255) NOT NULL, autor_livro VARCHAR(255) NOT NULL DEFAULT 'Desconhecido', genero_livro VARCHAR(255) NOT NULL, editora_livro VARCHAR(255) NOT NULL);");

            // Criar 20 livros
            String sqlInsertLivros = "INSERT INTO livro (nome_livro, autor_livro, genero_livro, editora_livro) VALUES "
                    +
                    "('O Senhor dos Anéis', 'J.R.R. Tolkien', 'Fantasia', 'HarperCollins'), " +
                    "('1984', 'George Orwell', 'Distopia', 'Companhia das Letras'), " +
                    "('Dom Casmurro', 'Machado de Assis', 'Romance', 'Ática'), " +
                    "('A Revolução dos Bichos', 'George Orwell', 'Satira', 'Companhia das Letras'), " +
                    "('A Arte da Guerra', 'Sun Tzu', 'Estratégia', 'Martins Fontes'), " +
                    "('O Alquimista', 'Paulo Coelho', 'Ficção', 'Rocco'), " +
                    "('O Pequeno Príncipe', 'Antoine de Saint-Exupéry', 'Infantil', 'HarperCollins'), " +
                    "('Harry Potter e a Pedra Filosofal', 'J.K. Rowling', 'Fantasia', 'Rocco'), " +
                    "('Moby Dick', 'Herman Melville', 'Aventura', 'Penguin'), " +
                    "('Os Miseráveis', 'Victor Hugo', 'Drama', 'Martin Claret'), " +
                    "('Crime e Castigo', 'Fiódor Dostoiévski', 'Romance', 'Companhia das Letras'), " +
                    "('O Hobbit', 'J.R.R. Tolkien', 'Fantasia', 'HarperCollins'), " +
                    "('Cem Anos de Solidão', 'Gabriel García Márquez', 'Realismo Mágico', 'Record'), " +
                    "('A Odisséia', 'Homero', 'Épico', 'Penguin'), " +
                    "('O Morro dos Ventos Uivantes', 'Emily Brontë', 'Romance', 'Penguin'), " +
                    "('Hamlet', 'William Shakespeare', 'Tragédia', 'Companhia das Letras'), " +
                    "('Orgulho e Preconceito', 'Jane Austen', 'Romance', 'Penguin'), " +
                    "('O Nome da Rosa', 'Umberto Eco', 'Mistério', 'Record'), " +
                    "('O Código Da Vinci', 'Dan Brown', 'Thriller', 'Sextante'), " +
                    "('O Lobo da Estepe', 'Hermann Hesse', 'Filosofia', 'Record');";
            st.execute(sqlInsertLivros);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        try {
            if ((st != null) && (!st.isClosed())) {
                st.close();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        try {
            if ((con != null) && (!con.isClosed())) {
                con.close();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}