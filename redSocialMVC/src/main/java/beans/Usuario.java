package beans;

import org.springframework.context.annotation.Scope;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Scope("session")
public class Usuario {
    @Id
    private String nombreUsuario;
    private String password;
    private String email;
    private String imagen;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Usuario> seguidos = new ArrayList<>();
    private String estado;

    public Usuario() {

    }

    public Usuario(String nombreUsuario, String password, String email, String imagen) {
        this.nombreUsuario = nombreUsuario;
        this.password = password;
        this.email = email;
        this.imagen = imagen;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public List<Usuario> getSeguidos() {
        return seguidos;
    }

    public void setSeguidos(List<Usuario> seguidos) {
        this.seguidos = seguidos;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
