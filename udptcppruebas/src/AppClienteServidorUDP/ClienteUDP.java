package AppClienteServidorUDP;

import java.io.IOException;
import java.net.*;

public class ClienteUDP {
    public static final int PUERTO = 6789;
    private DatagramSocket socket;


    public ClienteUDP() {
        inicializarShocket();
    }

    private void inicializarShocket() {
        try {
            socket = new DatagramSocket();
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    public void enviar(String mensaje, String hostNumber) {
        byte[] m = mensaje.getBytes();
        InetAddress host;
        try {
            host = InetAddress.getByName(hostNumber);
            DatagramPacket req = new DatagramPacket(m, mensaje.length(), host, PUERTO);
            socket.send(req);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    public byte[] recibir(){
        byte[] n = new byte[1000];
        DatagramPacket rep = new DatagramPacket(n, n.length);
        try {
            socket.receive(rep);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rep.getData();
    }

    protected void cerrar() {
        if (socket != null) socket.close();
    }
}
