package dao;

import beans.Usuario;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by curso mañana on 18/01/2017.
 */
@Stateless(name = "UsuarioDAOEJB")
@LocalBean
public class UsuarioDAOBean implements UsarioDAOBeanLocal {
    @PersistenceContext(unitName = "LoginEJB")
    EntityManager entityManager;
    public UsuarioDAOBean() {
    }

    @Override
    public Usuario recuperarUsuario(String name) {
        Usuario usuario= entityManager.find(Usuario.class,name);
        return usuario;
    }
}
