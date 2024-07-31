package com.escola;

import java.sql.*;
import java.util.Scanner;

public class Versao1 {
    public static void main(String[] args) {
        try {
            String url = "jdbc:mysql://localhost:3306/escola";
            String user = "root";
            String password = "Aluno";

            Connection con = DriverManager.getConnection(url, user, password);

            Scanner leitor = new Scanner(System.in);

            System.out.println("Digite o nome: ");
            String nome = leitor.nextLine();

            System.out.println("Digite o cpf:");
            String cpf = leitor.nextLine();

            System.out.println("Digite a data de nascimento:");
            String dataNascimento = leitor.nextLine();

            System.out.println("Digite a média do aluno:");
            double media = Double.parseDouble(leitor.nextLine());

            System.out.println("Digite as faltas do aluno:");
            int faltas = Integer.parseInt(leitor.nextLine());

            PreparedStatement pst = con
                    .prepareStatement("INSERT INTO aluno VALUES (DEFAULT, ?, ?, ?, YEAR(CURDATE()), ?, ?)");

            pst.setString(1, nome);
            pst.setString(2, cpf);
            pst.setString(3, dataNascimento);
            pst.setDouble(4, media);
            pst.setInt(5, faltas);
            
            pst.executeUpdate();

            Statement st = con.createStatement();

            // Escrever e executar o SQL de consulta
            ResultSet rs = st.executeQuery("SELECT * FROM aluno ORDER BY media_aluno DESC");

            // Percorrer o ResultSet e imprimir as informações dos alunos
            System.out.println("Lista de alunos: ");

            while (rs.next()) {

                String situacao = "";

                if (rs.getDouble("media_aluno") >= 7) {
                    situacao = "Aprovado";
                } else {
                    situacao = "Reprovado";
                }

                System.out.println(rs.getInt("matricula_aluno") + ". " + rs.getString("nome_aluno") + " - "
                        + rs.getDouble("media_aluno") + " > " + situacao);

            }

            rs.close();
            st.close();
            con.close();

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}