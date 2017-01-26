package Controlador.Action;

import Beans.Contacto;
import Controlador.AgendaController;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;

/**
 * Created by curso mañana on 11/01/2017.
 */
@WebServlet("/anadirPersona")
public class ServletAnadirPersona extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String telefono = (request.getParameter("tlf"));
        String fechaCompleta = request.getParameter("date");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-dd");
        Pattern expresion = Pattern.compile("^[9|6|7][0-9]{8}$");
        if (expresion.matches(expresion.pattern(), telefono)) {
            LocalDate fecha = LocalDate.parse(fechaCompleta);
            fechaCompleta = fecha.format(formatter);
            Contacto contacto = new Contacto(nombre, apellido, telefono, fechaCompleta,String.valueOf(request.getSession(false).getAttribute("user")));
            AgendaController controller = new AgendaController();
            controller.anadirPersonaOnline(contacto);

            RequestDispatcher rd = getServletContext().getRequestDispatcher("/buscarMes");
            rd.forward(request, response);
        } else {
            response.getWriter().append("telefono no valido");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //na de na
    }
}
