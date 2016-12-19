package solucion1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PruebaConSolucion1 {
    JFrame frame;
    JPanel panel;
    JLabel label;
    JButton boton;
    public PruebaConSolucion1() {
        frame = new JFrame("holi");
        frame.setSize(800,600);
        frame.setDefaultCloseOperation(3);
        panel= new JPanel();
        frame.setContentPane(panel);
        panel.setBackground(Color.CYAN);
        label=new JLabel("clicka boton");
        panel.add(label);
        boton= new JButton("Soy un Botooon :D");
        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boton.setFont(new Font("Consoles",3,23));
                frame.setTitle("holiwis he cambiado :3");
            }
        });
        panel.add(boton);
        frame.setVisible(true);
    }
    public static void main(String[] args){
        new PruebaConSolucion1();
    }
}
