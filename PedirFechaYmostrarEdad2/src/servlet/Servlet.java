package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

/**
 * Created by curso mañana on 09/01/2017.
 */
@WebServlet("/calcularAno")
public class Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        HttpSession session= request.getSession(true);
        session.setAttribute("NombreUsuario",nombre);
        session.setMaxInactiveInterval(5);
        String date = request.getParameter("date");
        response.setContentType("text/html");
        response.getWriter().println("<html><body>");
        response.getWriter().println("hola <b>" + nombre + "</b> naciste el dia " + mostrarFechaFormateada(date) + "<br>tienes " + calcularAnos(date) + " a&ntilde;os");
        response.getWriter().println("<a href='servletSession'>ve a la siguiente pagina pa comprobar algo</a>");
        response.getWriter().println("</body></html>");
        response.getWriter().close();
    }

    private String mostrarFechaFormateada(String date) {
        LocalDate birthday = LocalDate.parse(date);
        DateTimeFormatter fechaFormateada = DateTimeFormatter.ofPattern("DD/MM/YY");
        return birthday.format(fechaFormateada);
    }

    private int calcularAnos(String date) {
        LocalDate diaActual = LocalDate.now();
        LocalDate diaNacimiento = LocalDate.parse(date);
        //anos=LocalDate.from(diaActual).compareTo(diaNacimiento);
        Period periodo = Period.between(diaNacimiento, diaActual);
        return periodo.getYears();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
