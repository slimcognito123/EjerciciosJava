package Servicios;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class TCPService extends Thread {
    private Socket skCliente;

    public TCPService(Socket skCliente) {
        this.skCliente = skCliente;
    }

    @Override
    public void run() {
        try {
            System.out.println("Sirvo al cliente ");
            OutputStream aux = skCliente.getOutputStream();
            DataOutputStream flujo = new DataOutputStream(aux);
            flujo.writeUTF("Hola cliente " );
            skCliente.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
