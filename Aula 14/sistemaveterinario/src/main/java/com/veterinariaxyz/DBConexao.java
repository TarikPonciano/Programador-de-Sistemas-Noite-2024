package com.veterinariaxyz;

import java.sql.*;
import java.util.Scanner;


public class DBConexao {
    private String url;
    private String user;
    private String password;

    private Connection con = null;
    private Statement st = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;

    public DBConexao(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    public void conectarBanco() {
        if (con == null) {
            try {
                con = DriverManager.getConnection(this.url, this.user, this.password);
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        } else {
            System.out.println("Conexão já existe");
        }
    }

    public void desconectar() {
        if (con != null) {
            try {
                con.close();
                con = null;
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

        if (st != null) {
            try {
                st.close();
                st = null;
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

        if (pst != null) {
            try {
                pst.close();
                pst = null;
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

        if (rs != null) {
            try {
                rs.close();
                rs = null;
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void verTabelaPaciente(){
        conectarBanco();

        try {
            st = con.createStatement();
            rs = st.executeQuery("Select * FROM paciente");
            while (rs.next()) {
            
            System.out.println(rs.getInt(1)+". "+rs.getString(2));
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        desconectar();

    }

    public void inserirPaciente(){
        

        Scanner leitor = new Scanner(System.in);

        System.out.println("Nome: ");
        String nome = leitor.nextLine();

        System.out.println("Espécie: ");
        String especie = leitor.nextLine();

        System.out.println("Raça: ");
        String raca = leitor.nextLine();

        System.out.println("Data de Nascimento (yy-mm-dd): ");
        String dataDeNascimento = leitor.nextLine();

        System.out.println("Peso: ");
        Double peso = Double.parseDouble(leitor.nextLine());

        conectarBanco();

        try {
            pst = con.prepareStatement("INSERT INTO paciente VALUES (default, ?, ?, ?, ?, ?)");
            pst.setString(1, nome);
            pst.setString(2, especie);
            pst.setString(3, raca);
            pst.setString(4, dataDeNascimento);
            pst.setDouble(5, peso);

            pst.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        desconectar();
        

    }

    public static void main(String[] args) {
        DBConexao conexaoBanco = new DBConexao("jdbc:mysql://localhost:3306/hospitalvet2", "root", "Aluno");
        conexaoBanco.verTabelaPaciente();
        conexaoBanco.inserirPaciente();
        conexaoBanco.verTabelaPaciente();
    }


}
