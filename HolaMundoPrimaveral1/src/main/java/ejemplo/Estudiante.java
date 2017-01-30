package ejemplo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
@Scope
public class Estudiante {
    private String nombre;
    private Integer edad;

    private List<Estudiante> amigos = new ArrayList();

    public Estudiante() {
    }

    public Estudiante(String s, Integer s2) {
        this.nombre=s;
        this.edad=s2;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Estudiante> getAmigos() {
        return amigos;
    }

    public void setAmigos(List<Estudiante> amigos) {
        this.amigos = amigos;
    }
    public int numeroAmigos(){
        return amigos.size();
    }

    public void inicio() {
        System.out.println("me estan creando");
    }

    public void destruir() {
        System.out.println("me estan destr");
    }
}
