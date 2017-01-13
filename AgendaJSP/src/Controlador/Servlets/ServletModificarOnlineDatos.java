package Controlador.Servlets;

import Beans.Persona;
import Controlador.AgendaController;

import javax.servlet.RequestDispatcher;
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
@WebServlet("/modificar")
public class ServletModificarOnlineDatos extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null) {
            response.sendRedirect("index.html");
        } else {
            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
            int id = Integer.parseInt(request.getParameter("id"));
            String telefono = request.getParameter("tlf");
            String fechaCompleta = request.getParameter("date");
            AgendaController controller = new AgendaController();
            controller.modificarPersona(new Persona(id, nombre, apellido, telefono, fechaCompleta), (String) session.getAttribute("user"));
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/buscarMes");
            rd.forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
