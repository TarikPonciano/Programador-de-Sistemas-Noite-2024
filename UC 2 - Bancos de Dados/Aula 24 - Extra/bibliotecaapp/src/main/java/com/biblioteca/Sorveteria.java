package com.biblioteca;

import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

public class Sorveteria {
    public static void main(String[] args) {
        // JOptionPane.showMessageDialog(null, "Hello World", "Meu primeiro popup!", JOptionPane.INFORMATION_MESSAGE);

        int resposta = JOptionPane.showConfirmDialog(null, "Você quer sorvete?", "Pergunta", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

        if (resposta == 0){
           // Mostre um popup que imprime "Você recebeu um sorvete de chocolate"
           String sabor = JOptionPane.showInputDialog(null, "Escolha seu sabor de sorvete", "Escolha o sabor", JOptionPane.QUESTION_MESSAGE);

           // Escolher um dos seguintes acompanhamentos Granulado, Granulado Colorido, MMs ou Castanha

        //    String acompanhamentos = "1. Granulado \n 2. Granulado Colorido \n 3. MMs \n 4. Castanha \n";

        //    String acompanhamento = JOptionPane.showInputDialog(null, acompanhamentos, "Escolha o acompanhamento", JOptionPane.QUESTION_MESSAGE);

            List<String> acompanhamentos = new ArrayList<>();
            acompanhamentos.add("Granulado");
            acompanhamentos.add("Granulado Colorido");
            acompanhamentos.add("MMs");
            acompanhamentos.add("Castanha");

            int acompanhamentoEscolhido = JOptionPane.showOptionDialog(null, "Escolha seu acompanhamento:", "Escolher Acompanhamento", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,null, acompanhamentos.toArray(), acompanhamentos.get(0) );

            String acompanhamento = acompanhamentos.get(acompanhamentoEscolhido);

           String mensagem = "Você recebeu um sorvete de "+sabor+" e acompanhamento " + acompanhamento + "!";

           JOptionPane.showMessageDialog(null, mensagem, "Resposta", 1);
        }else if (resposta == 1){
            JOptionPane.showMessageDialog(null, "Você ficou sem sorvete", "Resposta", 1);
        }else{
            System.out.println("Erro");
        }

    }
    
}
