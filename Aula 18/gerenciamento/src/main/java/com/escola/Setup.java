package com.escola;

import java.sql.*;

public class Setup {
    public static void main(String[] args) {
        // Criar bloco try e catch
        try {

            // Criar conexão com o banco. Dicas: Connection, Drivermanager.getConnection
            String url = "jdbc:mysql://localhost:3306/";
            String user = "root";
            String password = "Aluno";

            Connection conexaoBanco = DriverManager.getConnection(url, user, password);

            System.out.println("Conectado com sucesso!");

            // Criar o objeto statement

            Statement statement = conexaoBanco.createStatement();

            // Usar o objeto statement para criar o banco escola
            statement.execute("DROP DATABASE IF EXISTS escola");
            statement.execute("CREATE DATABASE escola");
            System.out.println("Banco criado com sucesso!");

            // Usar o objeto statement para criar a tabela aluno
            // Criar uma variável para guardar o sql (Use o chatgpt para preparar essa
            // String)
            // Usar essa variável no statement.execute()
            // Lembre-se de ou especificar o banco que está usando com o comando USE, ou
            // incluir no nome da sua tabela. Exemplo: escola.aluno
            statement.execute("USE escola");
            String createTableAluno = "CREATE TABLE aluno ("
                    + "matricula_aluno INT NOT NULL AUTO_INCREMENT PRIMARY KEY, "
                    + "nome_aluno VARCHAR(255) NOT NULL, "
                    + "cpf_aluno CHAR(11) NOT NULL UNIQUE, "
                    + "data_nascimento_aluno DATE NOT NULL, "
                    + "ano_matricula_aluno YEAR NOT NULL, "
                    + "media_aluno DECIMAL(3,1), "
                    + "faltas_aluno INT DEFAULT 0, "
                    + "CONSTRAINT check_tamanho_cpf CHECK (LENGTH(cpf_aluno) = 11), "
                    + "CONSTRAINT check_media CHECK (media_aluno >= 0 AND media_aluno <= 10)"
                    + ");";

            statement.execute(createTableAluno);

            System.out.println("Tabela criada com sucesso!");

            // Insira 20 alunos na tabela 'aluno'.

            String insertAlunos = "INSERT INTO aluno (nome_aluno, cpf_aluno, data_nascimento_aluno, ano_matricula_aluno, media_aluno, faltas_aluno) VALUES "
                    + "('João Silva', '12345678901', '2000-01-01', 2024, 8.5, 2), "
                    + "('Maria Oliveira', '23456789012', '1999-02-02', 2024, 7.3, 1), "
                    + "('Ana Santos', '34567890123', '2001-03-03', 2024, 9.0, 0), "
                    + "('Pedro Souza', '45678901234', '2000-04-04', 2024, 6.8, 3), "
                    + "('Lucas Lima', '56789012345', '1998-05-05', 2024, 7.5, 4), "
                    + "('Mariana Costa', '67890123456', '1999-06-06', 2024, 8.2, 1), "
                    + "('Bruna Alves', '78901234567', '2000-07-07', 2024, 6.9, 2), "
                    + "('Felipe Pereira', '89012345678', '1998-08-08', 2024, 8.1, 0), "
                    + "('Gabriela Cardoso', '90123456789', '2001-09-09', 2024, 7.4, 3), "
                    + "('Ricardo Fernandes', '01234567890', '1999-10-10', 2024, 9.2, 1), "
                    + "('Julia Rocha', '11223344556', '2000-11-11', 2024, 7.0, 2), "
                    + "('Renato Ribeiro', '22334455667', '1998-12-12', 2024, 6.5, 4), "
                    + "('Patricia Monteiro', '33445566778', '2001-01-13', 2024, 8.0, 1), "
                    + "('Carlos Mendes', '44556677889', '1999-02-14', 2024, 7.8, 0), "
                    + "('Daniela Nunes', '55667788990', '2000-03-15', 2024, 9.1, 2), "
                    + "('Leonardo Teixeira', '66778899001', '1998-04-16', 2024, 7.6, 3), "
                    + "('Beatriz Martins', '77889900112', '2001-05-17', 2024, 8.7, 1), "
                    + "('Gustavo Araujo', '88990011223', '1999-06-18', 2024, 6.7, 4), "
                    + "('Larissa Gomes', '99001122334', '2000-07-19', 2024, 7.9, 0), "
                    + "('Rafael Pinto', '10111223344', '1998-08-20', 2024, 8.4, 2);";

            statement.execute(insertAlunos);
            System.out.println("Alunos inseridos com sucesso.");

            // Fechar connection e fechar statement

            statement.close();
            conexaoBanco.close();

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

    }

}
