package com.escola;

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
                System.out.println("Rodando o ver alunos!");
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
