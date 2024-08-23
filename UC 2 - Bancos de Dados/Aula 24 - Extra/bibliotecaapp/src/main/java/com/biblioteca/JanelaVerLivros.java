package com.biblioteca;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class JanelaVerLivros extends JFrame {
    private Conexao con = null;

    public JanelaVerLivros(Component janela) {
        super();
        con = new Conexao("jdbc:mysql://localhost:3306/bibliotecaapp", "root", "Aluno");
        setTitle("Catalogo de Livros");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(janela);
        setLayout(new GridLayout(1, 1, 10, 10));
        setResizable(false);
        setSize(400, 400);

        String[] listaColunas = { "ID", "Nome", "Autor", "Gênero", "Editora" };

        // Criando o modelo da tabela
        DefaultTableModel modeloTabela = new DefaultTableModel(listaColunas, 0);

        // Criando a JTable com o modelo
        JTable tabelaLivros = new JTable(modeloTabela);

        java.util.List<Livro> livros = con.buscarLivros();

        for (Livro l : livros) {
            String[] infoLivro = { Integer.toString(l.getIdLivro()), l.getNomeLivro(), l.getAutorLivro(),
                    l.getGeneroLivro(), l.getEditoraLivro() };

            modeloTabela.addRow(infoLivro);
        }

        JScrollPane scrollLivros = new JScrollPane(tabelaLivros);

        add(scrollLivros);
        setVisible(true);

    }

}
