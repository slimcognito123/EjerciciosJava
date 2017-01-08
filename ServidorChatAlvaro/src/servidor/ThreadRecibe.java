package servidor;

import java.io.*;
import java.net.Socket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ThreadRecibe implements Runnable {
    private final PrincipalChat main;
    private static String mensaje;
    private DataInputStream entrada;
    private Socket cliente;


    //Inicializar chatServer y configurar GUI
    public ThreadRecibe(Socket cliente, PrincipalChat main) {
        this.cliente = cliente;
        this.main = main;
    }

    public static String getMensaje() {
        return mensaje;
    }

    public void mostrarMensaje(String mensaje) {
        main.areaTexto.append(mensaje);
    }

    public void run() {
        try {
            entrada = new DataInputStream(cliente.getInputStream());
        } catch (IOException ex) {
            Logger.getLogger(ThreadRecibe.class.getName()).log(Level.SEVERE, null, ex);
        }
        while (true) {
            //procesa los mensajes enviados dsd el servidor

            try {//leer el mensaje y mostrarlo
                mensaje = entrada.readUTF(); //leer nuevo mensaje
                System.out.println(mensaje);
                PrincipalChat.paralizador.notificar();
                main.mostrarMensaje(entrada.toString());
            } //fin try
            catch (SocketException ex) {
                ex.printStackTrace();
            } catch (EOFException eofException) {
                main.mostrarMensaje("Fin de la conexion");
                break;
            } //fin catch
            catch (IOException ex) {
                Logger.getLogger(ThreadRecibe.class.getName()).log(Level.SEVERE, null, ex);
            }/*

             String mensajeServidor = ;
            try {
                while((mensajeServidor = lector.readLine()) != null) //Mientras haya mensajes desde el cliente
                {
                    //Se muestra por pantalla el mensaje recibido
                    System.out.println(mensajeServidor);
                    main.mostrarMensaje(mensajeServidor);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }*/
            //entrada.close(); //cierra input Stream
            //cliente.close(); //cieraa Socket
        }
    }
}
