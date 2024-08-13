package com.biblioteca;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Conexao con = new Conexao("jdbc:mysql://localhost:3306/bibliotecaapp", "root", "Aluno");
    static Scanner leitor = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Bem vindo ao Biblioteca APP");
            System.out.println("1. Ver Livros");
            System.out.println("2. Cadastrar Livro");
            System.out.println("3. Ver Clientes");
            System.out.println("4. Cadastrar Cliente");
            System.out.println("5. Ver alugueis");
            System.out.println("6. Alugar livro");
            System.out.println("0. Sair");

            System.out.println("Digite a opção desejada:");
            String opcao = leitor.nextLine();

            if (opcao.equals("1")) {
                List<Livro> livros = con.buscarLivros();

                for (Livro livro : livros) {
                    System.out.println(livro.toString());
                }

            } else if (opcao.equals("2")) {

                System.out.println("Digite o título do livro:");
                String titulo = leitor.nextLine();

                System.out.println("Digite o autor do livro:");
                String autor = leitor.nextLine();

                System.out.println("Digite o estoque do livro:");
                int estoque = Integer.parseInt(leitor.nextLine());

                Livro novoLivro = new Livro(0, titulo, autor, estoque);

                con.inserirNovoLivro(novoLivro);

            } else if (opcao.equals("3")) {
                List<Cliente> clientes = con.buscarclientes();

                for (Cliente cliente : clientes) {
                    System.out.println(cliente.toString());
                }
            } else if (opcao.equals("4")) {

                System.out.println("Digite o nome do cliente:");
                String nome = leitor.nextLine();

                System.out.println("Digite o cpf do cliente:");
                String cpf = leitor.nextLine();

                Cliente novoCliente = new Cliente(0, nome, cpf);

                con.inserirNovoCliente(novoCliente);

            } else if (opcao.equals("5")) {
                List<Aluguel> alugueis = con.buscarAlugueis();


                System.out.println("Id Aluguel | Id Cliente | Nome Livro | Data do Aluguel");
                for (Aluguel aluguel : alugueis) {
                    Livro livro = con.buscarLivroPorId(aluguel.getIdLivro());
                    System.out.printf("%d | %d | %s | %s\n",aluguel.getIdAluguel(), aluguel.getIdCliente(), livro.getNomeLivro(), aluguel.getDataAluguel());
                }

            } else if (opcao.equals("6")) {

                List<Livro> livros = con.buscarLivros();

                for (Livro livro : livros) {
                    System.out.println(livro.getIdLivro() + ". " + livro.getNomeLivro());
                }
                System.out.println("Escolha um livro pelo id: ");
                int idLivro = Integer.parseInt(leitor.nextLine());

                Boolean livroValido = false;

                for (Livro livro:livros){
                    if (livro.getIdLivro() == idLivro){
                        livroValido = true;
                        break;
                    }
                }

                if (livroValido) {
                    List<Cliente> clientes = con.buscarclientes();

                    for (Cliente cliente : clientes) {
                        System.out.println(cliente.getIdCliente() + ". " + cliente.getNomeCliente());
                    }

                    System.out.println("Escolha um cliente pelo id:");
                    int idCliente = Integer.parseInt(leitor.nextLine());

                    Aluguel novoAluguel = new Aluguel(0, idCliente, idLivro, "");

                    con.inserirNovoAluguel(novoAluguel);
                } else{
                    System.out.println("Livro não encontrado");
                }

            } else if (opcao.equals("0")) {
                System.out.println("Saindo do programa...");
                break;
            } else {
                System.out.println("Opção inválida...");
            }
            System.out.println("TECLE ENTER PARA CONTINUAR");
            leitor.nextLine();
        }
    }

}
