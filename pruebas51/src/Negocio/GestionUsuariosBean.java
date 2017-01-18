package Negocio;

import beans.Usuario;
import dao.UsuarioDAOBean;

import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * Created by curso mañana on 18/01/2017.
 */
@Stateless(name = "GestionUsuariosEJB")
public class GestionUsuariosBean implements RemoteGestionUsuariosBean {
    @EJB
    private UsuarioDAOBean usuarioDAO;

    public GestionUsuariosBean() {

    }

    @Override
    public boolean login(String nombre, String pass) {
        Usuario usuario= usuarioDAO.recuperarUsuario(nombre);
        if(nombre.equals("admin")&&pass.equals("admin")){
            return true;
        }else return false;
    }
}
