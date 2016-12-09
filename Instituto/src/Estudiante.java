/**
 * Created by Patata kawaii on 07/12/2016.
 */
public class Estudiante extends Persona {

    String curso;

    public Estudiante(String nombre, String apellido, int nIdentificacion, String estadoCivil) {
        super(nombre, apellido, nIdentificacion, estadoCivil);
    }

    public Estudiante(String nombre, String apellido, int nIdentificacion, String estadoCivil, String curso) {
        super(nombre, apellido, nIdentificacion, estadoCivil);
        this.curso = curso;
    }

    @Override
    public String toString() {
        return "Estudiante{" +super.toString()+
                ", curso='" + curso + '\'' +
                '}';
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }
}
