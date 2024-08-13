package com.biblioteca;

public class Aluguel {
    private int idAluguel;
    private int idCliente;
    private int idLivro;
    private String dataAluguel;

    // Construtor padrão
    public Aluguel() {
    }

    // Construtor com parâmetros
    public Aluguel(int idAluguel, int idCliente, int idLivro, String dataAluguel) {
        this.idAluguel = idAluguel;
        this.idCliente = idCliente;
        this.idLivro = idLivro;
        this.dataAluguel = dataAluguel;
    }

    // Getters e Setters
    public int getIdAluguel() {
        return idAluguel;
    }

    public void setIdAluguel(int idAluguel) {
        this.idAluguel = idAluguel;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(int idLivro) {
        this.idLivro = idLivro;
    }

    public String getDataAluguel() {
        return dataAluguel;
    }

    public void setDataAluguel(String dataAluguel) {
        this.dataAluguel = dataAluguel;
    }

    // Método toString
    @Override
    public String toString() {
        return "Aluguel{" +
                "idAluguel=" + idAluguel +
                ", idCliente=" + idCliente +
                ", idLivro=" + idLivro +
                ", dataAluguel=" + dataAluguel +
                '}';
    }
}
