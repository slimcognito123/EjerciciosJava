package modelo.DAO;

import beans.Usuario;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Objects;

@Repository(value = "usuarioDAO")
public class UsuarioDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public void insertarUsuario(Usuario usuario){
        entityManager.persist(usuario);
    }

    public boolean comprobarLogin(Usuario usuario){
        Usuario comprobar = getUsuario(usuario.getNombreUsuario());
        if (comprobar!=null && Objects.equals(comprobar.getPassword(), usuario.getPassword())) {
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

    /*private Usuario getUsuario(String nombreUsuario) {
        String query = "Select user FROM Usuario user where user.nombreUsuario=:usuario";
        Query pregunta = entityManager.createQuery(query);
        pregunta.setParameter("usuario", nombreUsuario);
        Usuario comprobar=null;
        try{
            comprobar = (Usuario) pregunta.getSingleResult();
        }catch(Exception e){
            System.out.println("\033[35m no hay usuarios en BD"+e);
        }
        return comprobar;
    }*/

    //funcionan igual ambos getUsuario
    private Usuario getUsuario(String nombreUsuario){
        Usuario comprobar =null;
        try {
            comprobar=entityManager.find(Usuario.class,nombreUsuario);
        }catch (Exception e){
            System.out.println("no hay usuarios");
        }
        return comprobar;
    }
}
