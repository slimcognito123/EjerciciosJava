import java.net.*;
import java.io.*;

public class UDPServer {
    public static void main(String args[]) {
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket(6789);
            byte[] n = new byte[10000];
            while (true) {
                DatagramPacket req = new
                        DatagramPacket(n, n.length);
                socket.receive(req);
                DatagramPacket rep = new
                        DatagramPacket(req.getData(),
                        req.getLength(), req.getAddress(),
                        req.getPort());
                socket.send(rep);
            }
        } catch (SocketException e) {
            System.out.println("Socket: "+e.getMessage());
        } catch (IOException e) {
            System.out.println("IO: "+e.getMessage());
        } finally {
            if (socket != null) socket.close();
        }
    }
}