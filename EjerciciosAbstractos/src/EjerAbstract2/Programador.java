package EjerAbstract2;

/**
 * Created by curso mañana on 01/12/2016.
 */
public class Programador extends Empleado {
    int lineasDeCodigoPorHora;
    String lenguajeDominante;

    public Programador(String nombre, String nif, int edad, boolean casado, float salario, int lineasDeCodigoPorHora, String lenguajeDominante) {
        super(nombre, nif, edad, casado, salario);
        this.lineasDeCodigoPorHora = lineasDeCodigoPorHora;
        this.lenguajeDominante = lenguajeDominante;
    }

    public Programador() {

    }
}
