package interceptores;

import com.opensymphony.xwork2.ActionSupport;

import java.time.LocalDate;

public class ActionValidar extends ActionSupport{
    private String nombre;
    private Integer edad;
    private LocalDate hoy;

    @Override
    public String execute() throws Exception {

        if (nombre == null || edad == null) {
            return INPUT;
        }else if (edad<18){
            addActionError("eres menor de edad");
            return LOGIN;
        }else{
            return SUCCESS;
        }
    }

    public LocalDate getHoy() {
        return hoy;
    }

    public void setHoy(LocalDate hoy) {
        this.hoy = hoy;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }
}
