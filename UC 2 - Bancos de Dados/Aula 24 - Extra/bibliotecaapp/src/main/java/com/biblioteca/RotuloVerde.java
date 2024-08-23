package com.biblioteca;

import javax.swing.*;
import java.awt.*;

public class RotuloVerde extends JLabel {

    public RotuloVerde(String titulo){
        super(titulo);
        setFont(new Font("Arial", Font.BOLD, 24));
        setHorizontalAlignment(SwingConstants.CENTER);
        setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        setForeground(Color.CYAN);
        setBackground(Color.BLACK);
        setOpaque(true);
    }
    
}
