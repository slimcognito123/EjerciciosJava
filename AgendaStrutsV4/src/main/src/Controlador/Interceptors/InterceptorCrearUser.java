package Controlador.Interceptors;

import Beans.Usuario;
import Modelo.Usuarios.UsuarioDAOJPA;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;

import static com.opensymphony.xwork2.Action.INPUT;
import static com.opensymphony.xwork2.Action.LOGIN;
import static com.opensymphony.xwork2.Action.SUCCESS;

/**
 * Created by Patata kawaii on 26/01/2017.
 */
public class InterceptorCrearUser extends AbstractInterceptor {
    private String nombre;
    private String pass;
    private String pass2;

    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        nombre = request.getParameter("nombre");
        pass = request.getParameter("pass");
        pass2= request.getParameter("pass2");
        if (nombre == null || pass == null || pass2 == null) {
            System.out.println("\033[35m no soy null");
            return INPUT;
        } else {
            if (comprobarContrasenas(pass, pass2)) {
                if (comprobarUsuarioBD(nombre)) {
                    return SUCCESS;
                } else {
                    System.out.println("\033[34m estoy en la bd");
                    return LOGIN;
                }
            } else {
                System.out.println("\033[36m las contrasenas no cuadran");
                return INPUT;
            }
        }
    }

    private boolean comprobarUsuarioBD(String usuario) {
        UsuarioDAOJPA usuarioDAO = new UsuarioDAOJPA();
        return !usuarioDAO.buscarUsuarioRepetido(usuario);
    }

    private boolean comprobarContrasenas(String pass, String pass2) {
        return pass.compareTo(pass2) == 0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
