package Controlador.Servlets;

import Beans.Contacto;
import Controlador.AgendaController;

import javax.servlet.RequestDispatcher;
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
@WebServlet("/buscarMes")
public class ServletBuscarMes extends HttpServlet {
    private AgendaController agendaController = new AgendaController();
    private ArrayList<Contacto> list;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("estoy en buscar por mes "+request.getParameter("mes"));
        HttpSession session = request.getSession(false);
        System.out.println(session.getAttribute("user"));
        if(session.getAttribute("user")==null){
            response.sendRedirect("index.html");
        }
        String usuario = (String) session.getAttribute("user");
        String mes = request.getParameter("mes");
        if(request.getParameter("mes")==null|| Objects.equals(request.getParameter("mes"), "%")) list= agendaController.recuperarAgendaCompleta(usuario);
        else list= agendaController.recuperarAgendaPorMes(mes,usuario);
        System.out.println(list +" lista");
        System.out.println(mes+" mes");
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/mainMenu.jsp");
        request.setAttribute("contactos",list);
        rd.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
