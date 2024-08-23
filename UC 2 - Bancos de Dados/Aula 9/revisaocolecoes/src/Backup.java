import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;



public class Backup {
    public static void main(String[] args) throws Exception {
    
        // Criar um serviço de cadastro de funcionário. 
        
        Scanner leitor = new Scanner(System.in);

        int matriculaFuncionarios = 1;
        List<Funcionario> listaFuncionarios = new ArrayList<>();


        while (true){

            System.out.println("--------CADASTRO DE FUNCIONÁRIOS--------");

            System.out.println("Digite o nome do novo funcionário: ");
            String novoNome = leitor.nextLine();

            System.out.println("Digite o cargo do novo funcionário: ");
            String novoCargo = leitor.nextLine();

            System.out.println("Digite o cpf do novo funcionário: ");
            String novoCpf = leitor.nextLine();

            System.out.println("Digite o salário do novo funcionário: ");
            double novoSalario = Double.parseDouble(leitor.nextLine());

            Funcionario novoFuncionario = new Funcionario(matriculaFuncionarios, novoNome, novoCargo, novoCpf, novoSalario);

            matriculaFuncionarios++;

            listaFuncionarios.add(novoFuncionario);

            System.out.println("Deseja continuar? (Sim/Nao)");
            String resposta = leitor.nextLine();

            if (resposta.equals("Nao")){
                System.out.println("Encerrando Cadastro de Funcionários!");
                break;
            }
        }

        for (Funcionario f : listaFuncionarios){
            f.mostrarInformacoes();
        }

        for (int i = 0; i<listaFuncionarios.size(); i++){
            listaFuncionarios.get(i).mostrarInformacoes();
        }

        
    }
}
