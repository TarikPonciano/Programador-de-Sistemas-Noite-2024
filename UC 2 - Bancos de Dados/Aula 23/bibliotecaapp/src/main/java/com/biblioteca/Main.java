package com.biblioteca;

import javax.swing.*;
import java.awt.*;


public class Main {
    public static void main(String[] args) {
        JFrame janela = new JFrame("Minha primeira janela");
        janela.setSize(400, 300);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setLocationRelativeTo(null);
        janela.setLayout(new GridLayout(5,2,10,10));

        JLabel rotuloNome = new JLabel("Nome: ");
        JTextField campoNome = new JTextField(20);

        JLabel rotuloAutor = new JLabel("Autor:");
        JTextField campoAutor = new JTextField(20);

        JLabel rotuloGenero = new JLabel("Gênero:");
        JTextField campoGenero = new JTextField(20);

        JLabel rotuloEditora = new JLabel("Editora:");
        JTextField campoEditora = new JTextField(20);

        JButton botaoEnviar = new JButton("Enviar");
        botaoEnviar.addActionListener(e -> {
            String nome = campoNome.getText();
            JOptionPane.showMessageDialog(null, "O nome digitado foi "+ nome);    
        });

        janela.add(rotuloNome);
        janela.add(campoNome);

        janela.add(rotuloAutor);
        janela.add(campoAutor);

        janela.add(rotuloGenero);
        janela.add(campoGenero);

        janela.add(rotuloEditora);
        janela.add(campoEditora);

        janela.add(new JLabel());
        janela.add(botaoEnviar);

        

        janela.setVisible(true);
    }
}
