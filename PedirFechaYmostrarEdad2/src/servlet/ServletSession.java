package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/servletSession")
public class ServletSession extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        HttpSession session=request.getSession(false);
        out.println("<html><body>");
        if(session==null)out.println("no se ha iniciado sesion aun");
        else{
            String nombre = (String) session.getAttribute("NombreUsuario");
            out.println("hola "+nombre+", gracias por clickar");
            session.invalidate();
        }
        out.println("</html></body>");
    }
}
