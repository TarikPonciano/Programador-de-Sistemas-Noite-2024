package com.veterinariaxyz;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        try {
            String url = "jdbc:mysql://localhost:3306/hospitalvet";
            String user = "root";
            String password = "Aluno";

            Connection conexaoBanco = DriverManager.getConnection(url, user,
                    password);
            System.out.println("Conexão criada com sucesso!");

            Statement statement = conexaoBanco.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM paciente");

            System.out.println("ID | Nome | Espécie | Raça | Data de Nascimento | Peso");

            while (resultSet.next()) {

                System.out.printf("%d | %s | %s | %s | %s | %.2f kg\n", resultSet.getInt("idpaciente"),
                        resultSet.getString(2),
                        resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getDouble(6));
            }

            PreparedStatement preparedStatement = conexaoBanco.prepareStatement("INSERT INTO paciente (nomepaciente, especiepaciente, racapaciente, nascimentopaciente,pesopaciente) VALUES (?, ?, ?, ?, ?)");

            preparedStatement.setString(1, "Polyana");
            preparedStatement.setString(2, "Gato");
            preparedStatement.setString(3, "Pé Duro");
            preparedStatement.setString(4, "2022-01-01");
            preparedStatement.setDouble(5, 2.5);

            preparedStatement.executeUpdate();

            resultSet.close();
            statement.close();
            conexaoBanco.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}