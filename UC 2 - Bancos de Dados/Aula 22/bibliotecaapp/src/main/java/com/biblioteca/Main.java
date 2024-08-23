package com.biblioteca;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

public class Main {
    static Conexao con = new Conexao("jdbc:mysql://localhost:3306/bibliotecaapp", "root", "Aluno");
    
    public static void main(String[] args) {
        
        List<String> opcoes = new ArrayList<>();
        opcoes.add("Ver Livros");
        opcoes.add("Escolher Livro");

        int escolha = JOptionPane.showOptionDialog(null, "Escolha uma das opções do menu!", "Menu",JOptionPane.DEFAULT_OPTION, 0, null, opcoes.toArray(), opcoes.get(0));

        if (escolha == 0){
            verLivros();
        }
        else if (escolha == 1){
            escolherLivro();
        }else{
            JOptionPane.showMessageDialog(null, "Escolha Inválida!", null, 0);
        }

        
        
    }

    public static void verLivros(){
        //Exibir em um JOptionPane a lista de livros cadastrados na biblioteca
        //No formato:
        //<id>. <nome>
        List<Livro> livros = con.buscarLivros();
        
        String mensagem = "";

        for (Livro l : livros){
            mensagem = mensagem + l.getIdLivro()+". "+l.getNomeLivro()+"\n";
        }
        
        JOptionPane.showMessageDialog(null, mensagem, "Lista de Livros", 1);
    }

    public static void escolherLivro(){
        //Exibir em um JOptionPane a lista de livros cadastrados na biblioteca
        //No formato:
        //<id>. <nome>
        List<Livro> livros = con.buscarLivros();
        
        String mensagem = "Escolha um dos livros da lista abaixo:\n\n";

        for (Livro l : livros){
            mensagem = mensagem + l.getIdLivro()+". "+l.getNomeLivro()+"\n";
        }

        // Utilizar um inputDialog para escolher um livro pelo id e exibir com um showDialog as informações do livro, seguindo o formato:
        //ID: 
        //Nome:
        //Autor:
        //Genero:
        //Editora:

        mensagem = mensagem + "\nDigite o id desejado:";
        
        String idLivroEscolhido = JOptionPane.showInputDialog(null, mensagem, "Lista de Livros", 1);

        Livro livroEscolhido = con.buscarLivroPorId(Integer.parseInt(idLivroEscolhido));

        if (livroEscolhido == null){
            JOptionPane.showMessageDialog(null, "Livro não encontrado!");
        } else{

            String informacoesLivroEscolhido = "ID: "+livroEscolhido.getIdLivro()+
            "\nNome: "+ livroEscolhido.getNomeLivro()+
            "\nAutor: "+ livroEscolhido.getAutorLivro()+
            "\nGenero: "+ livroEscolhido.getGeneroLivro()+
            "\nEditora: "+ livroEscolhido.getEditoraLivro();


            JOptionPane.showMessageDialog(null, informacoesLivroEscolhido, "Livro Escolhido", 1);
        }
    }
}
