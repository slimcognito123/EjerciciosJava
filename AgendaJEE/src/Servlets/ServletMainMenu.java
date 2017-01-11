package Servlets;

import Beans.Persona;
import DAO.BaseDatos.LectorBD;
import Negocio.Agenda;
import visualResources.VisualResources;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Patata kawaii on 10/01/2017.
 */
@WebServlet("/mainMenu")
public class ServletMainMenu extends HttpServlet {
    VisualResources codHTML;
    Agenda agenda= new Agenda();
    ArrayList<Persona> list;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().print(codHTML.INICIO_HTML + codHTML.HEAD_HTML + codHTML.INICIO_BODY);
        HttpSession session = request.getSession(false);
        String usuario = (String) session.getAttribute("user");
        list=agenda.recuperarAgenda(usuario);
        response.getWriter().print("<form action=\"pantallaAnadir\" method='post'><input type='submit' value='a&ntilde;adir'></form>");
        response.getWriter().print("<form action=\"buscarMes\" method='post'>");
        response.getWriter().print("<select name='mes'>");
        for (int i = 0; i < 12; i++) {
            response.getWriter().print("<option value='"+(i+1)+"'>"+(i+1)+"</option>");
        }
        response.getWriter().print("</select>");
        response.getWriter().print("<input type='submit' value='buscar por mes'></form>");
        response.getWriter().print("<form action=\"/logout\"><input type='submit' value='logout'></form>");
        response.getWriter().print("<table>");
        for (Persona persona : list) {
            response.getWriter().print("<tr>");
            response.getWriter().print("<td>"+persona.getNombre()+" "+persona.getApellidos()+"</td>");
            response.getWriter().print("<td><form action=\"modificar\" method=\"post\"><input type='submit' value='modificar'><input type='hidden'  name='dni' value='"+persona.getDni()+"'></form></td>");
            response.getWriter().print("<td>" +
                                            "<form action='eliminar' method='post'>" +
                                                "<input type='hidden' name='dni' value='"+persona.getDni()+"'>" +
                                                "<input type='submit' value='eliminar'>" +
                                            "</form>" +
                                        "</td>");
            response.getWriter().print("</tr>");
        }
        response.getWriter().print("</table>");
        response.getWriter().print(codHTML.FIN_BODY_HTML);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //does nothing
    }
}
