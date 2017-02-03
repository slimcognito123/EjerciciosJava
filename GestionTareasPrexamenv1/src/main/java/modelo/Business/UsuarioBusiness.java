package modelo.Business;

import beans.Usuario;
import modelo.DAO.UsuarioDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service(value = "usuarioBusiness")
public class UsuarioBusiness {

    @Autowired
    @Qualifier("usuarioDAO")
    private UsuarioDAO usuarioDAO;

    @Transactional
    public boolean comprobarLogin(Usuario usuario) {
        return usuarioDAO.comprobarLogin(usuario);
    }

    @Transactional
    public void insertarUsuario(Usuario user) {
        usuarioDAO.insertarUsuario(user);
    }

    @Transactional
    public boolean comprobarUsuarioExistente(String usuario) {
        return usuarioDAO.comprobarUsuarioExistente(usuario);
    }
}
