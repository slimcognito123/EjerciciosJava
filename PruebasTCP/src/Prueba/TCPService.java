package Prueba;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class TCPService extends Thread {
    private Socket skCliente;
    private int numCli;

    public TCPService(Socket skCliente, int numCli) {
        this.skCliente = skCliente;
        this.numCli = numCli;
    }

    @Override
    public void run() {
        try {
            System.out.println("Sirvo al cliente " + numCli);
            OutputStream aux = skCliente.getOutputStream();
            DataOutputStream flujo = new DataOutputStream(aux);
            flujo.writeUTF("Hola cliente " + numCli);
            skCliente.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
