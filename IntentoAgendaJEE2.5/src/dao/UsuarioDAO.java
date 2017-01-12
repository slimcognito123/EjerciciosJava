package dao;

import beans.Usuario;

public interface UsuarioDAO {

	public boolean guardarUsuario(Usuario u);
	public Usuario recuperarUsuario(String nombre);
}
