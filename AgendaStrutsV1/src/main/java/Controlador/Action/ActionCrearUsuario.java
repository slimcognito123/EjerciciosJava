package Controlador.Action;

import Beans.Usuario;
import Modelo.Usuarios.UsuarioDAOJPA;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ActionCrearUsuario extends ActionSupport implements ModelDriven<Usuario>{

    private Usuario usuario = new Usuario();
    private UsuarioDAOJPA escritorBDescribir = new UsuarioDAOJPA();

    @Override
    public String execute() throws Exception {
        String result = ERROR;
        boolean inserted = escritorBDescribir.insertarUsuario(usuario);
        if(inserted){
            result = SUCCESS;
        }
        return result;
    }

    @Override
    public Usuario getModel() {
        Usuario model = new Usuario();
        return model;
    }
}
