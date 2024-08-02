package com.escola;

import java.sql.*;

import java.util.Scanner;

public class Main {

    static Scanner leitor = new Scanner(System.in);
    static DBConexao conexao = new DBConexao("jdbc:mysql://localhost:3306/escola", "root", "Aluno");

    public static void main(String[] args) {
        while (true) {
            System.out.println("Bem vindo ao Senac");
            System.out.println();
            System.out.println("Escolha uma opção do menu:");
            System.out.println();
            System.out.println("1. Ver alunos");
            System.out.println("2. Cadastrar novo aluno");
            System.out.println("3. Modificar cadastro de aluno");
            System.out.println("4. Excluir cadastro de aluno");
            System.out.println("0. Sair");
            System.out.println();

            System.out.println("Digite o número da opção desejada: ");
            String op = leitor.nextLine();

            if (op.equals("1")) {
                // Conectar com o banco escola
                // Execultar consulta usando uma mensagem sql
                // Receber o conjunto de resultados
                // Percorrer o cojunto de resultados imprimindo cada informação do aluno na tela
                conexao.verAlunos();

                System.out.println("Digite a matricula do aluno que deseja visualizar: ");
                int matricula = Integer.parseInt(leitor.nextLine());
                conexao.verAluno(matricula);


            } else if (op.equals("2")) {
                // Pedir as informações do aluno
                System.out.println("CADASTRO DE USUÁRIO");

                System.out.println("Digite o nome:");
                String nome = leitor.nextLine();

                System.out.println("Digite o cpf:");
                String cpf = leitor.nextLine();

                System.out.println("Digite a data de nascimento (ano-mês-dia):");
                String dataNascimento = leitor.nextLine();  

                System.out.println("Digite a média do aluno:");
                double media = Double.parseDouble(leitor.nextLine());

                System.out.println("Digite as faltas do aluno:");
                int falta = Integer.parseInt(leitor.nextLine());
                // Montar um objeto do tipo Aluno
                Aluno novoAluno = new Aluno(0, nome, cpf, dataNascimento, 0, media, falta);

                // Enviar para o objeto conexao
                conexao.inserirAluno(novoAluno);

            } else if (op.equals("3")) {
                System.out.println("Rodando o modificar aluno!");
            } else if (op.equals("4")) {
                System.out.println("Rodando o excluir aluno!");
            } else if (op.equals("0")) {
                System.out.println("Saindo!");
                break;
            } else {
                System.out.println("Opção inválida!");
            }
            System.out.println("Tecle ENTER para continuar:");
            leitor.nextLine();
        }
    }

}
