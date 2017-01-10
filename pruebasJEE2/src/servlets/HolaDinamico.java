package servlets;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * Created by curso mañana on 09/01/2017.
 */
@WebServlet("/hola2")
public class HolaDinamico extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.getWriter().append("<html><body>");
        response.getWriter().append("<h2>Hola contenedor dinamico</h2>");
        String nombre = request.getParameter("nombre");
        response.getWriter().append("<h1>").append(nombre).append("</h1>");
        /*for (long i = 0; i < 100000000000000000L; i++) {
            i++;
            response.getWriter().append(i + " ");
        }*/
        response.getWriter().append("</body></html>");
    }
}
