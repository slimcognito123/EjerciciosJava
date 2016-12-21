package Servicios;

import java.io.*;
import java.net.*;

public class AbrirServidor{
    private static final int PUERTO = 6000;
    private String mensajeServidor = null;

    public AbrirServidor() {
        try {
            ServerSocket skServidor = new ServerSocket(PUERTO);
            System.out.println("Escucho el puerto " + PUERTO);
            while(true){
                Socket skCliente = skServidor.accept(); // Crea objeto
                BufferedReader entrada = new BufferedReader(new InputStreamReader(skCliente.getInputStream()));

                TCPService service = new TCPService(skCliente);
                String mensajeTotal="";
                while((mensajeServidor = entrada.readLine()) != null) //Mientras haya mensajes desde el cliente
                {
                    //Se muestra por pantalla el mensaje recibido
                    System.out.println(mensajeServidor);
                    mensajeTotal+=mensajeServidor;
                }
                service.enviar(mensajeTotal);
                service.start();
            }
            //System.out.println("Clientes Atendidos");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }



}