package controlador.action;

import controlador.AgendaController;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class ActionEliminar extends ActionSupport {
    @Override
    public String execute() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpSession session = request.getSession();
        int id=Integer.parseInt(request.getParameter("id"));
        AgendaController agendaController = new AgendaController();
        agendaController.eliminarPersonaid(id,(String) session.getAttribute("user"));
        return SUCCESS;
    }
}
