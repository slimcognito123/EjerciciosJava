package Controlador.Servlets;

import Beans.Usuario;
import Controlador.UsuarioController;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import sun.misc.Regexp;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@WebServlet("/comprobarCreacion")
public class ServletCrearUsuario extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String usuario = request.getParameter("usuario");
        String password = request.getParameter("password");
        String password2 = request.getParameter("password2");
        if(comprobarUsuarioValido()){
            if (comprobarContrasenas(password, password2)) {
                if (comprobarUsuarioBD(usuario)) {
                    Usuario user = new Usuario(usuario, password);
//                    usuarioController = new UsuarioDAOJPA();
                    ServletContext sc = getServletContext();
                    WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(sc);
                    UsuarioController usuarioController = (UsuarioController) wac.getBean("usuarioController");
                    usuarioController.insertarUsuario(user);
                    response.sendRedirect("index.html?creacionCorrecta='ok'");
                } else {
                    darFormatoError(response);
                    response.getWriter().append("Usuario ya existente");
                    response.getWriter().append("</div></body></html>");
                }
            } else {
                darFormatoError(response);
                response.getWriter().append("las contrase&ntilde;as escritas no concuerdan");
                response.getWriter().append("</div></body></html>");
            }
        }else{
            darFormatoError(response);
            response.getWriter().append("nombre invalido, intentelo de nuevo");
            response.getWriter().append("</div></body></html>");
        }

    }

    private boolean comprobarUsuarioValido() {
        Regexp expresionUsuario = new Regexp("");
        return true;
    }

    private void darFormatoError(HttpServletResponse response) {
        try {
            response.getWriter().println("<!DOCTYPE html>\n" +
                    "<html lang=\"en\">\n" +
                    "<head>\n" +
                    "    <meta charset=\"UTF-8\">\n" +
                    "    <link rel=\"stylesheet\" href=\"style/Style.css\">\n" +
                    "    <title>Agenda</title>\n" +
                    "</head>\n" +
                    "<body>" +
                    "<div>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean comprobarUsuarioBD(String usuario) {
        ServletContext sc = getServletContext();
        WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(sc);
        UsuarioController usuarioController = (UsuarioController) wac.getBean("usuarioController");
        return !usuarioController.buscarUsuarioRepetido(usuario);
    }

    private boolean comprobarContrasenas(String password, String password2) {
        return password.compareTo(password2) == 0;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
