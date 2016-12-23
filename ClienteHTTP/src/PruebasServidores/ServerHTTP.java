package PruebasServidores;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ServerHTTP {
    DataInputStream entrada;
    DataOutputStream salida;
    public ServerHTTP() {
        String peticion;
        String cad = "";
        byte datosBytes[] = new byte[256];
        int leido = 0;
        try {
            Socket conexion = new Socket("localhost", 80);
            entrada = new DataInputStream(conexion.getInputStream());
            salida= new DataOutputStream(conexion.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void respuesta(){
        try {
            if(entrada.read()==Integer.parseInt("/index.html")) {
                String respuesta = "<html>; <body>; <h1>Hola que tal!</h1> </body> </html>;";
                salida.write(Integer.parseInt(respuesta));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
