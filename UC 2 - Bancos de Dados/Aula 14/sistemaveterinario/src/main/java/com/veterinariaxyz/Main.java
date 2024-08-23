package com.veterinariaxyz;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        try {
            String url = "jdbc:mysql://localhost:3306/hospitalvet2";
            String user = "root";
            String pass = "Aluno";

            Connection conexaoBanco = DriverManager.getConnection(url, user, pass);

            PreparedStatement preparedStatement = conexaoBanco.prepareStatement("INSERT INTO paciente VALUES(default, ?, ?, ?, ?, ?)");
            preparedStatement.setString(1, "Rex");
            preparedStatement.setString(2, "Cachorro");
            preparedStatement.setString(3, "Pastor Alemão");
            preparedStatement.setString(4, "2020-06-04");
            preparedStatement.setDouble(5, 15);

            preparedStatement.executeUpdate();

            System.out.println("Paciente inserido com sucesso!");
            preparedStatement.close();
            conexaoBanco.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
