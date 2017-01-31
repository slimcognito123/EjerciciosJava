package Modelo.Contactos;

import Beans.Contacto;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.ArrayList;

@Repository(value = "contactoJPA")
public class ContactoJPA implements ContactoDAO {
    @PersistenceContext
    private EntityManager em;

    @Override
    public Boolean borrarPersona(int id) {


        Contacto contacto = em.find(Contacto.class, id);

        em.remove(contacto);

        return true;
    }

    @Override
    public void modificarPersona(Contacto contacto) {
        em.merge(contacto);
    }

    @Override
    public ArrayList<Contacto> recuperarTodasLasPersonas(String mes, String usuario) {

        String query = "Select c FROM Contacto c where MONTH(c.fecha) like :mes and c.user=:usuario";
        Query pregunta = em.createQuery(query);
        pregunta.setParameter("mes", Integer.parseInt(mes));
        pregunta.setParameter("usuario", usuario);
        ArrayList<Contacto> resultados;
        System.out.println("\033[37m" + "pene");
        try {
            resultados = getContactos(pregunta);
        } catch (Exception e) {
            return new ArrayList<>();
        }
        return resultados;
    }



    @Override
    public Contacto recuperarPersona(int id) {
        Contacto contacto;
            contacto = em.find(Contacto.class, id);
        return contacto;
    }

    @Override
    public void guardarPersona(Contacto contacto) {
            em.persist(contacto);
    }

    @Override
    public ArrayList<Contacto> recuperarTodasLasPersonas(String usuario) {
        String query = "Select c FROM Beans.Contacto c where c.user=:usuario";
        Query pregunta = em.createQuery(query);
        pregunta.setParameter("usuario", usuario);
        ArrayList<Contacto> resultados;
        System.out.println("\033[37m" + "pene");

        try {
            resultados = getContactos(pregunta);
        } catch (Exception e) {
            return new ArrayList<>();
        }
        return resultados;
    }

    private ArrayList<Contacto> getContactos(Query pregunta) {
        ArrayList<Contacto> resultados;
        System.out.println("\033[38m" + pregunta.getResultList() + " holiwis :3");
        resultados = (ArrayList<Contacto>) pregunta.getResultList();
        return resultados;
    }
}
