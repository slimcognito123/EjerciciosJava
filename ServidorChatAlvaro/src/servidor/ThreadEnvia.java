package servidor;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.SocketException;
import java.util.ArrayList;

public class ThreadEnvia implements Runnable {
    private final PrincipalChat main; 
    private DataOutputStream salida;
    private String mensaje;
    private Socket conexion;
    private ArrayList<Socket> listaConexiones = new ArrayList<>();

    public ThreadEnvia(PrincipalChat main){
        this.conexion = conexion;
        this.main = main;
    }
    
   //enviar objeto a cliente 
   private void enviarDatos(String mensaje){
      try {
         salida.writeUTF( mensaje);
         salida.flush(); //flush salida a cliente
         main.mostrarMensaje("Servidor>>> " + mensaje);
      } //Fin try
      catch (IOException ioException){ 
         main.mostrarMensaje("Error escribiendo Mensaje");
      } //Fin catch  
      
   } //Fin methodo enviarDatos

   
    public void run() {
         try {
             PrincipalChat.paralizador.esperar();
             for (Socket conectados : listaConexiones) {
                 System.out.println(conectados.getOutputStream()+"     <-- este es el output al que se envia");
                 if(conectados.getOutputStream()!=null){
                     System.out.println("aqui entro");
                     salida = new DataOutputStream(conectados.getOutputStream());
                     salida.writeUTF(mensaje);
                 }
             }
        } catch (SocketException ex) {
             ex.printStackTrace();
        } catch (IOException ioException) {
          ioException.printStackTrace();
        } catch (NullPointerException ex) {
             ex.printStackTrace();
        }
    }

    public void addCliente(Socket conexion) {
        listaConexiones.add(conexion);
        try {
            System.out.println(conexion.getOutputStream()+"<- se supone que este entra");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
