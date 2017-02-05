package beans;

import org.springframework.context.annotation.Scope;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Patata kawaii on 05/02/2017.
 */
@Entity
@Scope("session")
public class Usuario {
    @Id
    String nombreUsuario;
    String contrasena;

    public Usuario() {
    }

    public Usuario(String nombreUsuario, String contrasena) {
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}
