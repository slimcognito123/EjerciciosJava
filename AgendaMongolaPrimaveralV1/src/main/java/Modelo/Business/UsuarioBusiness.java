package Modelo.Business;

import Beans.Usuario;
import Modelo.DAO.Usuarios.UsuarioDAOMongolo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service(value = "usuarioBusiness")
public class UsuarioBusiness {

    private UsuarioDAOMongolo usuarioDAO= new UsuarioDAOMongolo();

    @Transactional
    public boolean comprobarUser(String user, String pass) {
        return usuarioDAO.comprobarUser(user,pass);
    }
    @Transactional
    public void insertarUsuario(Usuario user) {
        usuarioDAO.insertarUsuario(user);
    }
    @Transactional
    public boolean buscarUsuarioRepetido(String usuario) {
        return usuarioDAO.buscarUsuarioRepetido(usuario);
    }
}
