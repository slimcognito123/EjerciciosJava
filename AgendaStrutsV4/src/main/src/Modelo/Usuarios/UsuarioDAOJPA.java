package Modelo.Usuarios;

import Beans.Usuario;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

public class UsuarioDAOJPA {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("AgendaStruts");
    private EntityManager em = emf.createEntityManager();

    public UsuarioDAOJPA() {

    }

    public boolean insertarUsuario(Usuario user) {
        try {
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("\033[36m holi");
            em.close();
            return false;
        }
        return true;
    }

    public boolean buscarUsuarioRepetido(String usuario) {
        String query = "Select user FROM Usuario user where user.nombre=:usuario";
        Query pregunta = em.createQuery(query);
        pregunta.setParameter("usuario", usuario);
        List resultados = null;
        try {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            resultados = pregunta.getResultList();
            System.out.println("\033[35m" + resultados);
            transaction.commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            em.close();
            System.out.println(e);
        }
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
