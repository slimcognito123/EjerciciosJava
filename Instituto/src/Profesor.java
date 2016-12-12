/**
 * Created by Patata kawaii on 08/12/2016.
 */
public class Profesor extends Empleado {
    private String departamento;

    public Profesor(String nombre, String apellido, int nIdentificacion, String estadoCivil, int anoIngreso, int numDespacho, String departamento) {
        super(nombre, apellido, nIdentificacion, estadoCivil, anoIngreso, numDespacho);
        this.departamento = departamento;
    }

    public Profesor(String nombre, String apellido, int nIdentificacion, String estadoCivil, String departamento) {
        super(nombre, apellido, nIdentificacion, estadoCivil);
        this.departamento = departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    @Override
    public String toString() {
        return "Profesor{" + super.toString() +
                ", departamento='" + departamento + '\'' +
                '}';
    }

    @Override
    public float salario(float salarioBruto) {
        System.out.println("profe");
        if (estadoCivil.compareTo("casado")==0) return salarioBruto *0.05f + salarioBruto;
        else return salarioBruto;
    }
}
