package EjerAbstract2;

/**
 * Created by curso mañana on 01/12/2016.
 */
public class Empleado {
    private String nombre;
    private String nif;
    private int edad;
    private boolean casado;
    private float salario;

    public Empleado(String nombre, String nif, int edad, boolean casado, float salario) {
        this.nombre = nombre;
        this.nif = nif;
        this.edad = edad;
        this.casado = casado;
        this.salario = salario;
    }

    public Empleado() {
    }

    public String obtenerClasificacion() {
        if (edad <= 21) return "Principiante";
        else if (edad >= 22 && edad <= 35) return "Intermedio";
        else return "Senior";
    }

    @Override
    public String toString() {
        String separador = "\n";
        return "Empleado: " + separador +
                "nombre='" + nombre +separador +
                "nif='" + nif +separador +
                "edad=" + edad +separador+
                "casado=" + casado +separador+
                "salario=" + salario;
    }
    public void aumentoSalario(float porcentaje){
        salario+=salario*porcentaje/100;
    }
}
