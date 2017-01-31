package Controlador.Servlets;

import Beans.Contacto;
import Controlador.AgendaController;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by Patata kawaii on 12/01/2017.
 */
@Component
@WebServlet("/buscarMes")
public class ServletBuscarMes extends HttpServlet {
//    @Autowired
//    @Qualifier("controlador")
//    private AgendaController agendaController;

    ArrayList<Contacto> list;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("estoy en buscar por mes " + request.getParameter("mes"));
        HttpSession session = request.getSession(false);
        String usuario = (String) session.getAttribute("user");
        String mes = request.getParameter("mes");

        ServletContext sc = getServletContext();
        WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(sc);
        AgendaController agendaController = (AgendaController) wac.getBean("controlador");
        if (request.getParameter("mes") == null || Objects.equals(request.getParameter("mes"), "%"))
            list = agendaController.recuperarAgendaCompleta(usuario);
        else list = agendaController.recuperarAgendaPorMes(mes, usuario);
        System.out.println(list + " lista");
        System.out.println(mes + " mes");
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/mainMenu.jsp");
        request.setAttribute("contactos", list);
        rd.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
