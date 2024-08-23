public class Funcionario {
    public int matricula;
    public String nome;
    public String cargo;
    public String cpf;
    public double salario;

    public Funcionario(int matricula, String nome, String cargo, String cpf, double salario) {

        this.matricula = matricula;
        this.nome = nome;
        this.cargo = cargo;
        this.cpf = cpf;
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
