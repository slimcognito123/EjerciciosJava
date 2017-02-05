package modelo.Business;

import beans.Tarea;
import modelo.DAO.TareaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service(value = "tareaBusiness")
public class TareaBusiness {

    @Autowired
    @Qualifier("tareaDAO")
    private TareaDAO tareaDAO;

    @Transactional
    public void crearTarea(Tarea tarea){
        tareaDAO.crearTarea(tarea);
    }

    @Transactional
    public void actualizarTarea(Tarea tarea){
        tareaDAO.actualizarTarea(tarea);
    }

    @Transactional
    public ArrayList<Tarea>recuperarPorEstado(int estado){
        if(estado==0){
            return tareaDAO.recuperarTareasNoRealizadas();
        }else{
            return tareaDAO.recuperarTareasRealizadas();
        }

    }

    @Transactional
    public ArrayList<Tarea> recuperarTodasLasTareas(){
        return tareaDAO.recuperarTodasLasTareas();
    }

    public Tarea recuperarTarea(int id) {
        return  tareaDAO.recuperarTarea(id);
    }
}
