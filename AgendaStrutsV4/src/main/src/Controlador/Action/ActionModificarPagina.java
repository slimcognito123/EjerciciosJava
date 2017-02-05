package controlador.action;

import beans.Contacto;
import controlador.AgendaController;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;

public class ActionModificarPagina extends ActionSupport{
    @Override
    public String execute() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        AgendaController agendaController = new AgendaController();
        Contacto contacto = agendaController.recuperarPersona(Integer.parseInt(request.getParameter("id")));
        request.setAttribute("contacto", contacto);
        return SUCCESS;
    }
}
