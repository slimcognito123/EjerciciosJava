package interceptores;

import beans.Persona;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

import java.time.LocalDate;

public class ActionValidar extends ActionSupport{
    private String nombre;
    private Integer edad;
    private LocalDate hoy;

    @Override
    public String execute() throws Exception {

        ValueStack stack = ActionContext.getContext().getValueStack();
        stack.push(new Persona("Paco",20));
        if (nombre == null || edad == null) {
            return LOGIN;
        }else if (edad<18){
            addActionError("eres menor de edad");
            return LOGIN;
        }else{
            return SUCCESS;
        }
    }

    @Override
    public String toString() {
        return "ActionValidar <- nombre de la clase merluzo";
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
