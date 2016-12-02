package ArrayListMenu1;

import javax.management.timer.Timer;
import java.sql.Time;
import java.util.Date;

@SuppressWarnings("unused")
public class Persona {
    private String dni;
    private String nombre;
    private String apellido;
    private Fecha fechaNacimiento;
    private String tlf;

    public Persona() {
        this.dni = "";
        this.nombre = "";
        this.apellido = "";
        this.fechaNacimiento = new Fecha();
        this.tlf = "";
    }

    public Persona(String dni, String nombre, String apellido, Fecha fechaNacimiento, String tlf) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.tlf = tlf;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Fecha getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Fecha fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getTlf() {
        return tlf;
    }

    public void setTlf(String tlf) {
        this.tlf = tlf;
    }

    public void showPerson(){
        System.out.println(this.getNombre()+" "+this.getApellido()+"\n tlf:"+this.getTlf());
    }
}
