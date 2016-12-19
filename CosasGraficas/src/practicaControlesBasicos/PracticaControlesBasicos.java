package practicaControlesBasicos;

import javax.swing.*;
import java.awt.*;


public class PracticaControlesBasicos {
    private JFrame frame = new JFrame("MyFrame");
    private JPanel panel;
    private JLabel etiquetaNombre;
    private JTextField campoNombre;
    private JLabel etiquetaEdad;
    private JCheckBox botonEdad;
    private JLabel etiquetaNIF;
    private JTextField campoNif;
    private JLabel EstadoCivil;
    private JLabel etiquetaSoltero;
    private JLabel etiquetaCasado;
    private JRadioButton botonSoltero;
    private JRadioButton botonCasado;
    public PracticaControlesBasicos() {
        panel = new JPanel();
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(3);
        panel.setSize(400, 300);

        panel.setBackground(new Color(51, 255, 255));
        frame.setContentPane(panel);
        inicialize();

        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | UnsupportedLookAndFeelException | IllegalAccessException e) {
            e.printStackTrace();
        }
        frame.setVisible(true);
    }

    private void inicialize() {
        etiquetaNombre= new JLabel("nombre: ");
        campoNombre= new JTextField();
        etiquetaEdad = new JLabel("soy mayor de edad");
        botonEdad = new JCheckBox();
        etiquetaNIF= new JLabel("NIF: ");
        campoNif = new JTextField();
        EstadoCivil= new JLabel("estado civil:");
        etiquetaSoltero = new JLabel("Soltero:");
        etiquetaCasado = new JLabel("Casado: ");
        botonSoltero = new JRadioButton();
        botonCasado = new JRadioButton();
        ButtonGroup grupo = new ButtonGroup();
        botonCasado.setBackground(new Color(51, 255, 255));
        botonSoltero.setBackground(new Color(51, 255, 255));
        botonEdad.setBackground(new Color(51, 255, 255));
        grupo.add(botonSoltero);
        grupo.add(botonCasado);
        posicionamiento();
        introducirEnFrame();
    }

    private void posicionamiento() {
        frame.setLayout(new CardLayout());
    }

    private void introducirEnFrame() {
        panel.add(etiquetaNombre);
        panel.add(campoNombre);
        panel.add(etiquetaEdad);
        panel.add(botonEdad);
        panel.add(etiquetaNIF);
        panel.add(campoNif);
        panel.add(EstadoCivil);
        panel.add(etiquetaCasado);
        panel.add(etiquetaSoltero);
        panel.add(botonSoltero);
        panel.add(botonCasado);
    }

    /*private void posicionamiento() {
        frame.setLayout(null);
        etiquetaNombre.setBounds(10,10,200,40);
        campoNombre.setBounds(80,10,200,40);
        etiquetaEdad.setBounds(10,50,200,40);
        botonEdad.setBounds(150,50,20,40);
        etiquetaNIF.setBounds(10,90,200,40);
        campoNif.setBounds(80,90,200,40);
        EstadoCivil.setBounds(10,120,200,40);
        etiquetaSoltero.setBounds(10,160,200,40);
        etiquetaCasado.setBounds(10,200,200,40);
        botonSoltero.setBounds(80,160,20,40);
        botonCasado.setBounds(80,200,20,40);
    }*/

    public static void main(String[] args){
        new PracticaControlesBasicos();
    }

}
