package controlador.action;

import beans.Contacto;
import controlador.AgendaController;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ActionModificarDatos extends ActionSupport implements ModelDriven<Contacto> {
    Contacto contacto= new Contacto();

    @Override
    public String execute() throws Exception {
        AgendaController controller = new AgendaController();
        controller.modificarPersona(contacto);
        return SUCCESS;
    }

    @Override
    public Contacto getModel() {
        return new Contacto();
    }
}
