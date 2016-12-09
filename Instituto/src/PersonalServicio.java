/**
 * Created by Patata kawaii on 08/12/2016.
 */
public class PersonalServicio extends Empleado {
    private String seccion;

    public PersonalServicio(String nombre, String apellido, int nIdentificacion, String estadoCivil, int anoIngreso, int numDespacho, String seccion) {
        super(nombre, apellido, nIdentificacion, estadoCivil, anoIngreso, numDespacho);
        this.seccion = seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    @Override
    public String toString() {
        return "PersonalServicio{" +super.toString()+
                ", seccion='" + seccion + '\'' +
                '}';
    }

    @Override
    public float salario(float salarioBruto) {
        if (anoIngreso<2000) return salarioBruto*0.08f + salarioBruto;
        else return salarioBruto ;
    }
}
