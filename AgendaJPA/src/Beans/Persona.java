package Beans;

public class Persona {

    private final int id;
    private String nombre;
    private String apellidos;
    private String telefono;
    private String fecha;

    public Persona(int id, String nombre, String apellidos, String telefono, String fecha) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.id = id;
        this.telefono = telefono;
        this.fecha = fecha;
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

    public int getId() {
        return id;
    }
}
