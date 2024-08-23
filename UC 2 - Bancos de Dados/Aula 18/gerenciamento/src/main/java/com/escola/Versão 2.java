package com.escola;

import java.sql.*;

import java.util.Scanner;

public class Main {

    static Scanner leitor = new Scanner(System.in);

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
                try {
                    String url = "jdbc:mysql://localhost:3306/escola";
                    String usuario = "root";
                    String senha = "Aluno";

                    Connection con = DriverManager.getConnection(url, usuario, senha);

                    System.out.println("Conexão criada com sucesso!");

                    Statement st = con.createStatement();
                    ResultSet rs = st.executeQuery("SELECT * FROM aluno");

                    System.out.println("Lista de Alunos: ");

                    System.out.println("Matricula | Nome | CPF | Data de Nascimento | Ano de Matricula | Média | Faltas");

                    while (rs.next()){
                        int matricula = rs.getInt(1);
                        String nome = rs.getString(2);
                        String cpf = rs.getString(3);
                        String dataNascimento = rs.getString(4);
                        int anoMatricula = rs.getInt(5);
                        double media = rs.getDouble(6);
                        int faltas = rs.getInt(7);

                        System.out.printf("%d | %s | %s | %s | %d | %.1f | %d\n",matricula, nome, cpf, dataNascimento, anoMatricula, media, faltas);
                    }

                    // Peça ao usuário o número de matrícula de um aluno e exiba na tela as informações do aluno no formato:
                    // Nome: <nome do aluno>
                    // Média: <média do aluno>
                    // Situação: <aprovado/reprovado>

                    // DICA SQL > SELECT * FROM aluno WHERE matricula_aluno = {matricula} 

                    System.out.println("Digite a matrícula do aluno desejado: ");
                    int matricula = Integer.parseInt(leitor.nextLine());

                    rs = st.executeQuery("SELECT * FROM aluno WHERE matricula_aluno = "+matricula);

                    if (rs.next()){
                        System.out.println("Nome: "+rs.getString(2));
                        System.out.println("Média: "+rs.getDouble(6));
                        // Verificar a média. Se for igual ou acima de 7 imprima aprovado, se não imprima reprovado
                        System.out.println("Situação: ");
                    }else{
                        System.out.println("Aluno não encontrado!");
                    }

                    rs.close();
                    st.close();
                    con.close(); 
                } catch (SQLException e) {
                    System.err.println(e.getMessage());
                }

            } else if (op.equals("2")) {
                System.out.println("Rodando o cadastrar novo aluno!");
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
