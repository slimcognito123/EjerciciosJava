package example;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
    private  String nombre;
    private String pass;

    @Override
    public String execute() throws Exception {
        if(nombre == null || pass == null){
            return LOGIN;
        }
        if (nombre.equals("patata")&&pass.equals("contrasena")){
            return SUCCESS;
        }else {
            return LOGIN;
        }
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
