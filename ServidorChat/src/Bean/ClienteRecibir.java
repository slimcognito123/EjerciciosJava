package Bean;

import javax.swing.*;
import java.io.*;
import java.net.Socket;

/**
 * Created by Patata kawaii on 21/12/2016.
 */
public class ClienteRecibir extends Thread{
    DefaultListModel model;
    String HOST = "192.168.1.92";
    int Puerto = 6555;

    public ClienteRecibir(DefaultListModel model) {
        this.model = model;
    }

    public ClienteRecibir(DefaultListModel model, int puerto, String ip) {
        this.model = model;
        this.HOST=ip;
        this.Puerto=puerto;
    }

    @Override
    public void run() {
        Socket skCliente = null;
        try {
            skCliente = new Socket(HOST, Puerto);
        } catch (IOException e) {
            e.printStackTrace();
        }
        while(true){
            try {
                InputStream aux = skCliente.getInputStream();
                DataInputStream flujo = new DataInputStream(aux);
                BufferedReader lector = new BufferedReader(new InputStreamReader(flujo));
                String mensajeServidor;
                while((mensajeServidor = lector.readLine()) != null) //Mientras haya mensajes desde el cliente
                {
                    //Se muestra por pantalla el mensaje recibido
                    System.out.println(mensajeServidor);
                    model.addElement(mensajeServidor);
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
