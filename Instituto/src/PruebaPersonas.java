import java.util.ArrayList;

/**
 * Created by Patata kawaii on 08/12/2016.
 */
public class PruebaPersonas {
    ArrayList<Persona> tonta;

    public PruebaPersonas() {
        tonta = new ArrayList<>();
        tonta.add(new Estudiante("Willy", "Rex", 1234, "soltero", "2015/2016"));
        tonta.add(new PersonalServicio("Paquito", "Chocolatero", 45673, "soltero", 1999, 3, "biblioteca"));
        tonta.add(new PersonalServicio("pepito", "pepe", 800889, "casado", 2005, 5, "decanato"));
        tonta.add(new Profesor("paco", "manzano", 800319, "casado", 2000, 4, "lengua"));
        tonta.add(new Profesor("antonio", "robles", 367336, "divorciado", 1969, 2, "ed.fisica"));
        for (Persona persona : tonta) {
            System.out.println(persona.toString() + "\n");
        }
        for (Persona persona : tonta) {
            System.out.println(comprobarSalario(persona));
        }
    }

    private String comprobarSalario(Persona persona) {
        if (persona instanceof Estudiante)
            return "esta persona no tiene salario";
        else return persona.getNombre() + " " + persona.getApellido() + " salario: " + ((Empleado)persona).salario(300f);
    }


    public static void main(String[] args) {
        new PruebaPersonas();
    }
}
