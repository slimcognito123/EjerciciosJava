package controlador.action;

import beans.Usuario;
import modelo.usuarios.UsuarioDAOJPA;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by Patata kawaii on 26/01/2017.
 */
public class ActionEntrarApp extends ActionSupport implements ModelDriven<Usuario> {
    Usuario usuario=new Usuario();
    UsuarioDAOJPA usuarioDAOJPA = new UsuarioDAOJPA();

    @Override
    public String execute() throws Exception {
        if (usuarioDAOJPA.comprobarUser(usuario.getNombre(),usuario.getPassword())){
            HttpServletRequest request = ServletActionContext.getRequest();
            HttpSession session = request.getSession();
            session.setAttribute("usuario", usuario);
            return SUCCESS;
        }else{
            return INPUT;
        }
    }

    @Override
    public Usuario getModel() {
        Usuario model = new Usuario();
        return model;
    }
}
