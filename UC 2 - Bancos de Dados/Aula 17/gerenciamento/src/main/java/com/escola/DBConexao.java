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

    public void desconectar() {

        try {
            if (this.con != null) {
                this.con.close();
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

    }
}
