public class Funcionario {
    public int matricula;
    public String nome;
    public String cpf;
    public String cargo;
    public double salario;
    
    public Funcionario(int matricula, String nome, String cpf, String cargo, double salario){
        this.matricula = matricula;
        this.nome = nome;
        this.cpf = cpf;
        this.cargo = cargo;
        this.salario = salario;
    }

    public void mostrarInformacoes(){
        System.out.printf("----------Funcionario %d----------\n", this.matricula);

        System.out.println("Matricula: "+this.matricula);
        System.out.println("Nome: "+this.nome);
        System.out.println("CPF: "+this.cpf);
        System.out.println("Cargo: "+this.cargo);
        System.out.printf("Salario: R$ %.2f \n",this.salario);
    }
    
}
