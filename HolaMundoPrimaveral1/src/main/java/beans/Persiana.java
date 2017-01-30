package beans;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class Persiana {
    String nombre;
    int edad;
    float altura;
    Direccion direccion;

    public Persiana(String nombre, int edad, float altura, Direccion direccion) {
        this.nombre = nombre;
        this.edad = edad;
        this.altura = altura;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
