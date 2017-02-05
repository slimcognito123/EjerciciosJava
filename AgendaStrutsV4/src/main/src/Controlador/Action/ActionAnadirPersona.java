package controlador.action;

import beans.Contacto;
import controlador.AgendaController;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ActionAnadirPersona extends ActionSupport implements ModelDriven<Contacto> {
    private Contacto contacto = new Contacto();

    @Override
    public String execute() throws Exception {
        AgendaController controller = new AgendaController();
        controller.anadirPersonaOnline(contacto);
        return SUCCESS;
    }

    @Override
    public Contacto getModel() {
        Contacto model = new Contacto();
        System.out.println("holi "+model);
        return model;
    }
}
