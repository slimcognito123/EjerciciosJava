package AppClienteServidorUDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class ServidorUDP extends Thread {
    DatagramSocket socket = null;

    public ServidorUDP() {
        inicializarShocket();
    }

    private void inicializarShocket() {
        try {
            this.socket = new DatagramSocket(6789);
        } catch (SocketException e1) {
            e1.printStackTrace();
        }
    }

    @Override
    public void run() {
        servir();
    }

    private void servir(){
        while(true) {
            DatagramPacket datagramPacket = recibirRequest();
            responderRequest(datagramPacket);
            System.out.println("servidor: "+new String(datagramPacket.getData()));
        }
    }
    public DatagramPacket recibirRequest(){
        byte[] n = new byte[1000];
        DatagramPacket req = new DatagramPacket(n, n.length);
        try {
            socket.receive(req);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return req;
    }
    public void responderRequest(DatagramPacket req){
        DatagramPacket rep = new DatagramPacket(req.getData(),req.getLength(), req.getAddress(),req.getPort());
        try {
            socket.send(rep);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void cerrar() {
        if (socket != null) socket.close();
    }
}
