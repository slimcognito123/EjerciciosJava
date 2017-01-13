package Servlets;

import Beans.Persona;
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
 * Created by Patata kawaii on 12/01/2017.
 */
@WebServlet("/buscarMes")
public class ServletBuscarMes extends HttpServlet implements VisualResources {
    Agenda agenda= new Agenda();
    ArrayList<Persona> list;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("estoy en buscar por mes "+request.getParameter("mes"));
        response.getWriter().print(INICIO_HTML + HEAD_HTML + INICIO_BODY);
        HttpSession session = request.getSession(false);
        String usuario = (String) session.getAttribute("user");
        String mes = request.getParameter("mes");
        list=agenda.recuperarAgendaPorMes(mes,usuario);
        response.getWriter().print("<form action=\"pantallaAnadir\" method='post'><input type='submit' value='a&ntilde;adir'></form>");
        response.getWriter().print("<form action=\"mainMenu\" method='post'>");
        response.getWriter().print("<input type='submit' value='volver'></form>");
        response.getWriter().print("<form action=\"/logout\"><input type='submit' value='logout'></form>");
        response.getWriter().print("<table>");
        for (Persona persona : list) {
            response.getWriter().print("<tr>");
            response.getWriter().print("<td>"+persona.getNombre()+" "+persona.getApellidos()+"</td>");
            response.getWriter().print("<td>"+persona.getTelefono()+"</td>");
            response.getWriter().print("<td>"+persona.getDni()+" "+persona.getApellidos()+"</td>");
            response.getWriter().print("<td>"+persona.getFecha().getDia()+"/"+persona.getFecha().getMes()+"/"+persona.getFecha().getAnio()+"</td>");
            response.getWriter().print("<td><form action=\"PantallaModificar\" method=\"post\"><input type='submit' value='modificar'><input type='hidden'  name='dni' value='"+persona.getDni()+"'></form></td>");
            response.getWriter().print("<td>" +
                    "<form action='eliminar' method='post'>" +
                    "<input type='hidden' name='dni' value='"+persona.getDni()+"'>" +
                    "<input type='submit' value='eliminar'>" +
                    "</form>" +
                    "</td>");
            response.getWriter().print("</tr>");
        }
        response.getWriter().print("</table>");
        response.getWriter().print(FIN_BODY_HTML);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
