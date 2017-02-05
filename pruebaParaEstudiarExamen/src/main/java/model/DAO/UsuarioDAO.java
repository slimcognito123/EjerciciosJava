package model.DAO;

import beans.Usuario;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Objects;

/**
 * Created by Patata kawaii on 05/02/2017.
 */

@Repository(value = "usuarioDAO")
public class UsuarioDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public void insertarUsuario(Usuario usuario){
        entityManager.persist(usuario);
    }

    public boolean comprobarLogin(Usuario usuario){
        Usuario comprobar = getUsuario(usuario.getNombreUsuario());
        if (comprobar!=null && Objects.equals(comprobar.getContrasena(), usuario.getContrasena())) {
            return true;
        } else {
            return false;
        }
    }

    public boolean comprobarUsuarioExistente(String nombreUsuario){
        Usuario comprobar = getUsuario(nombreUsuario);
        if (comprobar!=null) {
            return true;
        }
        return false;
    }

    private Usuario getUsuario(String nombreUsuario) {
        Usuario comprobar=null;
        try{
            comprobar = entityManager.find(Usuario.class,nombreUsuario);
        }catch(Exception e){
            System.out.println("\033[35m no hay usuarios en BD"+e);
        }
        return comprobar;
    }
}
