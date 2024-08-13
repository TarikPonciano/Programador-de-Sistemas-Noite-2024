package com.biblioteca;

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
                    "CREATE TABLE livro (id_livro INT NOT NULL AUTO_INCREMENT PRIMARY KEY, nome_livro VARCHAR(255) NOT NULL, autor_livro VARCHAR(255) NOT NULL DEFAULT 'Desconhecido', estoque_livro INT NOT NULL DEFAULT 0);");

            // Tabela cliente
            st.execute(
                    "CREATE TABLE cliente (id_cliente INT NOT NULL AUTO_INCREMENT PRIMARY KEY, nome_cliente VARCHAR(255) NOT NULL, cpf_cliente CHAR(11) NOT NULL UNIQUE);");

            // Tabela aluguel
            st.execute(
                    "CREATE TABLE aluguel(id_aluguel INT NOT NULL AUTO_INCREMENT PRIMARY KEY, id_cliente INT NOT NULL, id_livro INT NOT NULL, data_aluguel DATE);");

            st.execute(
                    "ALTER TABLE aluguel ADD CONSTRAINT fk_cliente FOREIGN KEY(id_cliente) REFERENCES cliente(id_cliente);");
            st.execute("ALTER TABLE aluguel ADD CONSTRAINT fk_livro FOREIGN KEY(id_livro) REFERENCES livro(id_livro);");

            // Criar 10 clientes
            String sqlInsertClientes = "INSERT INTO cliente (nome_cliente, cpf_cliente) VALUES " +
                    "('Ana Silva', '12345678901'), " +
                    "('Bruno Souza', '23456789012'), " +
                    "('Carla Pereira', '34567890123'), " +
                    "('Daniel Oliveira', '45678901234'), " +
                    "('Eduardo Lima', '56789012345'), " +
                    "('Fernanda Costa', '67890123456'), " +
                    "('Gabriel Martins', '78901234567'), " +
                    "('Helena Rocha', '89012345678'), " +
                    "('Igor Ferreira', '90123456789'), " +
                    "('Juliana Alves', '01234567890');";

            st.execute(sqlInsertClientes);

            // Criar 20 livros
            String sqlInsertLivros = "INSERT INTO livro (nome_livro, autor_livro, estoque_livro) VALUES " +
                    "('Dom Casmurro', 'Machado de Assis', 5), " +
                    "('O Cortiço', 'Aluísio Azevedo', 3), " +
                    "('Grande Sertão: Veredas', 'Guimarães Rosa', 4), " +
                    "('Memórias Póstumas de Brás Cubas', 'Machado de Assis', 6), " +
                    "('Iracema', 'José de Alencar', 2), " +
                    "('Capitães da Areia', 'Jorge Amado', 7), " +
                    "('Vidas Secas', 'Graciliano Ramos', 5), " +
                    "('A Moreninha', 'Joaquim Manuel de Macedo', 3), " +
                    "('A Hora da Estrela', 'Clarice Lispector', 4), " +
                    "('Macunaíma', 'Mário de Andrade', 6), " +
                    "('O Guarani', 'José de Alencar', 5), " +
                    "('A Escrava Isaura', 'Bernardo Guimarães', 4), " +
                    "('O Primo Basílio', 'Eça de Queirós', 3), " +
                    "('Os Maias', 'Eça de Queirós', 7), " +
                    "('O Mulato', 'Aluísio Azevedo', 2), " +
                    "('Senhora', 'José de Alencar', 5), " +
                    "('Sagarana', 'Guimarães Rosa', 6), " +
                    "('A Casa das Sete Mulheres', 'Letícia Wierzchowski', 4), " +
                    "('O Alienista', 'Machado de Assis', 3), " +
                    "('Ensaio Sobre a Cegueira', 'José Saramago', 5);";
            st.execute(sqlInsertLivros);
            // Criar 30 registros de aluguel

            String sqlInsertAlugueis = "INSERT INTO aluguel (id_cliente, id_livro, data_aluguel) VALUES " +
                    "(1, 1, '2024-01-15'), " +
                    "(2, 2, '2024-01-16'), " +
                    "(3, 3, '2024-01-17'), " +
                    "(4, 4, '2024-01-18'), " +
                    "(5, 5, '2024-01-19'), " +
                    "(6, 6, '2024-01-20'), " +
                    "(7, 7, '2024-01-21'), " +
                    "(8, 8, '2024-01-22'), " +
                    "(9, 9, '2024-01-23'), " +
                    "(10, 10, '2024-01-24'), " +
                    "(1, 11, '2024-01-25'), " +
                    "(2, 12, '2024-01-26'), " +
                    "(3, 13, '2024-01-27'), " +
                    "(4, 14, '2024-01-28'), " +
                    "(5, 15, '2024-01-29'), " +
                    "(6, 16, '2024-01-30'), " +
                    "(7, 17, '2024-01-31'), " +
                    "(8, 18, '2024-02-01'), " +
                    "(9, 19, '2024-02-02'), " +
                    "(10, 20, '2024-02-03'), " +
                    "(1, 1, '2024-02-04'), " +
                    "(2, 2, '2024-02-05'), " +
                    "(3, 3, '2024-02-06'), " +
                    "(4, 4, '2024-02-07'), " +
                    "(5, 5, '2024-02-08'), " +
                    "(6, 6, '2024-02-09'), " +
                    "(7, 7, '2024-02-10'), " +
                    "(8, 8, '2024-02-11'), " +
                    "(9, 9, '2024-02-12'), " +
                    "(10, 10, '2024-02-13');";
            st.execute(sqlInsertAlugueis);
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