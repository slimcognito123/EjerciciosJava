package servidor;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ThreadRecibe extends Thread {
    private String mensaje; 
    private DataInputStream entrada;
    private Socket cliente;
   
    
   //Inicializar chatServer y configurar GUI
   public ThreadRecibe(Socket cliente){
       this.cliente = cliente;
   }
   
    public void run() {
        try {
            entrada = new DataInputStream(cliente.getInputStream());
        } catch (IOException ex) {
            System.out.println("Error en el hilo ThreadRecibe al recibir la entrada del cliente");
        }
        do { //procesa los mensajes enviados dsd el servidor
            try {//leer el mensaje y mostrarlo 
                mensaje = (String) entrada.readUTF(); //leer nuevo mensaje
                System.out.println(mensaje);
                ThreadEnvia envia = new ThreadEnvia(cliente);
                envia.enviarDatos(mensaje);
            } //fin try
            catch (SocketException ex) {
            }
            catch (EOFException eofException) {
            	mensaje = (String) "Fin de la conexion";
                break;
            } //fin catch
            catch (IOException ex) {
                System.out.println("Error en el ThreadRecibe");
            }

        } while (!mensaje.equals("FINAL")); //Ejecuta hasta que el server escriba FINAL

        /*try {
            //entrada.close(); //cierra input Stream
            //cliente.close(); //cierra el Socket
        } //Fin try
        catch (IOException ioException) {
            ioException.printStackTrace();
        } //fin catch*/
        //System.exit(0);
    } 
} 
