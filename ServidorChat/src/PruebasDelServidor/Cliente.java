package PruebasDelServidor;

import java.io.*;
import java.net.*;

public class Cliente extends Thread{
    private static final String HOST = "localhost";
    private static final int Puerto = 6000;
    private Socket skCliente;
    public Cliente() {
        try {
            skCliente = new Socket(HOST, Puerto);
            /*InputStream aux = skCliente.getInputStream();
            DataInputStream flujo = new DataInputStream(aux);
            //System.out.println(flujo.readUTF());*/
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void enviar(String nombre, String mensaje){
        try {
            ObjectOutputStream salida = new ObjectOutputStream(skCliente.getOutputStream());
            salida.write((nombre+": "+mensaje).getBytes());
            salida.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        Cliente cliente=new Cliente();
        cliente.enviar("yo me llamo Ralph", "Corre platanoooo");
    }
}