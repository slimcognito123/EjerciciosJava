package Negocio;
import beans.Usuario;
import dao.UsuarioDAO;
import dao.UsuarioDAOJdbc;;

public class GestionUsuarios {

	UsuarioDAO usuarioDao;
	
	public GestionUsuarios() {
	usuarioDao= new UsuarioDAOJdbc();
	}
	
	public boolean login(String nombre, String pass){
		Usuario u= usuarioDao.recuperarUsuario(nombre);
		if(pass.equals(u.getPassword()))
			return true;
		else
			return false;
	}
	
	public boolean guardarUsuario(String nombre, String pass){
		return usuarioDao.guardarUsuario(new Usuario(nombre,pass));
	}
		
}
