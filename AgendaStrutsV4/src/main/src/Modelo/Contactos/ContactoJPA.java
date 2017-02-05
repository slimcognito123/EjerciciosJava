package modelo.contactos;

import beans.Contacto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;


public class ContactoJPA implements ContactoDAO {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("AgendaStruts");

    @Override
    public Boolean borrarPersona(int id) {
        EntityManager em = emf.createEntityManager();
        try {

            Contacto contacto = em.find(Contacto.class, id);
            em.getTransaction().begin();
            em.remove(contacto);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.close();
            return false;
        }
        return true;
    }

    @Override
    public void modificarPersona(Contacto contacto) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(contacto);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.close();
            System.out.println("\033[35m" + e);
        }
    }

    @Override
    public ArrayList<Contacto> recuperarTodasLasPersonas(String mes, String usuario) {

        EntityManager em = emf.createEntityManager();

        String query = "Select c FROM Contacto c where MONTH(c.fecha) like :mes and c.user=:usuario";
        Query pregunta = em.createQuery(query);
        pregunta.setParameter("mes", Integer.parseInt(mes));
        pregunta.setParameter("usuario", usuario);
        ArrayList<Contacto> resultados;
        System.out.println("\033[37m" + "pene");
        try {
            resultados = getContactos(pregunta);
        } catch (Exception e) {
            em.close();
            return new ArrayList();
        }
        return resultados;
    }

    @Override
    public ArrayList<Contacto> recuperarTodasLasPersonas(String usuario) {
        EntityManager em = emf.createEntityManager();

        String query = "Select c FROM Contacto c where c.user=:usuario";
        Query pregunta = em.createQuery(query);
        pregunta.setParameter("usuario", usuario);
        ArrayList<Contacto> resultados;
        System.out.println("\033[37m" + "pene");

        try {
            resultados = getContactos(pregunta);
        } catch (Exception e) {
            em.close();
            return new ArrayList();
        }
        return resultados;
    }

    @Override
    public Contacto recuperarPersona(int id) {
        EntityManager em = emf.createEntityManager();
        Contacto contacto;
        try {
            contacto = em.find(Contacto.class, id);
        } catch (Exception e) {
            em.close();
            return null;
        }
        return contacto;
    }

    @Override
    public void guardarPersona(Contacto contacto) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(contacto);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("\033[32m" + e.getStackTrace().toString());
            e.printStackTrace();
            System.out.println("\033[36m");
            em.close();
        }
    }

    private ArrayList<Contacto> getContactos(Query pregunta) {
        ArrayList<Contacto> resultados;
        System.out.println("\033[38m" + pregunta.getResultList() + " holiwis :3");
        resultados = (ArrayList<Contacto>) pregunta.getResultList();
        return resultados;
    }
}
