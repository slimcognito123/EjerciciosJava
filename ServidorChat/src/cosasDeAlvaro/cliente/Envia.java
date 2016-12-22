package cosasDeAlvaro.cliente;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketException;

        
public class Envia implements Runnable {
    private String usuario; 
    private String ip;
    private int puerto;
    private OutputStream salida;
    private Socket con;
  

    public Envia(String usuario, String ip, int puerto) {
		super();
		this.usuario = usuario;
		this.ip = ip;
		this.puerto = puerto;
		try{
			this.con = new Socket(ip, puerto); //comunicarme con el servidor
			 //Evento que ocurre al escribir en el campo de texto
			String mensaje = "#"+this.usuario+":"+this.ip+":"+this.puerto+"# conectado";
			System.out.println("se procede a enviar el mensaje");
            enviarDatos(mensaje); //se envia el mensaje
       } catch (Exception e){
    	   System.out.println("No se consigue realizar el socket");
    	   System.out.println(e.getMessage());
       }
	}

//enviar objeto a cliente 
   private void enviarDatos(String mensaje){
      try {
         ((ObjectOutputStream) salida).writeObject(this.usuario+">>> " + mensaje);
         salida.flush(); //flush salida a cliente
         System.out.println("Se envia el mensaje>>> " + mensaje);
      } //Fin try
      catch (IOException ioException){ 
    	  System.out.println("Error escribiendo Mensaje");
      } //Fin catch  
      
   } //Fin metodo enviarDatos

   //manipula areaPantalla en el hilo despachador de eventos
   
    public void run() {
         try {
            salida = new ObjectOutputStream(con.getOutputStream());
            salida.flush(); 
        } catch (SocketException ex) {
        } catch (IOException ioException) {
          ioException.printStackTrace();
        } catch (NullPointerException ex) {
        }
    }   
    DataInputStream flujoEntrada;
	DataOutputStream flujoSalida;
	Socket socket;
	
   
} 
