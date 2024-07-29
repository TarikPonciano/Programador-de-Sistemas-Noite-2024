package com.veterinariaxyz;

import java.sql.*;

public class Setup {
    public static void main(String[] args) {
        try {
            String url = "jdbc:mysql://localhost:3306/";
            String user = "root";
            String password = "Aluno";

            Connection conexaoBanco = DriverManager.getConnection(url, user, password);

            System.out.println("Conexão realizada com sucesso!");

            Statement statement = conexaoBanco.createStatement();
            statement.execute("DROP DATABASE IF EXISTS hospitalvet2");
            statement.execute("CREATE DATABASE hospitalvet2");
            System.out.println("Banco criado com sucesso!");

            statement.execute("USE hospitalvet2");

            String sqlTabelaPaciente = "CREATE TABLE paciente(" +
                    "idpaciente INT NOT NULL AUTO_INCREMENT PRIMARY KEY," +
                    "nomepaciente VARCHAR(255) NOT NULL," +
                    "especiepaciente VARCHAR(255) NOT NULL DEFAULT 'Espécie não identificada', " +
                    "racapaciente VARCHAR(255) NOT NULL DEFAULT 'Raça não identificada'," +
                    "nascimentopaciente DATE," +
                    "pesopaciente DECIMAL(5,2) DEFAULT 0.00" +
                    ")";
            statement.execute("DROP TABLE IF EXISTS paciente;");
            statement.execute(sqlTabelaPaciente);

            statement.close();
            conexaoBanco.close();

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

    }
}