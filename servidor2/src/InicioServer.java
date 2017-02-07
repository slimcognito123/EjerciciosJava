


import java.io.IOException;


//Se inicia un Server socket con el puerto por defecto 6000

public class InicioServer {


	private ServidorTCP servidorTCP;
	
	
	public InicioServer(){
		try {
			this.servidorTCP=new ServidorTCP(ServidorTCP.PUERTO);
			this.servidorTCP.start();
			
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new InicioServer();
	}

}
