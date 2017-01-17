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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;

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
            String telefono = request.getParameter("tlf");
            String fechaCompleta = request.getParameter("date");
            //la fecha se separa por -
            Pattern expresion = Pattern.compile("^[9|6|7][0-9]{8}$");
            if (expresion.matches(expresion.pattern(), telefono)) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-dd");
                LocalDate fecha = LocalDate.parse(fechaCompleta);
                fechaCompleta = fecha.format(formatter);
                AgendaController controller = new AgendaController();
                Contacto user = new Contacto(nombre, apellido, telefono, fechaCompleta, (String) session.getAttribute("user"));
                user.setId(Integer.parseInt(request.getParameter("id")));
                controller.modificarPersona(user);
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/buscarMes");
                rd.forward(request, response);
            } else {
                response.getWriter().append("telefono no valido");
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
