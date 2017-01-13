package Controlador.Servlets;

import Beans.Persona;
import Controlador.AgendaController;
import visualResources.VisualResources;

import javax.servlet.RequestDispatcher;
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
    AgendaController agendaController = new AgendaController();
    ArrayList<Persona> list;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("estoy en buscar por mes "+request.getParameter("mes"));
        HttpSession session = request.getSession(false);
        String usuario = (String) session.getAttribute("user");
        String mes = request.getParameter("mes");
        if(request.getParameter("mes")==null) mes= "%";
        list= agendaController.recuperarAgendaPorMes(mes,usuario);
        System.out.println(list +" lista");
        System.out.println(mes+" mes");
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/mainMenu.jsp");
        request.setAttribute("contactos",list);
        rd.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
