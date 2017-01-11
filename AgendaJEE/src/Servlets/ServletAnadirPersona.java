package Servlets;

import Beans.Fecha;
import Beans.Persona;
import DAO.BaseDatos.EscritorBD;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by curso mañana on 11/01/2017.
 */
@WebServlet("/anadirPersona")
public class ServletAnadirPersona extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombre=request.getParameter("nombre");
        String apellido=request.getParameter("apellido");
        String dni= request.getParameter("DNI");
        int telefono= Integer.parseInt(request.getParameter("tlf"));
        String fechaCompleta= request.getParameter("date");

        int dia = Integer.parseInt(fechaCompleta.split("-")[0]);
        int mes = Integer.parseInt(fechaCompleta.split("-")[1]);
        int anio = Integer.parseInt(fechaCompleta.split("-")[2]);
        Fecha fecha= new Fecha(dia,mes,anio);
        Persona persona = new Persona(nombre,apellido,dni, telefono,fecha);
        EscritorBD escritorBD = new EscritorBD();
        escritorBD.anadirPersonaOnline(persona, String.valueOf(request.getSession(false).getAttribute("user")));
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/mainMenu");
        rd.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //na de na
    }
}
