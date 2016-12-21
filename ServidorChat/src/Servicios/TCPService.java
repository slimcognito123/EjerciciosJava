package Servicios;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class TCPService extends Thread {
    private Socket skCliente;
    private String mensajeAEnviar= null;

    public TCPService(Socket skCliente) {
        this.skCliente = skCliente;
    }

    @Override
    public void run() {
        try {
            //System.out.println("Sirvo al cliente "+skCliente.toString());
            OutputStream aux = skCliente.getOutputStream();
            DataOutputStream flujo = new DataOutputStream(aux);
            OutputStreamWriter escritor= new OutputStreamWriter(flujo);
            //System.out.println(mensajeAEnviar);//llega el mensaje correctamente hasta aqui
            if(mensajeAEnviar!= null)escritor.write(mensajeAEnviar);
            skCliente.close();
            mensajeAEnviar=null;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void enviar(String mensajeTotal) {
        this.mensajeAEnviar=mensajeTotal;
    }
}
