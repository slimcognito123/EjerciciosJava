
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;


public class ServidorTCP extends Thread{
	public static final int PUERTO=6555;
	ServerSocket serverSocket;
	ArrayList<Socket> listaUsuarios;

	
	public ServidorTCP(int puerto) throws IOException{
		this.serverSocket = new ServerSocket(PUERTO);
		listaUsuarios=new ArrayList<>();
	}
	
	public void run(){
		servir();
	}
	
	//El servidor acepta peticiones y crea servicios por cada peticion.
	
	public void servir(){
		
		while(true){
			try {
				Socket socket = serverSocket.accept(); //Recibe una peticion y guarda el socket
				listaUsuarios.add(socket); //Añade los sockets a una lista
				ServicioServidorTCP servicio = new ServicioServidorTCP(socket,listaUsuarios); //Se crea un nuevo Servicio servidor y se le pasa la lista de usuarios
				servicio.start();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}
