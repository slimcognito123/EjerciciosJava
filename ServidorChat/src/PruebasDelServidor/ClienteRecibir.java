package PruebasDelServidor;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Created by Patata kawaii on 21/12/2016.
 */
public class ClienteRecibir extends Thread{
    DefaultListModel model;

    public ClienteRecibir(DefaultListModel model) {
        this.model = model;
    }

    @Override
    public void run() {
        String HOST = "localhost";
        int Puerto = 6000;
        while(true){
            try {
                Socket skCliente = new Socket(HOST, Puerto);
                InputStream aux = skCliente.getInputStream();
                DataInputStream flujo = new DataInputStream(aux);
                BufferedReader lector = new BufferedReader(new InputStreamReader(flujo));
                String mensajeServidor;
                while((mensajeServidor = lector.readLine()) != null) //Mientras haya mensajes desde el cliente
                {
                    //Se muestra por pantalla el mensaje recibido
                    System.out.println(mensajeServidor);
                    System.out.println(lector);
                }
                model.addElement(mensajeServidor);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
