import java.util.Scanner;

public class Funcoes {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        System.out.println("Digite o número 1:");
        double numero1 = Double.parseDouble(leitor.nextLine());

        System.out.println("Digite o número 2:");
        double numero2 = Double.parseDouble(leitor.nextLine());

        System.out.println("Escolha uma operação (+,-,*,/):");
        String operacao = leitor.next();

        if (operacao.equals("+")){
            System.out.println(somar(numero1, numero2));
        }else if (operacao.equals("-")){
            System.out.println(subtrair(numero1, numero2));
        }

    }
    
    public static void olaMundo(){
        Scanner leitor = new Scanner(System.in);

        System.out.println("Digite seu nome:");
        String novoNome = leitor.nextLine();

        System.out.println("Olá "+novoNome);
    }

    public static double somar(double n1, double n2){

        double resultado = n1 + n2;

       return resultado;

    }

    public static double subtrair(double n1, double n2){

        double resultado = n1 - n2;

       return resultado;

    }
}
