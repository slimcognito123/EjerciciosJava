package Prueba;

import java.io.*;
import java.net.*;

class TCPUSer {
    private static final String HOST = "localhost";
    private static final int Puerto = 6000;

    public TCPUSer() {
        try {
            Socket skCliente = new Socket(HOST, Puerto);
            InputStream aux = skCliente.getInputStream();
            DataInputStream flujo = new DataInputStream(aux);
            System.out.println(flujo.readUTF());
            skCliente.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String args[]) {
        new TCPUSer();
    }
}