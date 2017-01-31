package Modelo.Usuarios;

import Beans.Usuario;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Repository(value = "usuarioDAO")
public class UsuarioDAOJPA {

    @PersistenceContext
    private EntityManager em;

    public void insertarUsuario(Usuario user) {
            em.persist(user);
    }


    public boolean buscarUsuarioRepetido(String usuario) {
        String query = "Select user FROM Usuario user where user.nombre=:usuario";
        Query pregunta = em.createQuery(query);
        pregunta.setParameter("usuario", usuario);
        List resultados = null;
            resultados = pregunta.getResultList();
            System.out.println("\033[35m" + resultados);
        if (resultados != null) {
            return false;
        }
        return true;
    }

    public boolean comprobarUser(String user, String pass) {
        String query = "Select user FROM Usuario user where user.nombre=:usuario";
        Query pregunta = em.createQuery(query);
        pregunta.setParameter("usuario", user);
        List<Usuario> comprobar = pregunta.getResultList();
        System.out.println(comprobar);
        if (comprobar != null && Objects.equals(comprobar.get(0).getPassword(), pass)) {
            return true;
        } else {
            return false;
        }
    }
}
