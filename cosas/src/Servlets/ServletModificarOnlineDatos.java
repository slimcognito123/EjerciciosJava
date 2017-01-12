package Servlets;

import Beans.Fecha;
import Beans.Persona;
import DAO.BaseDatos.EscritorBD;
import DAO.BaseDatos.LectorBD;

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
@WebServlet("/modificar")
public class ServletModificarOnlineDatos extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if(session ==null){
            response.sendRedirect("index.html");
        }else{
            String nombre=request.getParameter("nombre");
            String apellido=request.getParameter("apellido");
            String dni= request.getParameter("DNI");
            int telefono= Integer.parseInt(request.getParameter("tlf"));
            String fechaCompleta= request.getParameter("date");
            Fecha fecha;
            try{
                int dia = Integer.parseInt(fechaCompleta.split("-")[0]);
                int mes = Integer.parseInt(fechaCompleta.split("-")[1]);
                int anio = Integer.parseInt(fechaCompleta.split("-")[2]);
                fecha= new Fecha(dia,mes,anio);
            }catch(Exception e){
                int dia = Integer.parseInt(fechaCompleta.split("/")[0]);
                int mes = Integer.parseInt(fechaCompleta.split("/")[1]);
                int anio = Integer.parseInt(fechaCompleta.split("/")[2]);
                fecha= new Fecha(dia,mes,anio);
            }
            EscritorBD escritorBD= new EscritorBD();
            escritorBD.modificarPersonaOnline(new Persona(nombre,apellido,dni,telefono,fecha), (String) session.getAttribute("user"));
            response.sendRedirect("/mainMenu");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
