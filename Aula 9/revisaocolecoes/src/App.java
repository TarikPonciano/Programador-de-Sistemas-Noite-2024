public class App {
    public static void main(String[] args) throws Exception {
        
        Funcionario f1 = new Funcionario(1, "Josias Campos", "12345678910", "Vendedor", 5000);

        Funcionario f2 = new Funcionario(2, "Maria Rosário", "98765432100", "Gerente", 9000);
        
        f1.mostrarInformacoes();
        
        f2.mostrarInformacoes();
        // System.out.println("----------Funcionario 1----------");
        // System.out.println("Matricula: "+f1.matricula);
        // System.out.println("Nome: "+f1.nome);
        // System.out.println("CPF: "+f1.cpf);
        // System.out.println("Cargo: "+f1.cargo);
        // System.out.printf("Salario: R$ %.2f \n",f1.salario);
    
        // Crie 2 funcionários utilizando a classe funcionário e imprima na tela suas informações, no seguinte formato
        // Matricula: <matricula>
        // Nome: <nome>
        // CPF: <cpf>
        // Cargo: <cargo>
        // Salário: <salario>
        

    }
}
