import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    static List<Funcionario> funcionarios = new ArrayList<>();

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        // Crie um programa que imprime na tela a seguinte mensagem:

        /*
         * Bem vindo a menu RH:
         * 
         * Escolha uma opção:
         * 
         * 1. Ver Funcionários
         * 2. Cadastrar Funcionário
         * 3. Alterar Funcionário
         * 4. Remover Funcionário
         * 0. Sair
         * 
         */

        // Crie uma lista para armazenar os funcionários de seu programa. Elabore uma
        // maneira de adicionar os funcionários a esta lista quando executar o
        // cadastrarFuncionarios().
        // 1. Criar a lista de funcionários logo abaixo da linha public class App
        // 2. Na função cadastrarFuncionario(), inserir uma linha
        // funcionarios.add(novoFuncionário)

        // Crie uma função verFuncionarios() que lê a lista de funcionários e os exibe
        // na tela como no exemplo:
        /*
         * Lista de Funcionários:
         * 1. Fulano da Silva
         * 2. Manoel Ciclano
         * 3. Beltrano Moreira
         */
        while (true) {

            System.out.println("Bem vindo a Empresa XYZ");
            System.out.println();
            System.out.println("Bem vindo ao Sistema RH");
            System.out.println();
            System.out.println("Escolha uma opção:");
            System.out.println();
            System.out.println("1. Ver Funcionários");
            System.out.println("2. Cadastrar Funcionário");
            System.out.println("3. Alterar Funcionário");
            System.out.println("4. Remover Funcionário");
            System.out.println("0. Sair");

            System.out.println("\nDigite a opção desejada: ");

            int opcao = Integer.parseInt(leitor.nextLine());

            // Ao escolher a opção, utilize uma estrutura de decisão (if-else/switch) para
            // imprimir na tela a opção escolhida. Ex: Se a pessoa escolher a opção 4,
            // imprima "Você escolheu Remover Funcionário!". Repita o programa enquanto a
            // pessoa não escolher a opção 0. Sair

            if (opcao == 1) {

                verFuncionarios();
                // Exiba um número ao lado do nome dos funcionários e permita que a pessoa
                // digite o número do funcionário que ela deseja ver mais informações. Use o
                // mostrarInformações do funcionário escolhido.
                System.out.println("Digite o número do funcionário escolhido:");
                int numeroFuncionario = Integer.parseInt(leitor.nextLine());

                if (numeroFuncionario > 0 && numeroFuncionario <= funcionarios.size()) {
                    Funcionario funcionarioEscolhido = funcionarios.get(numeroFuncionario - 1);
                    funcionarioEscolhido.mostrarInformacoes();

                } else {
                    System.out.println("Número inválido");
                }

                // Dica: funcionarios.get()

            } else if (opcao == 2) {

                cadastrarFuncionario();

                System.out.println(funcionarios);
                // Crie uma função que imprime na tela "CADASTRO DE FUNCIONÁRIOS"
                // Agora modifique a função para executar a operação de criar um funcionário:
                // Solicitar ao usuário as informações do funcionário (matricula, nome, cpf,
                // cargo, salário)
                // Criar um objeto do tipo de funcionário com essas informações
                // Rodar o mostrarInformações desse funcionário
            } else if (opcao == 3) {
                alterarFuncionario();

                // Criar a função alterarFuncionario() onde é exibida a lista de funcionários, o
                // usuário escolhe um funcionário da lista e o programa pede cada informação que
                // deverá ser alterada do funcionário.

            } else if (opcao == 4) {

                removerFuncionario();

                // Crie uma função chamada removerFuncionario(). Essa função deve exibir a lista
                // de funcionários, pedir ao usuário que selecione um dos funcionários, o
                // funcionário selecionado deve ser removido da lista e uma mensagem deve ser
                // exibida confirmando a remoção. Exemplo: "O funcionário 12345 foi removido com
                // sucesso!"

            } else if (opcao == 0) {
                System.out.println("Você escolheu Sair!");
                break;
            } else {
                System.out.println("Opção inválida!");
            }

            System.out.println("Pressione ENTER para continuar!");
            leitor.nextLine();

        }
    }

    public static void verFuncionarios() {
        // For each
        System.out.println("----------------------------");
        System.out.println("Lista de Funcionários:");
        int contador = 1;
        for (Funcionario f : funcionarios) {
            System.out.println(contador + ". " + f.nome);
            contador++;
        }

        // System.out.println("----------------------------");
        // System.out.println("Lista de Funcionários:");

        // // For tradicional
        // for (int i = 0; i < funcionarios.size(); i++) {

        // int numero = i + 1;
        // Funcionario funcionarioDaVez = funcionarios.get(i);

        // System.out.println(numero + ". " + funcionarioDaVez.nome);

        // }

        // System.out.println("----------------------------");
        // System.out.println("Lista de Funcionários:");
        // System.out.println("MATRICULA | NOME | CPF | CARGO | SALÁRIO");

        // for (Funcionario f : funcionarios) {
        // System.out.println(f.matricula + " | " + f.nome + " | " + f.cpf + " | " +
        // f.cargo + " | R$" + f.salario);
        // }

    }

    public static void alterarFuncionario() {
        Scanner leitor = new Scanner(System.in);
        System.out.println("ALTERAÇÃO DE FUNCIONÁRIO");
        System.out.println("----------------------------");
        verFuncionarios();

        System.out.println("Digite o número do funcionário que deseja modificar: ");
        int numeroEscolhido = Integer.parseInt(leitor.nextLine());

        if (numeroEscolhido > 0 && numeroEscolhido <= funcionarios.size()) {
            Funcionario funcionarioEscolhido = funcionarios.get(numeroEscolhido - 1);

            funcionarioEscolhido.mostrarInformacoes();

            System.out.println("Digite o novo nome:");
            String novoNome = leitor.nextLine();

            System.out.println("Digite o novo cpf:");
            String novoCpf = leitor.nextLine();

            System.out.println("Digite o novo cargo:");
            String novoCargo = leitor.nextLine();

            System.out.println("Digite o novo salário:");
            Double novoSalario = Double.parseDouble(leitor.nextLine());

            if (!novoNome.equals("")) {

                funcionarioEscolhido.nome = novoNome;
            }

            funcionarioEscolhido.cpf = novoCpf;
            funcionarioEscolhido.cargo = novoCargo;
            funcionarioEscolhido.salario = novoSalario;

            System.out.println("Funcionário Atualizado");

            funcionarioEscolhido.mostrarInformacoes();

        } else {
            System.out.println("Escolha um número válido!");
        }
    }

    public static void removerFuncionario() {
        Scanner leitor = new Scanner(System.in);
        System.out.println("REMOÇÃO DE FUNCIONÁRIO");
        System.out.println("----------------------------");

        verFuncionarios();

        System.out.println("Digite o número do funcionário que deseja remover: ");
        int numeroEscolhido = Integer.parseInt(leitor.nextLine());

        if (numeroEscolhido > 0 && numeroEscolhido <= funcionarios.size()) {
            Funcionario funcionarioEscolhido = funcionarios.get(numeroEscolhido - 1);

            funcionarioEscolhido.mostrarInformacoes();

            // System.out.println("Digite o novo nome:");
            // String novoNome = leitor.nextLine();

            // if (!novoNome.equals("")){
            // funcionarioEscolhido.nome = novoNome;
            // }

            System.out.println("Tem certeza que deseja remover este funcionário? (SIM/NAO)");
            String resposta = leitor.nextLine();

            if (resposta.equals("SIM")) {

                System.out.println("O funcionário #" + funcionarioEscolhido.matricula + " foi removido!");

                funcionarios.remove(funcionarioEscolhido);

            } else {
                System.out.println("Remoção cancelada!");
            }
            // funcionarios.remove(numeroEscolhido-1);
        } else {
            System.out.println("Número inválido!");
        }

        System.out.println("Lista atualizada!");
        verFuncionarios();
    }

    public static void cadastrarFuncionario() {
        Scanner leitor = new Scanner(System.in);

        System.out.println("CADASTRO DE FUNCIONÁRIOS");

        System.out.println("Digite a matricula do novo funcionário: ");
        int novaMatricula = Integer.parseInt(leitor.nextLine());

        System.out.println("Digite o nome do novo funcionário: ");
        String novoNome = leitor.nextLine();

        System.out.println("Digite o cargo do novo funcionário: ");
        String novoCargo = leitor.nextLine();

        System.out.println("Digite o cpf do novo funcionário: ");
        String novoCpf = leitor.nextLine();

        System.out.println("Digite o salário do novo funcionário: ");
        double novoSalario = Double.parseDouble(leitor.nextLine());

        Funcionario novoFuncionario = new Funcionario(novaMatricula, novoNome, novoCargo, novoCpf, novoSalario);

        novoFuncionario.mostrarInformacoes();

        System.out.println("Funcionário Cadastrado com Sucesso!");
        funcionarios.add(novoFuncionario);

    }

    public static void minhaFuncao() {
        System.out.println("Esta função está executando!");
    }

}
