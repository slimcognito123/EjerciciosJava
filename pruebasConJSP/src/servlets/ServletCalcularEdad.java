package servlets;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;

@WebServlet("/calcularAnos")
public class ServletCalcularEdad extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session= request.getSession(true);
        String nombre= request.getParameter("nombre");
        String fecha= request.getParameter("date");
        session.setAttribute("nombre",nombre);
        LocalDate fechaActual= LocalDate.now();
        LocalDate fechaNacimiento= LocalDate.parse(fecha);
        Period period = Period.between(fechaNacimiento, fechaActual);
        session.setAttribute("edad",period.getYears());
        response.sendRedirect("/calculado1.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombre= request.getParameter("nombre");
        String fecha= request.getParameter("date");
        LocalDate fechaActual= LocalDate.now();
        LocalDate fechaNacimiento= LocalDate.parse(fecha);
        Period period = Period.between(fechaNacimiento, fechaActual);
        request.setAttribute("nombre",nombre);
        request.setAttribute("edad",period.getYears());
        RequestDispatcher requestDispatcher=getServletContext().getRequestDispatcher("/calculado2.jsp");
        requestDispatcher.forward(request,response);
    }
}
