package modelo.DAO;

import beans.Tarea;
import beans.Usuario;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;


@Repository(value = "tareaDAO")
public class TareaDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public void crearTarea(Tarea tarea){
        entityManager.persist(tarea);
    }

    public void actualizarTarea(Tarea tarea){
        entityManager.merge(tarea);
    }

    public ArrayList<Tarea> recuperarTareasNoRealizadas(){
        String query = "Select tarea FROM Tarea tarea where tarea.realizada=0";
        Query pregunta = entityManager.createQuery(query);
        return getTareas(pregunta);
    }

    public ArrayList<Tarea> recuperarTareasRealizadas() {
        String query = "Select tarea FROM Tarea tarea where tarea.realizada=1";
        Query pregunta = entityManager.createQuery(query);
        return getTareas(pregunta);
    }

    public ArrayList<Tarea> recuperarTodasLasTareas() {
        String query = "Select tarea FROM Tarea tarea";
        Query pregunta = entityManager.createQuery(query);
        return getTareas(pregunta);
    }

    private ArrayList<Tarea> getTareas(Query pregunta) {
        ArrayList<Tarea> resultados;
        try {
            resultados = (ArrayList<Tarea>) pregunta.getResultList();
        } catch (Exception e) {
            return new ArrayList<>();
        }
        return resultados;
    }

    /*public Tarea recuperarTarea(int id) {
        String query = "Select tarea FROM beans.Tarea tarea where tarea.idTarea=:id";
        Query pregunta = entityManager.createQuery(query);
        pregunta.setParameter("id", id);
        return(Tarea) pregunta.getSingleResult();
    }*/
    public Tarea recuperarTarea(int idTarea){
        return entityManager.find(Tarea.class,idTarea);
    }
}