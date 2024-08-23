package bibliotecaApp;

public class Livro {
    private int idLivro;
    private String nomeLivro;
    private String autorLivro;
    private String generoLivro;
    private String editoraLivro;

    // Construtor padrão
    public Livro() {
    }

    // Construtor com parâmetros
    public Livro(int idLivro, String nomeLivro, String autorLivro, String generoLivro, String editoraLivro) {
        this.idLivro = idLivro;
        this.nomeLivro = nomeLivro;
        this.autorLivro = autorLivro;
        this.generoLivro = generoLivro;
        this.editoraLivro = editoraLivro;
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

    public String getEditoraLivro() {
        return editoraLivro;
    }

    public void setEditoraLivro(String editoraLivro) {
        this.editoraLivro = editoraLivro;
    }

    public String getGeneroLivro() {
        return generoLivro;
    }

    public void setGeneroLivro(String generoLivro) {
        this.generoLivro = generoLivro;
    }

    public String getAutorLivro() {
        return autorLivro;
    }

    public void setAutorLivro(String autorLivro) {
        this.autorLivro = autorLivro;
    }


    // Método toString
    @Override
    public String toString() {
        return "Livro{" +
                "idLivro=" + idLivro +
                ", nomeLivro='" + nomeLivro + '\'' +
                ", autorLivro='" + autorLivro + '\'' +
                ", generoLivro=" + generoLivro +
                ", editoraLivro=" + editoraLivro +
                '}';
    }
}
