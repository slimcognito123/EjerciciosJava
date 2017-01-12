package Servlets;

import DAO.BaseDatos.EscritorBD;

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
@WebServlet("/eliminar")
public class ServletEliminar extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if(session ==null){
            response.sendRedirect("index.html");
        }else {
            String dni=request.getParameter("dni");
            EscritorBD escritorBD = new EscritorBD();
            escritorBD.eliminarPersonaOnline(dni,session.getAttribute("user"));
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/mainMenu");
            rd.forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
