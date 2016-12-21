package Servicios;

import java.io.*;
import java.net.*;

public class AbrirServidor{
    private static final int PUERTO = 6000;

    public AbrirServidor() {
        try {
            ServerSocket skServidor = new ServerSocket(PUERTO);
            System.out.println("Escucho el puerto " + PUERTO);
            while(true){
                Socket skCliente = skServidor.accept(); // Crea objeto
                TCPService service = new TCPService(skCliente);
                service.start();
            }
            //System.out.println("Clientes Atendidos");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }



}