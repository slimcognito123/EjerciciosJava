package beans;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class PersonaFactory {
    private static PersonaFactory instance = null;
    private String nombre;
    private PersonaFactory(){
        System.out.println("Construyendo por constructor");
    }

    public static PersonaFactory getInstance() {
        System.out.println("Construyendo via getInstance");
        return instance;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    @Override
    public String toString(){
        return ToStringBuilder.reflectionToString(this);
    }
}
