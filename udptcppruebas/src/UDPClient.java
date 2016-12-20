import java.net.*;
import java.io.*;

public class UDPClient {
    public static void main(String args[]) {
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket();
            byte[] m = args[0].getBytes();
            InetAddress host = InetAddress.getByName(args[1]);
            int port = 6789;
            DatagramPacket req = new DatagramPacket(m,args[0].length(), host, port);
            socket.send(req);
            byte[] n = new byte[10000];
            DatagramPacket rep = new DatagramPacket(n, n.length);
            socket.receive(rep);
            System.out.println("Received " + new String(rep.getData()));
        } catch (SocketException e) {
            System.out.println("Socket: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO: " + e.getMessage());
        } finally {
            if (socket != null) socket.close();
        }
    }
}