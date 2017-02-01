package Controlador.Servlets;

import Modelo.Business.AgendaBusiness;
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

/**
 * Created by Patata kawaii on 11/01/2017.
 */
@Component
@WebServlet("/eliminar")
public class ServletEliminar extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if(session ==null){
            response.sendRedirect("index.jsp");
        }else {
            int id=Integer.parseInt(request.getParameter("id"));

            ServletContext sc = getServletContext();
            WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(sc);
            AgendaBusiness agendaBusiness = (AgendaBusiness) wac.getBean("agendaBusiness");
            agendaBusiness.eliminarPersonaid(id,(String) session.getAttribute("user"));

            RequestDispatcher rd = getServletContext().getRequestDispatcher("/buscarMes");
            rd.forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
