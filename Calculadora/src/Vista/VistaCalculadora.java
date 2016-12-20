package Vista;

import ControlBotones.ButtonController;

import javax.swing.*;
import java.awt.*;

public class VistaCalculadora extends JFrame {
    JPanel panel;
    JPanel panelArriba;
    JPanel panelBotones;

    JTextField cosaDeArriba;

    JButton boton1;
    JButton boton2;
    JButton boton3;
    JButton boton4;
    JButton boton5;
    JButton boton6;
    JButton boton7;
    JButton boton8;
    JButton boton9;
    JButton boton0;
    JButton botonSuma;
    JButton botonResta;
    JButton botonDivision;
    JButton botonMultiplicacion;
    JButton botonIgual;
    JButton botonPunto;
    JButton botonBorrar1;
    JButton botonBorrarNumero;
    JButton botonBorrarTodo;
    ButtonController controller;

    public VistaCalculadora() {
        iniciarVista();
        inicialiarController();
        darUsoBotones();
        setVisible(true);
    }

    private void inicialiarController() {
        controller = new ButtonController(this);
    }

    private void darUsoBotones() {
        boton0.addActionListener(controller.instruction());
        boton1.addActionListener(controller.instruction());
        boton2.addActionListener(controller.instruction());
        boton3.addActionListener(controller.instruction());
        boton4.addActionListener(controller.instruction());
        boton5.addActionListener(controller.instruction());
        boton6.addActionListener(controller.instruction());
        boton7.addActionListener(controller.instruction());
        boton8.addActionListener(controller.instruction());
        boton9.addActionListener(controller.instruction());
        botonMultiplicacion.addActionListener(controller.instruction());
        botonDivision.addActionListener(controller.instruction());
        botonSuma.addActionListener(controller.instruction());
        botonResta.addActionListener(controller.instruction());
        botonIgual.addActionListener(controller.instruction());
        botonPunto.addActionListener(controller.instruction());
        botonBorrar1.addActionListener(controller.instruction());
        botonBorrarTodo.addActionListener(controller.instruction());
        botonBorrarNumero.addActionListener(controller.instruction());
    }

    private void iniciarVista() {
        panel = new JPanel();
        this.setTitle("Calculadora del Windon");
        this.setDefaultCloseOperation(3);
        setSize(500, 600);
        setContentPane(panel);
        panel.setBackground(Color.cyan);
        this.setLayout(null);
        this.setResizable(false);

        panelArriba = new JPanel();
        panelArriba.setBounds(0, 0, 500, 60);
        panelArriba.setLayout(null);

        cosaDeArriba = new JTextField();
        cosaDeArriba.setBounds(0, 0, 500, 60);
        panelArriba.add(cosaDeArriba);

        panelBotones = new JPanel();
        panelBotones.setBounds(0, 70, 500, 500);
        panelBotones.setLayout(new GridLayout(5, 4));
        panelBotones.setBackground(Color.cyan);

        iniciarBotones();
        darFuenteBotones();
        introBotonesPanel();
        panel.add(panelArriba);
        panel.add(panelBotones);
    }

    private void darFuenteBotones() {
        boton0.setFont(new Font("Consolas", 1, 40));
        boton1.setFont(new Font("Consolas", 1, 40));
        boton2.setFont(new Font("Consolas", 1, 40));
        boton3.setFont(new Font("Consolas", 1, 40));
        boton4.setFont(new Font("Consolas", 1, 40));
        boton5.setFont(new Font("Consolas", 1, 40));
        boton6.setFont(new Font("Consolas", 1, 40));
        boton7.setFont(new Font("Consolas", 1, 40));
        boton8.setFont(new Font("Consolas", 1, 40));
        boton9.setFont(new Font("Consolas", 1, 40));
        botonIgual.setFont(new Font("Consolas", 1, 40));
        botonMultiplicacion.setFont(new Font("Consolas", 1, 40));
        botonSuma.setFont(new Font("Consolas", 1, 40));
        botonDivision.setFont(new Font("Consolas", 1, 40));
        botonResta.setFont(new Font("Consolas", 1, 40));
        botonPunto.setFont(new Font("Consolas", 1, 40));
        cosaDeArriba.setFont(new Font("Consolas", 1, 40));
        botonBorrar1.setFont(new Font("Consolas", 1, 40));
        botonBorrarNumero.setFont(new Font("Consolas", 1, 40));
        botonBorrarTodo.setFont(new Font("Consolas", 1, 40));
    }

    private void introBotonesPanel() {
        panelBotones.add(boton1);
        panelBotones.add(boton2);
        panelBotones.add(boton3);
        panelBotones.add(botonSuma);
        panelBotones.add(boton4);
        panelBotones.add(boton5);
        panelBotones.add(boton6);
        panelBotones.add(botonResta);
        panelBotones.add(boton7);
        panelBotones.add(boton8);
        panelBotones.add(boton9);
        panelBotones.add(botonMultiplicacion);
        panelBotones.add(botonPunto);
        panelBotones.add(boton0);
        panelBotones.add(botonIgual);
        panelBotones.add(botonDivision);
        panelBotones.add(botonBorrar1);
        panelBotones.add(botonBorrarNumero);
        panelBotones.add(botonBorrarTodo);

    }

    private void iniciarBotones() {
        boton0 = new JButton("0");
        boton1 = new JButton("1");
        boton2 = new JButton("2");
        boton3 = new JButton("3");
        boton4 = new JButton("4");
        boton5 = new JButton("5");
        boton6 = new JButton("6");
        boton7 = new JButton("7");
        boton8 = new JButton("8");
        boton9 = new JButton("9");
        botonIgual = new JButton("=");
        botonMultiplicacion = new JButton("*");
        botonDivision = new JButton("/");
        botonSuma = new JButton("+");
        botonResta = new JButton("-");
        botonPunto = new JButton(".");
        botonBorrar1= new JButton("<-");
        botonBorrarNumero= new JButton("C");
        botonBorrarTodo= new JButton("CE");
    }

    public String getTextoCosaArriba(){
        return cosaDeArriba.getText();
    }
    public void setTextoCosaArriba(String textoCosaArriba){
        cosaDeArriba.setText(textoCosaArriba);
    }
}
