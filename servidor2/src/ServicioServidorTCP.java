
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

public class ServicioServidorTCP extends Thread {

	DataInputStream flujoEntrada;
	DataOutputStream flujoSalida;
	Socket socket;
	ArrayList<Socket> listaUsuarios;
	
	
	
	public ServicioServidorTCP(Socket socket, ArrayList<Socket> listaUsuarios) throws IOException {
		this.socket = socket;
		flujoEntrada = new DataInputStream( socket.getInputStream() );
		//flujoSalida = new DataOutputStream( socket.getOutputStream());
		this.listaUsuarios=listaUsuarios;
	}
	
	//Recibe un flujo de entrada de un cliente y lo devuelve a todos los clientes de la lista. En caso de que de error se muestra usuario desconectado por consola, se cierra el socket y termina la aplicacion.
	
	public void run(){
		
		try{
			while(true){
				String request = recibirRequest();
				contestarRequest(request);
			}
		}
		catch (Exception e) {
			System.err.println("Usuario conectado ");
		}
		finally {
			cerrar();
		}	
	}
	
	
	//Modificado para contestar a todos los usuarios de una lista. Si hay error suele ser porque el un usuario se ha desconectado por lo que se le elimina de la lista
	public void contestarRequest(String mensaje){ 
		try{
			for (Socket socket : listaUsuarios) {
				flujoSalida = new DataOutputStream( socket.getOutputStream());
				flujoSalida.writeUTF(mensaje);
			}
			
		}
		
		catch (IOException e) {
			for (Socket socket : listaUsuarios) {
				if(socket==this.socket){
					listaUsuarios.remove(socket);
					break;
				}
			}
		}
	}
	
	public String recibirRequest(){
		try {
			return flujoEntrada.readUTF();
		} 
		
		catch (IOException e) {
			for (Socket socket : listaUsuarios) {
				if(socket==this.socket){
					listaUsuarios.remove(socket);
					break;
				}
			}
		}
		return null;
	}
	
	public void cerrar(){
		try{
			socket.close();
		}catch (IOException e) {
			System.err.println("Error al cerrar el socket tcp en cliente"+ e.getMessage());		}
		}
	}

