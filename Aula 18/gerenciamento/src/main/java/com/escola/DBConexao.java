package com.escola;

import java.sql.*;

public class DBConexao {
    private String url;
    private String user;
    private String password;

    public Connection con = null;
    public Statement st = null;
    public PreparedStatement pst = null;
    public ResultSet rs = null;

    // Peça as informações url, user, password e guarde no objeto (this)
    public DBConexao(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    public void conectar() {

        try {
            if (this.con == null || this.con.isClosed()) {
                this.con = DriverManager.getConnection(this.url, this.user, this.password);
                System.out.println("Conexão criada com sucesso!");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public ResultSet consultarTabela(String sql) {
        rs = null;

        try {
            if (this.st == null || this.st.isClosed()) {
                this.st = this.con.createStatement();
                System.out.println("Statement criado!");
            }
            rs = this.st.executeQuery(sql);

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return rs;
    }

    public void verAlunos() {
        this.conectar();

        this.consultarTabela("SELECT * FROM aluno");

        System.out.println("Matricula | Nome | CPF | Data de Nascimento | Ano de Matricula | Média | Faltas");
        try {
            while (rs.next()) {
                System.out.printf("%d | %s | %s | %s | %d | %.1f | %d\n", rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getString(4), rs.getInt(5), rs.getDouble(6), rs.getInt(7));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        this.desconectar();

    }

    public void verAluno(int matricula) {
        this.conectar();
        this.consultarTabela("SELECT * FROM Aluno WHERE matricula_aluno = " + matricula);

        try {
            if (rs.next()) {
                System.out.println("Nome: " + rs.getString(2));
                System.out.println("Média: " + rs.getDouble(6));
                String situacao = "Reprovado";
                if (rs.getDouble(6) >= 7) {
                    situacao = "Aprovado";
                }
                System.out.println("Situação: " + situacao);
            } else{
                System.out.println("Aluno não identificado!");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public void desconectar() {

        try {
            if (this.con != null) {
                this.con.close();
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        try {
            if (this.st != null) {
                this.st.close();
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        try {
            if (this.rs != null) {
                this.rs.close();
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        try {
            if (this.pst != null) {
                this.pst.close();
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

    }
}
