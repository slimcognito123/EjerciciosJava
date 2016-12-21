package Prueba;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

class TCPServer {
    private static final int PUERTO = 6000;

    public TCPServer() {
        try {
            ServerSocket skServidor = new ServerSocket(PUERTO);
            System.out.println("Escucho el puerto " + PUERTO);
            for (int numCli = 0; numCli < 3; numCli++) {
                Socket skCliente = skServidor.accept(); // Crea objeto
                TCPService service= new TCPService(skCliente,numCli);
                service.start();
            }
            System.out.println("Clientes Atendidos");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] arg) {
        new TCPServer();
    }
}
