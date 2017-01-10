package Servlets;

import DAO.BaseDatos.ConectorBD;
import DAO.BaseDatos.LectorBD;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by curso mañana on 10/01/2017.
 */
@WebServlet("/comprobarContrasena")
public class ServletComprobarUsuario extends HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String user= request.getParameter("usuario");
        String pass= request.getParameter("password");
        LectorBD lectorBD = new LectorBD();

        if (lectorBD.comprobarUser(user, pass)) {
            HttpSession session= request.getSession(true);
            session.setAttribute("user",user);
            session.setMaxInactiveInterval(120);
            RequestDispatcher rd=getServletContext().getRequestDispatcher("/mainMenu");
            rd.forward(request,response);
        }else{
            response.sendRedirect("index.html?error=true");
        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }
}
