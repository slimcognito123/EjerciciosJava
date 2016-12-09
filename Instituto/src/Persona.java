/**
 * Created by Patata kawaii on 07/12/2016.
 */
public abstract class Persona {
    String nombre;
    String apellido;
    int nIdentificacion;
    String estadoCivil;

    public Persona(String nombre, String apellido, int nIdentificacion, String estadoCivil) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.nIdentificacion = nIdentificacion;
        this.estadoCivil = estadoCivil;
    }

    public void cambiarEstadoCivil(String estado){
        this.estadoCivil=estado;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    @Override
    public String toString() {
        return "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", nIdentificacion=" + nIdentificacion +
                ", estadoCivil='" + estadoCivil;
    }

}
