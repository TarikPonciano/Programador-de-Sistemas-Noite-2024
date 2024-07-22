import java.util.Scanner;

public class App {
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

        // Ao escolher a opção, utilize uma estrutura de decisão (if-else/switch) para imprimir na tela a opção escolhida. Ex: Se a pessoa escolher a opção 4, imprima "Você escolheu Remover Funcionário!". Repita o programa enquanto a pessoa não escolher a opção 0. Sair
        
    }
}
