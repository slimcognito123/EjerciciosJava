package Visual;

import Bean.Cliente;
import Bean.ClienteRecibir;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Patata kawaii on 21/12/2016.
 */
public class visual {
    private final String nombre;
    private final int puerto;
    private final String ip;
    private JList list1;
    DefaultListModel model = new DefaultListModel();
    private JTextArea textArea1;
    private JPanel panel1;
    private JButton enviar;

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

   /* public static void main(String[] args) {
        JFrame frame = new JFrame("visual");
        frame.setContentPane(this.panel1);
        frame.setSize(600, 400);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
    }*/

    public visual(String nombre,int puerto, String ip) {
        JFrame frame = new JFrame("visual");
        frame.setContentPane(this.panel1);
        frame.setSize(600, 400);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.pack();
        list1.setModel(model);
        model.addElement("Te has unido al chat\n");
        ClienteRecibir clienteRecibir = new ClienteRecibir(model,puerto,ip);
        this.nombre = nombre;
        this.puerto=puerto;
        this.ip=ip;
        enviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Cliente cliente = new Cliente(puerto,ip);
                cliente.enviar(nombre, textArea1.getText()+"\n");
                textArea1.setText("");
            }
        });
        clienteRecibir.start();//<- hace que se atasque la app
        frame.setVisible(true);
    }
}
