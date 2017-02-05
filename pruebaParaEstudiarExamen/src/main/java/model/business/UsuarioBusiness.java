package model.business;

import beans.Usuario;
import model.DAO.UsuarioDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by Patata kawaii on 05/02/2017.
 */
@Service(value = "usuarioBusiness")
public class UsuarioBusiness {
    @Autowired
    @Qualifier("usuarioDAO")
    UsuarioDAO usuarioDAO;

    public boolean comprobarUsuarioExistente(String nombreUsuario) {
        return false;
    }

    public void insertarUsuario(Usuario usuario) {

    }

    public boolean comprobarLogin(Usuario usuario) {


    }
}
