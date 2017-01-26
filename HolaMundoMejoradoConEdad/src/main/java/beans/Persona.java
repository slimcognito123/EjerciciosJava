package beans;

public class Persona {

    private Integer edad;
    private String nombre;

    public Persona(String nombre, int edad) {
        this.nombre=nombre;
        this.edad=edad;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
