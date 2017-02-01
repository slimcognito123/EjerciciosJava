package Modelo.Business;

import Beans.Usuario;
import Modelo.DAO.Usuarios.UsuarioDAOJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service(value = "usuarioBusiness")
public class UsuarioBusiness {

    @Autowired
    @Qualifier("usuarioDAO")
    private UsuarioDAOJPA usuarioDAOJPA;

    @Transactional
    public boolean comprobarUser(String user, String pass) {
        return usuarioDAOJPA.comprobarUser(user,pass);
    }
    @Transactional
    public void insertarUsuario(Usuario user) {
        usuarioDAOJPA.insertarUsuario(user);
    }
    @Transactional
    public boolean buscarUsuarioRepetido(String usuario) {
        return usuarioDAOJPA.buscarUsuarioRepetido(usuario);
    }
}
