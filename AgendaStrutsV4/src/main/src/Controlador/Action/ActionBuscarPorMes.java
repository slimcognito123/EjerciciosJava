package controlador.action;

import beans.Contacto;
import controlador.AgendaController;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Objects;

public class ActionBuscarPorMes extends ActionSupport implements ModelDriven<Contacto> {

    private AgendaController agendaController = new AgendaController();
    @Override
    public String execute() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpSession session = request.getSession(false);
        String usuario = (String) session.getAttribute("user");
        String mes = request.getParameter("mes");
        ArrayList<Contacto> list;
        if(request.getParameter("mes")==null|| Objects.equals(request.getParameter("mes"), "%")) list= agendaController.recuperarAgendaCompleta(usuario);
        else list= agendaController.recuperarAgendaPorMes(mes,usuario);
        return SUCCESS;
    }

    @Override
    public Contacto getModel() {
        return new Contacto();
    }
}
