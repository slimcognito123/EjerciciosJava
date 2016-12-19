package solucion3;

import solucion2.PruebaConSolucion2;

import javax.swing.*;
import java.awt.*;

public class PruebaConSolucion3 {
    JFrame frame;
    JPanel panel;
    JLabel label;
    JButton boton;

    public PruebaConSolucion3() {
        frame = new JFrame("holi");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(3);
        panel = new JPanel();
        frame.setContentPane(panel);
        panel.setBackground(Color.CYAN);
        label = new JLabel("clicka boton");
        panel.add(label);
        boton = new JButton("Soy un Botooon :D");
        boton.addActionListener(new CambiandoCosas(this));
        panel.add(boton);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new PruebaConSolucion2();
    }


}
