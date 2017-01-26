package Controlador.Action;

import Beans.Usuario;
import Modelo.Usuarios.UsuarioDAOJPA;
import com.opensymphony.xwork2.ActionSupport;

public class ActionCrearUsuario extends ActionSupport{
    private  String nombre;
    private String pass;
    private String pass2;

    @Override
    public String execute() throws Exception {
        if(nombre == null || pass == null || pass2==null){
            return INPUT;
        }else {
            if (comprobarContrasenas(pass,pass2)){
                if (comprobarUsuarioBD(nombre)){
                    Usuario user = new Usuario(nombre,pass);
                    UsuarioDAOJPA escritorBDescribir = new UsuarioDAOJPA();
                    escritorBDescribir.insertarUsuario(user);
                    return SUCCESS;
                }else {
                    return LOGIN;
                }
            }else{
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
