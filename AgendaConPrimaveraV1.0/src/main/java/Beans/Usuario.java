package Beans;

import org.springframework.stereotype.Component;

import javax.persistence.Id;

@Component
public class Usuario {

    @Id
    private String nombre;
    private String password;
    /*@OneToMany
    List<Contacto> contactos;
*/
    public Usuario() {
    }

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
