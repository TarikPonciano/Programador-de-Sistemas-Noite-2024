package com.biblioteca;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;

public class Main {
    static Conexao con = new Conexao("jdbc:mysql://localhost:3306/bibliotecaapp", "root", "Aluno");
    static JFrame janela;
    static JFrame janelaVerLivros;

    public static void main(String[] args) {
        Font fontBotao = new Font("Vivaldi", Font.BOLD, 16);
        JFrame janela = new JFrame("Minha primeira janela");
        janela.setSize(400, 300);

        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setLocationRelativeTo(null);
        janela.setLayout(new GridLayout(5, 2, 10, 10));
        janela.setResizable(true);

        RotuloVerde rotuloNome = new RotuloVerde("Nome: ");

        // rotuloNome.setHorizontalTextPosition(SwingConstants.CENTER);
        JTextField campoNome = new JTextField(20);
        campoNome.setFont(new Font("Arial", Font.BOLD, 24));
        campoNome.setForeground(Color.GREEN);
        campoNome.setBackground(Color.BLACK);
        campoNome.setPreferredSize(new Dimension(200, 20));

        RotuloVerde rotuloAutor = new RotuloVerde("Autor: ");

        JTextField campoAutor = new JTextField(20);
        campoAutor.setFont(new Font("Arial", Font.BOLD, 24));
        campoAutor.setForeground(Color.GREEN);
        campoAutor.setBackground(Color.BLACK);

        JLabel rotuloGenero = new JLabel("Gênero:");
        rotuloGenero.setFont(new Font("Arial", Font.BOLD, 24));
        rotuloGenero.setHorizontalAlignment(SwingConstants.CENTER);
        rotuloGenero.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        rotuloGenero.setForeground(Color.GREEN);
        rotuloGenero.setBackground(Color.BLACK);
        rotuloGenero.setOpaque(true);

        // JTextField campoGenero = new JTextField(20);
        // campoGenero.setFont(new Font("Arial", Font.BOLD, 24));
        // campoGenero.setForeground(Color.GREEN);
        // campoGenero.setBackground(Color.BLACK);

        String[] generos = { "", "Aventura", "Drama", "Policial", "Ficção", "Ficção Científica", "Fantasia" };

        JComboBox<String> comboGenero = new JComboBox<>(generos);

        JLabel rotuloEditora = new JLabel("Editora:");
        rotuloEditora.setFont(new Font("Arial", Font.BOLD, 24));
        rotuloEditora.setHorizontalAlignment(SwingConstants.CENTER);
        rotuloEditora.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        rotuloEditora.setForeground(Color.GREEN);
        rotuloEditora.setBackground(Color.BLACK);

        rotuloEditora.setOpaque(true);

        // JTextField campoEditora = new JTextField(20);
        // campoEditora.setFont(new Font("Arial", Font.BOLD, 24));
        // campoEditora.setForeground(Color.GREEN);
        // campoEditora.setBackground(Color.BLACK);

        JRadioButton radioEditora1 = new JRadioButton("Abril");
        JRadioButton radioEditora2 = new JRadioButton("Erika");
        JRadioButton radioEditora3 = new JRadioButton("Record");
        JRadioButton radioEditora4 = new JRadioButton("Rocco");
        JRadioButton radioEditora5 = new JRadioButton("Senac");

        ButtonGroup grupoEditoras = new ButtonGroup();
        grupoEditoras.add(radioEditora1);
        grupoEditoras.add(radioEditora2);
        grupoEditoras.add(radioEditora3);
        grupoEditoras.add(radioEditora4);
        grupoEditoras.add(radioEditora5);

        grupoEditoras.getSelection();

        JPanel painelEditoras = new JPanel(new GridLayout(3, 2, 2, 2));
        painelEditoras.add(radioEditora1);
        painelEditoras.add(radioEditora2);
        painelEditoras.add(radioEditora3);
        painelEditoras.add(radioEditora4);
        painelEditoras.add(radioEditora5);
        

        JButton botaoEnviar = new JButton("Enviar");
        botaoEnviar.setFont(fontBotao);
        botaoEnviar.addActionListener(e -> {
            // Capturar as informações dos campos de digitação e imprimir no formato
            // Nome: <>
            // Autor: <>
            // Gênero: <>
            // Editora: <>

            String nome = campoNome.getText();
            String autor = campoAutor.getText();
            String genero = (String) comboGenero.getSelectedItem();

            String editora = "";
            if (radioEditora1.isSelected()) {
                editora = radioEditora1.getText();
            } else if (radioEditora2.isSelected()) {
                editora = radioEditora2.getText();
            } else if (radioEditora3.isSelected()) {
                editora = radioEditora3.getText();
            } else if (radioEditora4.isSelected()) {
                editora = radioEditora4.getText();
            } else if (radioEditora5.isSelected()) {
                editora = radioEditora5.getText();
            } else {
                editora = "Não Identificado";
            }

            String mensagem = "Nome: " + nome +
                    "\nAutor: " + autor +
                    "\nGênero: " + genero +
                    "\nEditora: " + editora +
                    "\n\nDeseja Enviar este Livro para o banco?";

            int resposta = JOptionPane.showConfirmDialog(janela, mensagem, "Confirmar", JOptionPane.YES_NO_OPTION);

            if (resposta == 0) {
                campoNome.setText("");
                campoAutor.setText("");
                comboGenero.setSelectedIndex(0);
                grupoEditoras.clearSelection();

                // Criar o objeto conexão no início do código como static
                // Montar um objeto Livro usando as informações coletadas
                Livro novoLivro = new Livro(0, nome, autor, genero, editora);
                // Enviar esse objeto Livro para o objeto Conexão
                con.inserirNovoLivro(novoLivro);

                JOptionPane.showMessageDialog(janela, "Livro Cadastrado com Sucesso!");
            } else {
                JOptionPane.showMessageDialog(janela, "Operação Cancelada!");
            }

        });

        // Criar um novo botão, ao lado de Enviar, chamado "Ver Livros", ao clicar neste
        // botão deve-se abrir uma nova janela com título "Catalogo de Livros"
        JButton botaoVerLivros = new JButton("Ver Livros");
        botaoVerLivros.setFont(fontBotao);

        botaoVerLivros.addActionListener(e -> {
            JanelaVerLivros verLivros = new JanelaVerLivros(janela);
        });

        janela.add(rotuloNome);
        janela.add(campoNome);

        janela.add(rotuloAutor);
        janela.add(campoAutor);

        janela.add(rotuloGenero);
        janela.add(comboGenero);

        janela.add(rotuloEditora);
        janela.add(painelEditoras);

        janela.add(botaoVerLivros);
        janela.add(botaoEnviar);

        janela.setVisible(true);
    }

    // public static void abrirCatalogoLivros(){
    //         janelaVerLivros = new JFrame();
    //         janelaVerLivros.setTitle("Catalogo de Livros");
    //         janelaVerLivros.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //         janelaVerLivros.setLocationRelativeTo(janela);
    //         janelaVerLivros.setLayout(new GridLayout(1, 1, 10, 10));
    //         janelaVerLivros.setResizable(false);
    //         janelaVerLivros.setSize(400, 400);

    //         String[] listaColunas = { "ID", "Nome", "Autor", "Gênero", "Editora" };

    //         // Criando o modelo da tabela
    //         DefaultTableModel modeloTabela = new DefaultTableModel(listaColunas, 0);

    //         // Criando a JTable com o modelo
    //         JTable tabelaLivros = new JTable(modeloTabela);
            
    //         java.util.List<Livro> livros = con.buscarLivros();

    //         for (Livro l : livros){
    //             String[] infoLivro = {Integer.toString(l.getIdLivro()), l.getNomeLivro(), l.getAutorLivro(), l.getGeneroLivro(), l.getEditoraLivro()};
                
    //             modeloTabela.addRow(infoLivro);
    //         }

    //         JScrollPane scrollLivros = new JScrollPane(tabelaLivros);
            
    //         janelaVerLivros.add(scrollLivros);
    //         janelaVerLivros.setVisible(true);
    // }
}
