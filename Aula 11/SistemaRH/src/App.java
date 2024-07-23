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

        // Crie uma lista para armazenar os funcionários de seu programa. Elabore uma maneira de adicionar os funcionários a esta lista quando executar o cadastrarFuncionarios().
        // 1. Criar a lista de funcionários logo abaixo da linha public class App
        // 2. Na função cadastrarFuncionario(), inserir uma linha funcionarios.add(novoFuncionário)
         
        // Crie uma função verFuncionarios() que lê a lista de funcionários e os exibe na tela como no exemplo:
        /* Lista de Funcionários:
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
                System.out.println("Você escolheu Ver Funcionários!");
            } else if (opcao == 2) {
                
                cadastrarFuncionario();

                System.out.println(funcionarios);
                // Crie uma função que imprime na tela "CADASTRO DE FUNCIONÁRIOS"
                // Agora modifique a função para executar a operação de criar um funcionário:
                // Solicitar ao usuário as informações do funcionário (matricula, nome, cpf, cargo, salário)
                // Criar um objeto do tipo de funcionário com essas informações
                // Rodar o mostrarInformações desse funcionário
            } else if (opcao == 3) {
                System.out.println("Você escolheu Alterar Funcionário!");
            } else if (opcao == 4) {
                System.out.println("Você escolheu Remover Funcionário!");
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

    public static void cadastrarFuncionario(){
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

        funcionarios.add(novoFuncionario);


    }

    public static void minhaFuncao(){
        System.out.println("Esta função está executando!");
    }

}
