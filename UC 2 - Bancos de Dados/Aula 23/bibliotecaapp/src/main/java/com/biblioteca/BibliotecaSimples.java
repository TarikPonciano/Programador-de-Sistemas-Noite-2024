package com.biblioteca;

import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

public class BibliotecaSimples {
    static Conexao con = new Conexao("jdbc:mysql://localhost:3306/bibliotecaapp", "root", "Aluno");

    public static void main(String[] args) {

        List<String> opcoes = new ArrayList<>();
        opcoes.add("Ver Livros");
        opcoes.add("Escolher Livro");
        opcoes.add("Inserir Livro");

        int escolha = JOptionPane.showOptionDialog(null, "Escolha uma das opções do menu!", "Menu",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes.toArray(), opcoes.get(0));

        if (escolha == 0) {
            verLivros();
        } else if (escolha == 1) {
            escolherLivro();
        } else if (escolha == 2) {
            inserirLivro();
        }

        else {
            JOptionPane.showMessageDialog(null, "Escolha Inválida!", null, 0);
        }

    }

    // Criar a funcionalidade inserir livro que utilizando o showInputDialog deverá
    // pedir Nome, Autor, Gênero(Dar 3 opções de gênero) e Editora (Dar 3 opções de
    // editora) e ao final cadastrar esse livro no banco de dados

    public static void inserirLivro() {

        JOptionPane.showMessageDialog(null, "Bem vindo ao Inserir Livro!");

       
        String nome = JOptionPane.showInputDialog("Digite o nome:");

        String autor = JOptionPane.showInputDialog("Digite o autor:");

        List<String> generos = new ArrayList<>();
        generos.add("Ficção");
        generos.add("Ficção Científica");
        generos.add("Romance");
        generos.add("Drama");

        String genero = (String) JOptionPane.showInputDialog(null, "Escolha um gênero", "Escolha de Gênero", JOptionPane.QUESTION_MESSAGE, null, generos.toArray(), generos.get(0));

        List<String> editoras = new ArrayList<>();
        editoras.add("Record");
        editoras.add("Erika");
        editoras.add("Rocco");
        editoras.add("Senac");

        String editora = (String) JOptionPane.showInputDialog(null, "Escolha uma editora", "Escolha de Editora", JOptionPane.QUESTION_MESSAGE, null, editoras.toArray(), editoras.get(0));
    
        Livro novoLivro = new Livro(0, nome, autor, genero, editora);
        
        con.inserirNovoLivro(novoLivro);

        JOptionPane.showMessageDialog(null,"Livro inserido com sucesso!");
       }

    public static void verLivros() {
        // Exibir em um JOptionPane a lista de livros cadastrados na biblioteca
        // No formato:
        // <id>. <nome>
        List<Livro> livros = con.buscarLivros();

        String mensagem = "";

        for (Livro l : livros) {
            mensagem = mensagem + l.getIdLivro() + ". " + l.getNomeLivro() + "\n";
        }

        JOptionPane.showMessageDialog(null, mensagem, "Lista de Livros", 1);
    }

    public static void escolherLivro() {
        // Exibir em um JOptionPane a lista de livros cadastrados na biblioteca
        // No formato:
        // <id>. <nome>
        List<Livro> livros = con.buscarLivros();

        String mensagem = "Escolha um dos livros da lista abaixo:\n\n";

        for (Livro l : livros) {
            mensagem = mensagem + l.getIdLivro() + ". " + l.getNomeLivro() + "\n";
        }

        // Utilizar um inputDialog para escolher um livro pelo id e exibir com um
        // showDialog as informações do livro, seguindo o formato:
        // ID:
        // Nome:
        // Autor:
        // Genero:
        // Editora:

        mensagem = mensagem + "\nDigite o id desejado:";

        String idLivroEscolhido = JOptionPane.showInputDialog(null, mensagem, "Lista de Livros", 1);

        Livro livroEscolhido = con.buscarLivroPorId(Integer.parseInt(idLivroEscolhido));

        if (livroEscolhido == null) {
            JOptionPane.showMessageDialog(null, "Livro não encontrado!");
        } else {

            String informacoesLivroEscolhido = "ID: " + livroEscolhido.getIdLivro() +
                    "\nNome: " + livroEscolhido.getNomeLivro() +
                    "\nAutor: " + livroEscolhido.getAutorLivro() +
                    "\nGenero: " + livroEscolhido.getGeneroLivro() +
                    "\nEditora: " + livroEscolhido.getEditoraLivro();

            JOptionPane.showMessageDialog(null, informacoesLivroEscolhido, "Livro Escolhido", 1);
        }
    }
}
