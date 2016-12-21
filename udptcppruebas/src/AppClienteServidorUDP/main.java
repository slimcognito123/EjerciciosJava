package AppClienteServidorUDP;

import static java.lang.Thread.sleep;

public class main {
    public static void main(String[] args) {
        ClienteUDP clienteUDP = new ClienteUDP();
        Thread servidor = new ServidorUDP();
        servidor.start();
        try {
            sleep(1000);
            clienteUDP.enviar("holoooo","Slimcognito: ","192.168.1.212");
            sleep(2000);
            System.out.println(new String(clienteUDP.recibir()));
            clienteUDP.enviar("holaaaa","Slimcognito: ", "192.168.1.212");
            sleep(2000);
            System.out.println(new String(clienteUDP.recibir()));
            clienteUDP.enviar("HoI","Slimcognito:", "192.168.1.212");
            sleep(2000);
            System.out.println(new String(clienteUDP.recibir()));
            clienteUDP.enviar("I'm Temmie!","Slimcognito:", "192.168.1.212");
            sleep(2000);
            System.out.println(new String(clienteUDP.recibir()));
            clienteUDP.enviar("HoI I\'m TeMMiE :3","Slimcognito: ", "192.168.1.212");
            // System.out.println(new String(clienteUDP.recibir()));
        } catch (Exception e) {

        }

        clienteUDP.cerrar();
    }
}
