package ControlBotones;

import Vista.VistaCalculadora;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonController implements ActionListener {
    private VistaCalculadora vistaCalculadora = null;
    private String botonPulsado = null;
    private boolean tienePunto;
    private double a;
    private char operadorUsado=' ';
    private double b;

    public ButtonController(VistaCalculadora vistaCalculadora) {
        this.vistaCalculadora = vistaCalculadora;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton boton = (JButton) e.getSource();
        botonPulsado = boton.getText();
        switch (botonPulsado) {
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
            case "8":
            case "9":
            case "0":
                if (vistaCalculadora.getTextoCosaArriba().compareTo("0") == 0) {
                    vistaCalculadora.setTextoCosaArriba(String.valueOf(botonPulsado));
                } else {
                    vistaCalculadora.setTextoCosaArriba(vistaCalculadora.getTextoCosaArriba() + botonPulsado);
                }
                break;
            case "+":
                operacionesBotones('+');
                break;
            case "-":
                operacionesBotones('-');
                break;
            case "=":
                igual();
                break;
            case "*":
                operacionesBotones('*');
                break;
            case ".":
                String numeroOperacion;
                numeroOperacion = vistaCalculadora.getTextoCosaArriba();
                //Hace que no puedas poner mas de un punto en el numero
                if (!tienePunto) {
                    numeroOperacion = vistaCalculadora.getTextoCosaArriba() + ".";
                    tienePunto = true;
                }
                vistaCalculadora.setTextoCosaArriba(numeroOperacion);
                break;
            case "/":
                operacionesBotones('/');
                break;
            case "<-":
                String numeros;
                int i;
                numeros = vistaCalculadora.getTextoCosaArriba();
                i = numeros.length();
                if (i == 0) {
                    vistaCalculadora.setTextoCosaArriba("0");
                } else {
                    numeros = numeros.substring(0, i - 1);
                    vistaCalculadora.setTextoCosaArriba(numeros);
                }
                break;
            case "C":
                tienePunto = false;
                vistaCalculadora.setTextoCosaArriba("0");
                break;
            case "CE":
                tienePunto = false;
                vistaCalculadora.setTextoCosaArriba("0");
                a = 0;
                b = 0;
                break;
        }
        System.out.println(operadorUsado);
    }

    private void operacionesBotones(char operadorUsado) {
        if(this.operadorUsado!=operadorUsado && this.operadorUsado!=' '){
            vistaCalculadora.setTextoCosaArriba(String.valueOf(b));
        }
        this.operadorUsado = operadorUsado;
        if (a != 0) igual();
        cuenta();
    }

    private void igual() {
        b = Double.parseDouble(vistaCalculadora.getTextoCosaArriba());
        switch (operadorUsado) {
            case '+':
                b = b + a;
                break;
            case '-':
                b = a - b;
                break;
            case '*':
                b = b * a;
                break;
            case '/':
                b = a / b;
        }
        vistaCalculadora.setTextoCosaArriba((String.valueOf(b)));
        a = 0;
        System.out.print(b);
    }

    private void cuenta() {
        tienePunto = false;
        a = Double.parseDouble(vistaCalculadora.getTextoCosaArriba());
        vistaCalculadora.setTextoCosaArriba("0");
    }

    public ActionListener instruction() {

        return this;
    }
}
