package cosasDeAlvaro.cliente;

import javax.swing.JList;

public class ConexionUsuario {
	public void conectar(String usuario,String ip,int puerto){
		Envia envia = new Envia(usuario, ip, puerto);
	}
	public void creacionUsuario(){
		
	}
}
