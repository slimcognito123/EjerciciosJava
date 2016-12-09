/**
 * Created by Patata kawaii on 07/12/2016.
 */
public abstract class Empleado extends Persona{

    int anoIngreso;
    int numDespacho;

    public Empleado(String nombre, String apellido, int nIdentificacion, String estadoCivil, int anoIngreso, int numDespacho) {
        super(nombre, apellido, nIdentificacion, estadoCivil);
        this.anoIngreso = anoIngreso;
        this.numDespacho = numDespacho;
    }

    public Empleado(String nombre, String apellido, int nIdentificacion, String estadoCivil) {
        super(nombre, apellido, nIdentificacion, estadoCivil);
    }

    public void setNumDespacho(int numDespacho) {
        this.numDespacho = numDespacho;
    }

    @Override
    public String toString() {
        return  super.toString()+
                ", anoIngreso=" + anoIngreso +
                ", numDespacho=" + numDespacho;
    }
    public abstract float salario(float salarioBruto);

}
