package ejercicio2;

public class Principal {

	public static void main(String[] args) {

		Empleado e = new Empleado();
		Empleado e2 = new Empleado("Luis", "9865R", 19, false, 2000.0);
		
		Programador p = new Programador();
		Programador p2 = new Programador("Sergio", "67455T", 40, false, 1500.0, 150, "C/C++");
		
		e.imprimirDatos();
		System.out.println("--------------------------------");
		e2.aumentarSalario(30);
		e2.imprimirDatos();
		System.out.println("--------------------------------");
		p.imprimirDatos();
		System.out.println("--------------------------------");
		p2.aumentarSalario(50);
		p2.imprimirDatos();
	}

}
