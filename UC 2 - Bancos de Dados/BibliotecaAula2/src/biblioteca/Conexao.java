package biblioteca;

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
                livro.setGeneroLivro(rs.getString(4));
                livro.setEditoraLivro(rs.getString(5));
                livros.add(livro);
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        desconectar();
        return livros;
    }


    public void inserirNovoLivro(Livro livro){
        conectar();
        try {
            pst = con.prepareStatement("INSERT INTO livro VALUES (DEFAULT, ?, ?, ?, ?)");
            pst.setString(1, livro.getNomeLivro() );
            pst.setString(2, livro.getAutorLivro());
            pst.setString(3, livro.getGeneroLivro());
            pst.setString(4, livro.getEditoraLivro());

            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        desconectar();
    }


    public Livro buscarLivroPorId(int id){
        Livro livro = null;
        conectar();
        try {
            pst = con.prepareStatement("SELECT * FROM livro WHERE id_Livro = ?");
            pst.setInt(1, id);
            rs = pst.executeQuery();

            if (rs.next()){
                livro = new Livro();
                livro.setIdLivro(rs.getInt(1));
                livro.setNomeLivro(rs.getString(2));
                livro.setAutorLivro(rs.getString(3));
                livro.setGeneroLivro(rs.getString(4));
                livro.setEditoraLivro(rs.getString(5));
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        desconectar();
        return livro;
    }
}
