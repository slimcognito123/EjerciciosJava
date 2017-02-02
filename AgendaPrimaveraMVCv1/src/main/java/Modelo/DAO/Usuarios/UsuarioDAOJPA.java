package Modelo.DAO.Usuarios;

import Beans.Usuario;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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
        if (resultados.size()==0) {
            System.out.println("\033[34m no tengo usuariooooos");
            return false;
        }
        return true;
    }

    public boolean comprobarUser(String user, String pass) {
        String query = "Select user FROM Beans.Usuario user where user.nombre=:usuario";
        Query pregunta = em.createQuery(query);
        pregunta.setParameter("usuario", user);
        Usuario comprobar = (Usuario) pregunta.getSingleResult();
        System.out.println(comprobar);
//        System.out.println(Objects.equals(comprobar.get(0).getPassword(), pass));
        if (comprobar!=null && Objects.equals(comprobar.getPassword(), pass)) {
            return true;
        } else {
            return false;
        }
    }
}
