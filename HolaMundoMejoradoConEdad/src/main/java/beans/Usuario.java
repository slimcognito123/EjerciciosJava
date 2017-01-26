package beans;

import java.util.Date;

public class Usuario {
    private String nombre;
    private String email;
    private String pass;
    private String pass2;
    private Date fecha;

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setPass2(String pass2) {
        this.pass2 = pass2;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
