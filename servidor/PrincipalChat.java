package servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.*;

public class PrincipalChat extends JFrame{
    public JTextField campoTexto; //Para mostrar mensajes de los usuarios
    public JTextArea areaTexto; //Para ingresar mensaje a enviar
    private static ServerSocket servidor; //
    private static int puerto=6555;
    private static Socket conexion; //Socket para conectarse con el cliente
    private static String ip = "127.0.0.1"; //ip a la cual se conecta

    public static void main(String[] args) throws IOException {
 
        try {
            
        	servidor = new ServerSocket(puerto, 100);
            //Bucle infinito para esperar conexiones de los clientes
            while (true){
                try {
                	
                    conexion = servidor.accept(); //Permite al servidor aceptar conexiones        

                    //main.mostrarMensaje("Conexion Establecida");
                    //main.mostrarMensaje("Conectado a : " + conexion.getInetAddress().getHostName());

                    //Ejecucion de los threads
                    ThreadRecibe recibe = new ThreadRecibe(conexion); //client
                    recibe.start();
                } catch (IOException ex) {
                    System.out.println("Error en los hilos del servidor");
                }
            }
        }
        finally {
        }
    }
}
