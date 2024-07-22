package Backups;
import java.util.Scanner;

import Funcionario;

public class App {
    public static void main(String[] args) throws Exception {
        // Crie um formulário de texto usando a classe Scanner para pedir ao usuário as
        // informações do funcionário, crie um funcionário usando essas informações e
        // rode o método mostrarInformacoes() do funcionário criado.

        // Ao cadastrar um funcionário, pergunte ao final "Deseja continuar?", se o
        // usuário disser "Não" encerre o programa, do contrário, comece o cadastro de
        // outro funcionário.

        Scanner leitor = new Scanner(System.in);

        while (true) {

            System.out.println("--------CADASTRO DE FUNCIONÁRIOS--------");

            System.out.println("Digite a matricula:");
            int novoMatricula = Integer.parseInt(leitor.nextLine());

            System.out.println("Digite o nome:");
            String novoNome = leitor.nextLine();

            System.out.println("Digite o cpf:");
            String novoCpf = leitor.nextLine();

            System.out.println("Digite o cargo:");
            String novoCargo = leitor.nextLine();

            System.out.println("Digite o salário:");
            double novoSalario = Double.parseDouble(leitor.nextLine());

            Funcionario novoFuncionario = new Funcionario(novoMatricula, novoNome, novoCpf, novoCargo, novoSalario);

            System.out.println("Funcionário cadastrado com sucesso!");

            novoFuncionario.mostrarInformacoes();

            System.out.println("Deseja continuar? (Sim/Nao)");
            String continuar = leitor.nextLine();

            if (continuar.equals("Nao")){
                System.out.println("Encerrando Cadastro de Funcionários!");
                break;
            }
        }

        // Funcionario f1 = new Funcionario(1, "Josias Campos", "12345678910",
        // "Vendedor", 5000);

        // Funcionario f2 = new Funcionario(2, "Maria Rosário", "98765432100",
        // "Gerente", 9000);

        // f1.mostrarInformacoes();

        // f2.mostrarInformacoes();

        // System.out.println("----------Funcionario 1----------");
        // System.out.println("Matricula: "+f1.matricula);
        // System.out.println("Nome: "+f1.nome);
        // System.out.println("CPF: "+f1.cpf);
        // System.out.println("Cargo: "+f1.cargo);
        // System.out.printf("Salario: R$ %.2f \n",f1.salario);

        // Crie 2 funcionários utilizando a classe funcionário e imprima na tela suas
        // informações, no seguinte formato
        // Matricula: <matricula>
        // Nome: <nome>
        // CPF: <cpf>
        // Cargo: <cargo>
        // Salário: <salario>

    }
}
