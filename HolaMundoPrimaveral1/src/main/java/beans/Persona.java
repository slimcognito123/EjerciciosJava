package beans;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

public class Persona implements Serializable {
    private Long id;
    private String nombre;
    private String apellidos;
    private Direccion direccion;

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}
