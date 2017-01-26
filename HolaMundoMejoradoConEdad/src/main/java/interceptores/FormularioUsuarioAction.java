package interceptores;

import beans.Usuario;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class FormularioUsuarioAction extends ActionSupport implements ModelDriven<Usuario> {

      private Usuario usuario;

    @Override
    public String execute() throws Exception {
        usuario = new Usuario();
        return SUCCESS;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getModel() {
        return null;
    }
}
