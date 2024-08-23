package com.biblioteca;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Conexao {
    private String host;
    private String user;
    private String password;

    private Connection con;
    private Statement st;
    private PreparedStatement pst;
    private ResultSet rs;
    
    public Conexao(String host, String user, String password){
        this.host = host;
        this.user = user;
        this.password = password;
    }

    public void conectar(){
        try {
            if( con == null || con.isClosed()){
                con = DriverManager.getConnection(host, user, password);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void desconectar(){
        try {
            if(rs != null && !rs.isClosed()){
                rs.close();
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        try {
            if(st != null && !st.isClosed()){
                st.close();
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        try {
            if(pst != null && !pst.isClosed()){
                pst.close();
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        try {
            if(con != null && !con.isClosed()){
                con.close();
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Livro> buscarLivros(){
        List<Livro> livros = new ArrayList<>();
        conectar();
        try {
            st = con.createStatement();
            rs = st.executeQuery("Select * from livro");

            while(rs.next()){
                Livro livro = new Livro();
                livro.setIdLivro(rs.getInt(1));
                livro.setNomeLivro(rs.getString(2));
                livro.setAutorLivro(rs.getString(3));
                livro.setEstoqueLivro(rs.getInt(4));

                livros.add(livro);
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        desconectar();
        return livros;
    }


    public List<Cliente> buscarclientes(){
        List<Cliente> clientes = new ArrayList<>();
        conectar();
        try {
            st = con.createStatement();
            rs = st.executeQuery("Select * from cliente");

            while(rs.next()){
                Cliente cliente = new Cliente();
                cliente.setIdCliente(rs.getInt(1));
                cliente.setNomeCliente(rs.getString(2));
                cliente.setCpfCliente(rs.getString(3));
                clientes.add(cliente);
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        desconectar();
        return clientes;
    }

    public List<Aluguel> buscarAlugueis(){
        List<Aluguel> alugueis = new ArrayList<>();
        conectar();
        try {
            st = con.createStatement();
            rs = st.executeQuery("Select * from aluguel");

            while(rs.next()){
                Aluguel aluguel = new Aluguel();

                aluguel.setIdAluguel(rs.getInt(1));
                aluguel.setIdCliente(rs.getInt(2));
                aluguel.setIdLivro(rs.getInt(3));
                aluguel.setDataAluguel(rs.getString(4));

                alugueis.add(aluguel);
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        desconectar();
        return alugueis;
    }

    public void inserirNovoLivro(Livro livro){
        conectar();
        try {
            pst = con.prepareStatement("INSERT INTO livro VALUES (DEFAULT, ?, ?, ?)");
            pst.setString(1, livro.getNomeLivro() );
            pst.setString(2, livro.getAutorLivro());
            pst.setInt(3, livro.getEstoqueLivro());

            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        desconectar();
    }

    public void inserirNovoCliente(Cliente cliente){
        conectar();
        try {
            pst = con.prepareStatement("INSERT INTO cliente VALUES (DEFAULT, ?, ?)");
            pst.setString(1, cliente.getNomeCliente() );
            pst.setString(2, cliente.getCpfCliente());

            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        desconectar();
    }

    public void inserirNovoAluguel(Aluguel aluguel){
        conectar();
        try {
            pst = con.prepareStatement("INSERT INTO aluguel VALUES (DEFAULT, ?, ?, CURDATE())");
            pst.setInt(1, aluguel.getIdCliente());
            pst.setInt(2, aluguel.getIdLivro());

            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        desconectar();
    }

    public Livro buscarLivroPorId(int id){
        Livro livro = new Livro();
        conectar();
        try {
            pst = con.prepareStatement("SELECT * FROM livro WHERE id_Livro = ?");
            pst.setInt(1, id);
            rs = pst.executeQuery();

            if (rs.next()){
                livro.setIdLivro(rs.getInt(1));
                livro.setNomeLivro(rs.getString(2));
                livro.setAutorLivro(rs.getString(3));
                livro.setEstoqueLivro(rs.getInt(4));
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        desconectar();
        return livro;
    }
}
