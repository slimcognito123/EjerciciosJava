package Controlador.Servlets;

import Beans.Usuario;
import Modelo.BaseDatos.EscritorBD;
import Modelo.BaseDatos.LectorBD;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/comprobarCreacion")
public class ServletCrearUsuario extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String usuario = request.getParameter("usuario");
        String password = request.getParameter("password");
        String password2 = request.getParameter("password2");
        if (comprobarContrasenas(password, password2)) {
            if (comprobarUsuarioBD(usuario)) {
                Usuario user = new Usuario(usuario, password);
                EscritorBD escritorBD = new EscritorBD();
                escritorBD.insertarUsuario(user);
                response.sendRedirect("index.html?creacionCorrecta='ok'");
            } else {
                response.getWriter().append("Usuario ya existente");
            }
        } else {
            response.getWriter().append("las contraseñas escritas concuerdan");
        }
    }

    private boolean comprobarUsuarioBD(String usuario) {
        LectorBD lectorBD = new LectorBD();
        return !lectorBD.buscarUsuarioRepetido(usuario);
    }

    private boolean comprobarContrasenas(String password, String password2) {
        return password.compareTo(password2) == 0;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
