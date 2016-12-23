package PruebasServidores;

import cliente.ClienteHttp;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerHTTP2ElHttpContraataca {
    public ServerHTTP2ElHttpContraataca() {
        String mostrado;
        DataOutputStream salida;
        DataInputStream entrada;
        String cad = "";
        byte datosBytes[] = new byte[1000];
        int leido = 0;
        try {
            ServerSocket conexion = new ServerSocket(1234, 80);
            while (true) {
                System.out.println("Conectando"); /*Enviamos lo que envía el navegador Internet Explorer al pedir una página*/
                mostrado = getPeticion();
                Socket cliente = conexion.accept();
                salida = new DataOutputStream(cliente.getOutputStream());
                String httpResponse = "HTTP/1.1 200 OK\r\n\r\n";
                cliente.getOutputStream().write(httpResponse.getBytes("UTF-8"));
                salida.write(mostrado.getBytes()); //Vemos lo que nos envía el Servidor
               // entrada = new DataInputStream(cliente.getInputStream());
                InputStreamReader isr =  new InputStreamReader(cliente.getInputStream());
                BufferedReader reader = new BufferedReader(isr);
                String line = reader.readLine();
                while (!line.isEmpty()) {
                    System.out.println(line);
                    line = reader.readLine();
                }
                //leido = entrada.read(datosBytes, 0, 1000);
                //if (leido > 0) System.out.println(new String(datosBytes, 0, (leido - 1)));
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String getPeticion() {
        String peticion;
        peticion = "GET /index.html HTTP/1.1 200 OK\n";
        peticion += "Accept: */*\n";
        peticion += "Accept-Language: es\n";
        peticion += "Accept-Encoding: gzip, deflate\n";
        peticion += "User-Agent: Mozilla/4.0 (compatible; MSIE 5.01; Windows NT)\n";
        peticion += "Host: 127.0.0.1\n";
        peticion += "Connection: Keep-Alive\n\n";
        peticion += "<!DOCTYPE html><html> <body> <h1>Hola que tal!</h1> </body> </html>";
        return peticion;
    }

    public static void main(String args[]) {
        ServerHTTP2ElHttpContraataca s = new ServerHTTP2ElHttpContraataca();
    }
}
