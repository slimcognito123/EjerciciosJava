package solucion2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PruebaConSolucion2 implements ActionListener {
        JFrame frame;
        JPanel panel;
        JLabel label;
        JButton boton;
        public PruebaConSolucion2() {
            frame = new JFrame("holi");
            frame.setSize(800,600);
            frame.setDefaultCloseOperation(3);
            panel= new JPanel();
            frame.setContentPane(panel);
            panel.setBackground(Color.CYAN);
            label=new JLabel("clicka boton");
            panel.add(label);
            boton= new JButton("Soy un Botooon :D");
            boton.addActionListener(this);
            panel.add(boton);
            frame.setVisible(true);
        }
        public static void main(String[] args){
            new PruebaConSolucion2();
        }

    @Override
    public void actionPerformed(ActionEvent e) {
        boton.setFont(new Font("Consoles",3,23));
        boton.setForeground(Color.RED);
        frame.setTitle("holiwis he cambiado :3");
    }
}


