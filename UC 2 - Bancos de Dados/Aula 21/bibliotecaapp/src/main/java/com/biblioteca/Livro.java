package com.biblioteca;

public class Livro {
    private int idLivro;
    private String nomeLivro;
    private String autorLivro;
    private int estoqueLivro;

    // Construtor padrão
    public Livro() {
    }

    // Construtor com parâmetros
    public Livro(int idLivro, String nomeLivro, String autorLivro, int estoqueLivro) {
        this.idLivro = idLivro;
        this.nomeLivro = nomeLivro;
        this.autorLivro = autorLivro;
        this.estoqueLivro = estoqueLivro;
    }

    // Getters e Setters
    public int getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(int idLivro) {
        this.idLivro = idLivro;
    }

    public String getNomeLivro() {
        return nomeLivro;
    }

    public void setNomeLivro(String nomeLivro) {
        this.nomeLivro = nomeLivro;
    }

    public String getAutorLivro() {
        return autorLivro;
    }

    public void setAutorLivro(String autorLivro) {
        this.autorLivro = autorLivro;
    }

    public int getEstoqueLivro() {
        return estoqueLivro;
    }

    public void setEstoqueLivro(int estoqueLivro) {
        this.estoqueLivro = estoqueLivro;
    }

    // Método toString
    @Override
    public String toString() {
        return "Livro{" +
                "idLivro=" + idLivro +
                ", nomeLivro='" + nomeLivro + '\'' +
                ", autorLivro='" + autorLivro + '\'' +
                ", estoqueLivro=" + estoqueLivro +
                '}';
    }
}

