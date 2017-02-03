package beans;

import org.springframework.context.annotation.Scope;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Scope("session")
public class Usuario {
    @Id
    private String nombreUsuario;
    private String password;

    public Usuario() {

    }

    public Usuario(String nombreUsuario, String password) {
        this.nombreUsuario = nombreUsuario;
        this.password = password;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
