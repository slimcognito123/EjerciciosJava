package Servlets;

import Beans.Persona;
import DAO.BaseDatos.LectorBD;
import visualResources.VisualResources;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Patata kawaii on 11/01/2017.
 */
@WebServlet("/PantallaModificar")
public class ServletPantallaModificar extends HttpServlet implements VisualResources{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LectorBD lectorBD = new LectorBD();
        Persona persona = lectorBD.seleccionarPersona(request.getParameter("dni"));
        response.getWriter().print(INICIO_HTML+HEAD_HTML+INICIO_BODY);
        response.getWriter().print("<form action=\"mainMenu\" method=\"post\"><input type=\"submit\" value=\"volver al menu\"></form>\n" +
                "<form action=\"modificar\" method=\"post\">\n" +
                "    <!--los campos requeridos (importantes) al principio-->\n" +
                "    <label>\n" +
                "        dni:\n" +
                "        <input type=\"text\" name=\"DNI\" value='"+persona.getDni()+"' required>\n" +
                "    </label>\n" +
                "    <label>\n" +
                "        telefono:\n" +
                "        <input type=\"number\" name=\"tlf\" value='"+persona.getTelefono()+"' required>\n" +
                "    </label>\n" +
                "    <label>\n" +
                "        nombre:\n" +
                "        <input type=\"text\" name=\"nombre\" value='"+persona.getNombre()+"'>\n" +
                "    </label>\n" +
                "    <label>\n" +
                "        apellido:\n" +
                "        <input type=\"text\" name=\"apellido\" value='"+persona.getApellidos()+"'>\n" +
                "    </label>\n" +
                "    <label>\n" +
                "        Fecha Nacimiento:\n" +
                "        <input type=\"date\" name=\"date\" value='"+persona.getFecha().getDia()+"/"+persona.getFecha().getMes()+"/"+persona.getFecha().getAnio()+"'>\n" +
                "    </label>\n" +
                "    <input type=\"submit\" value=\"modificar\">\n" +
                "</form>");
        response.getWriter().print(FIN_BODY_HTML);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
