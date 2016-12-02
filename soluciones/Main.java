package empresa;

public class Main {

	public static void main(String[] args) {
		Empresa empresa = new Empresa();
		Empleado empleado = new Empleado("12313F",1500,12,24,16,0);
		Empleado empleado1 = new Empleado("12314F",1500,6,24,16,0);
		Empleado empleado2 = new Empleado("12315F",1500,3,24,16,1);
		Empleado empleado3 = new Empleado("12316F",1500,2,24,16,2);
		Empleado empleado4 = new Empleado("12317F",1500,0,24,16,3);
		
		System.out.println("La retencion practicada al emplado es ");
		System.out.println(empleado.retencion());
		
		empresa.aniadirEmpleado(empleado);
		empresa.aniadirEmpleado(empleado1);
		empresa.aniadirEmpleado(empleado2);
		empresa.aniadirEmpleado(empleado3);
		empresa.aniadirEmpleado(empleado4);
		
		Empleado encontrado = empresa.buscarEmpleadoPorNif("12317F");
		empresa.borrarEmpleado(encontrado);
		System.out.println(" la media de hijos es "+empresa.mediaHijos());
		empresa.mostrarEmpleado("12315F");
		System.out.println("Empleado borrado :");
		empresa.mostrarEmpleado("12317F");
		empresa.mostrarEmpleados();
		
		
	}

}
