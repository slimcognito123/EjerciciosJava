package cosasDeAlvaro.cliente;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.DefaultListModel;
import javax.swing.JList;


public class ThreadRecibe implements Runnable {
    private String mensaje;
    private Socket cliente;
    private ObjectInputStream entrada;
    private String usuario;
    private DefaultListModel modelo;
    
   //Inicializar chatServer y configurar GUI
   public ThreadRecibe(Socket cliente, String usuario, String mensaje,DefaultListModel modelo){
       this.cliente = cliente;
       this.usuario = usuario;
       this.mensaje = mensaje;
       this.modelo = modelo;
   }  

    public void mostrarMensaje(String mensaje) {
    	
    	modelo.addElement(mensaje);
    	
        //main.areaTexto.append(mensaje);
    	
    }
   
    public void run() {
        try {
            entrada = new ObjectInputStream(cliente.getInputStream());
        } catch (IOException ex) {
            Logger.getLogger(ThreadRecibe.class.getName()).log(Level.SEVERE, null, ex);
        }
        do { //procesa los mensajes enviados desde el servidor
            try {//leer el mensaje y mostrarlo 
                mensaje = (String) entrada.readObject(); //leer nuevo mensaje
                mostrarMensaje(mensaje);
            } //fin try
            catch (SocketException ex) {
            }
            catch (EOFException eofException) {
            	mostrarMensaje("Fin de la conexion");
                break;
            } //fin catch
            catch (IOException ex) {
                Logger.getLogger(ThreadRecibe.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException classNotFoundException) {
                mostrarMensaje("Objeto desconocido");
            } //fin catch               

        } while (!mensaje.equals("Cliente>>> TERMINATE")); //Ejecuta hasta que el server escriba TERMINATE

        try {
            entrada.close(); //cierra entrada Stream
            cliente.close(); //cierra Socket
        } //Fin try
        catch (IOException ioException) {
            ioException.printStackTrace();
        } //fin catch

        mostrarMensaje("Fin de la conexion");
        System.exit(0);
    }    
} 
