package Beans;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Usuario {

    @Id
    private String nombre;
    private String password;
    @OneToMany
    private List<Contacto> contactos;


    public Usuario() {/* VOID */}

    public Usuario(String nombre, String password) {
        super();
        this.nombre = nombre;
        this.password = password;
    }


    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }


}
