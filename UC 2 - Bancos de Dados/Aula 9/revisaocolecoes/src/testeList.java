import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class testeList {

    public static void main(String[] args) {

        // Faça um programa que pede o nome de uma pessoa e adiciona esse nome em uma
        // lista de nomes. O programa deve continuar pedindo nomes até que seja digitado
        // "SAIR". Ao final exiba a lista de nomes inseridos.

        Scanner leitor = new Scanner(System.in);
        List<String> listaNomes = new ArrayList<>();

        while (true) {
            System.out.println("Digite seu nome: ");
            String nome = leitor.nextLine();

            if (nome.equals("SAIR")) {
                break;
            }

            listaNomes.add(nome);
        }
        System.out.println(listaNomes);

        for (int i = 0; i<listaNomes.size(); i++){
            System.out.println("Olá, "+ listaNomes.get(i)+"!");
        }

        for (String nome : listaNomes) {
            System.out.println("Olá, "+ nome.toUpperCase() +"!");
        }


    }

}
