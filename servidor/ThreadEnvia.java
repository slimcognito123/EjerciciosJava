package servidor;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.SocketException;
        
public class ThreadEnvia {
    private DataOutputStream salida;
    private String mensaje;
    private Socket conexion; 
   
    public ThreadEnvia(Socket conexion){
        this.conexion = conexion;
    } 
    
   //enviar objeto a cliente 
   void enviarDatos(String mensaje){
      try {
    	  salida = new DataOutputStream(conexion.getOutputStream());
          salida.writeUTF(mensaje);
         //salida.writeUTF(mensaje);
         //salida.flush(); //flush salida a cliente
         
      } //Fin try
      catch (IOException ioException){ 
         System.out.println("Error escribiendo Mensaje");
      } catch (Exception e){
    	  e.printStackTrace();
    	  //Fin catch  
      }
      
   } //Fin metodo enviarDatos

   
    public void run() {
         try {
            salida = new DataOutputStream(conexion.getOutputStream());
            salida.flush(); 
        } catch (SocketException ex) {
        } catch (IOException ioException) {
          ioException.printStackTrace();
        } catch (NullPointerException ex) {
        }
    }   
   
} 
