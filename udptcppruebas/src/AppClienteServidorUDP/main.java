package AppClienteServidorUDP;

public class main {
    public static void main(String[] args) {
        ClienteUDP clienteUDP = new ClienteUDP();
        Thread servidor = new ServidorUDP();
        servidor.start();
        clienteUDP.enviar("holoooo", "127.0.0.1");
        System.out.println("patata :3");
        //System.out.println(new String(clienteUDP.recibir()));
        clienteUDP.enviar("holaaaa", "127.0.0.1");
        // System.out.println(new String(clienteUDP.recibir()));
        clienteUDP.enviar("HoI", "127.0.0.1");
        // System.out.println(new String(clienteUDP.recibir()));
        clienteUDP.enviar("I'm Temmie!", "127.0.0.1");
        // System.out.println(new String(clienteUDP.recibir()));
        // clienteUDP.enviar("HoI I\'m TeMMiE :3","192.168.1.212");
        // System.out.println(new String(clienteUDP.recibir()));
        clienteUDP.cerrar();
    }
}
