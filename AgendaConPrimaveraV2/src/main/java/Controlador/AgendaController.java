package Controlador;

import Beans.Contacto;
import Modelo.Contactos.ContactoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service(value = "controlador")
public class AgendaController {
    @Autowired
    @Qualifier("contactoJPA")
    private ContactoDAO contactoDao;

   /* public AgendaController() {
        inicialize();
    }

    private void inicialize(){
            contactoDao = new FactoryPersonaDAO().comprobarEstadoArchivoConfiguracion();
    }*/
    @Transactional
    public void modificarPersona(Contacto contacto){
        contactoDao.modificarPersona(contacto);
    }
    @Transactional
    public ArrayList<Contacto> recuperarAgendaPorMes(String mes, String usuario) {
        return contactoDao.recuperarTodasLasPersonas(mes,usuario);
    }
    @Transactional
    public void eliminarPersonaid(int id, String user) {
        contactoDao.borrarPersona(id);
    }
    @Transactional
    public Contacto recuperarPersona(int id) {
        return contactoDao.recuperarPersona(id);
    }
    @Transactional
    public void anadirPersonaOnline(Contacto contacto) {
        contactoDao.guardarPersona(contacto);
    }

    @Transactional
    public ArrayList<Contacto> recuperarAgendaCompleta(String usuario) {
        return contactoDao.recuperarTodasLasPersonas(usuario);
    }
}
