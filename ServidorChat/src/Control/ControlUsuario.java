package Control;


import Visual.visual;

public class ControlUsuario {
	private String usuario;
	private int puerto;
	private String ip;
	
	public ControlUsuario(String usuario, int puerto, String ip) {
		super();
		this.usuario = usuario;
		this.puerto = puerto;
		this.ip = ip;
	}
	public void conectarse(){
		new visual(usuario,puerto,ip);
		System.out.println("guardamos datos y enviamos a conectar");
		//InterfazChat interfazChat = new InterfazChat();
	}
}
