package controlador.action;

import beans.Usuario;
import modelo.usuarios.UsuarioDAOJPA;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ActionCreateUser extends ActionSupport implements ModelDriven<Usuario>{

    private Usuario usuario;
    private UsuarioDAOJPA escritorBDescribir = new UsuarioDAOJPA();

    @Override
    public String execute() throws Exception {
        String result = ERROR;
        System.out.println("holiwis, esto es el action, is anyone there?");
        System.out.println(usuario.getNombre());
        boolean inserted = escritorBDescribir.insertarUsuario(usuario);
        if(inserted){
            result = SUCCESS;
        }
        System.out.println(result+"<-- action");
        return result;
    }

    @Override
    public Usuario getModel() {
        Usuario model = new Usuario();
        return model;
    }
}
