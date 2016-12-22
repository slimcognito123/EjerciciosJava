package PruebasDelServidor;

import java.io.*;
import java.net.*;

public class Cliente extends Thread {
    private String HOST = "192.168.1.92";
    private int Puerto = 6555;
    private Socket skCliente;
    private DataOutputStream salidaServidor;

    public Cliente(int puerto, String ip) {
        try {
            this.Puerto=puerto;
            this.HOST=ip;
            skCliente = new Socket(HOST, Puerto);
            InputStream aux = skCliente.getInputStream();
            DataInputStream flujo = new DataInputStream(aux);
            //System.out.println(flujo.readUTF());
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }

    public void enviar(String nombre, String mensaje) {
        try {
            /*ObjectOutputStream salida = new ObjectOutputStream(skCliente.getOutputStream());
            salida.write((nombre+": "+mensaje).getBytes());
            salida.flush();*/
            salidaServidor = new DataOutputStream(skCliente.getOutputStream());

            //Se escribe en el servidor usando su flujo de datos
            salidaServidor.writeUTF(nombre + ": " + mensaje);

            skCliente.close();//Fin de la conexión

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Cliente cliente = new Cliente(Integer.parseInt(args[0]), args[1]);
        cliente.enviar("yo me llamo Ralph", "Corre platanoooo");

    }
}