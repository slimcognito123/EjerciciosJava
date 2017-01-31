package Beans;

import javax.persistence.*;

@Entity
@SequenceGenerator(name = "generadorContactos",sequenceName = "IdContactos")
public class Contacto {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "generadorContactos")
    private Integer id;
    private String nombre;
    private String apellidos;
    private String telefono;
    private String fecha;
    private String user;

    public Contacto(String nombre, String apellidos, String telefono, String fecha, String user) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.fecha = fecha;
        this.user = user;
    }

    public Contacto() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
