package PruebasDelServidor;

import Servicios.TCPService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Patata kawaii on 21/12/2016.
 */
public class visual {
    private final String nombre;
    private JList list1;
    DefaultListModel model = new DefaultListModel();
    private JTextArea textArea1;
    private JPanel panel1;
    private JButton enviar;

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("visual");
        frame.setContentPane(new visual(args[0]).panel1);
        frame.setSize(600, 400);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
    }

    public visual(String nombre) {
        list1.setModel(model);
        model.addElement("hoi: I'm Temmie");
        model.addElement("hoi: I'm Temmie");
        model.addElement("hoi: I'm Temmie");
        ClienteRecibir clienteRecibir = new ClienteRecibir(model);
        this.nombre = nombre;
        enviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Cliente cliente = new Cliente();
                cliente.enviar(nombre, textArea1.getText());
                textArea1.setText("");
            }
        });
        //clienteRecibir.start();//<- hace que se atasque la app

    }
}
