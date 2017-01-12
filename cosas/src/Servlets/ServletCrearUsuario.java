package Servlets;

import DAO.BaseDatos.EscritorBD;
import DAO.BaseDatos.LectorBD;
import DAO.Usuarios.Usuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet("/comprobarCreacion")
public class ServletCrearUsuario extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String usuario = request.getParameter("usuario");
        String password = request.getParameter("password");
        String password2 = request.getParameter("password2");
        String email = request.getParameter("emilio");
        if (comprobarContrasenas(password,password2)){
            if (comprobarUsuarioBD(usuario)){
                if (comprobarEmail(email)){
                    Usuario user = new Usuario(usuario,password,email);
                    EscritorBD escritorBD=new EscritorBD();
                    escritorBD.insertarUsuario(user);
                    response.sendRedirect("index.html?creacionCorrecta='ok'");
                }else{
                    response.getWriter().append("email mal formado");
                }
            }else{
                response.getWriter().append("Usuario ya existente");
            }
        }else{
            response.getWriter().append("las contraseñas escritas concuerdan");
        }
    }

    private boolean comprobarEmail(String email) {
        //crea la expresion regular con un String
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        //comprueba las coincidencias
        Matcher matcher = pattern.matcher(email);
        //true si coincide y false si no
        return matcher.matches();
    }

    private boolean comprobarUsuarioBD(String usuario) {
        LectorBD lectorBD= new LectorBD();
        return !lectorBD.buscarUsuarioRepetido(usuario);
    }

    private boolean comprobarContrasenas(String password, String password2) {
        return password.compareTo(password2) == 0;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
