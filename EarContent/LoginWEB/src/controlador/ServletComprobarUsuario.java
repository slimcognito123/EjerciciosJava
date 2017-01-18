package controlador;


import Negocio.RemoteGestionUsuariosBean;

import javax.ejb.EJB;
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
    @EJB
    private RemoteGestionUsuariosBean gestionUsuarios;

    public ServletComprobarUsuario() {
        System.out.println("holi");
    }

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String user = request.getParameter("usuario");
        String pass = request.getParameter("password");
        if(gestionUsuarios.login(user,pass)){
            System.out.println("todo ha ido bien");
        }else {
            System.out.println("mal");
        }

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }
}
