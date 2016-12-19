package cosas;

import javax.swing.*;

public class Prueba {
    private JTextField textoNombre;
    private JPanel panel1;
    private JCheckBox mayorDeEdadCheckBox;
    private JRadioButton felizRadioButton;
    private JRadioButton casadoRadioButton;
    private JRadioButton viudoRadioButton;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Prueba");
        frame.setContentPane(new Prueba().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
