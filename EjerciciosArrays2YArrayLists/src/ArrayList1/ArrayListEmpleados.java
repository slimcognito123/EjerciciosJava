package ArrayList1;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by curso mañana on 29/11/2016.
 */
public class ArrayListEmpleados {
    static private ArrayList<Empleado> alday;

    public ArrayListEmpleados() {
        alday = new ArrayList<>();
    }

    public static void main(String[] args) {
        new ArrayListEmpleados();
        System.out.println("bienvenido al controlador:");
        boolean continuar = true;
        do {
            System.out.println("1.añadir empleado:\n2.eliminar empleado\n3.buscar empleado por NIF\n4.media de hijos\n5.informacion de un empleado en concreto\n0.Salir");
            try {
                Scanner scan = new Scanner(System.in);
                int envio = scan.nextInt();
                continuar = opcion(envio);
            } catch (InputMismatchException e) {
                System.out.println("introduce un numero para seleccionar una opcion");
            }
        } while (continuar);
    }

    private static boolean opcion(int envio) {
        switch (envio) {
            case 1:
                anadirEmpleado();
                break;
            case 2:
                borrarEmpleado();
                break;
            case 3:
                buscarNif();
                break;
            case 4:
                mediaHijos();
                break;
            case 5:
                informacionEmpleado();
                break;
            case 99:
                mostrarEmpleados();
            case 0:
                return false;
        }
        return true;
    }

    private static void mostrarEmpleados() {
        for (Empleado empleado : alday) {
            System.out.println(empleado.toString());
        }
    }

    private static void informacionEmpleado() {
        if (buscarNif() != null) {
            System.out.println(buscarNif().toString());
        }
    }

    private static void mediaHijos() {
        int hijos = 0;
        for (int i = 0; i < alday.size(); i++) {
            hijos += alday.get(i).getHijos();
        }
        if (alday.size() > 0)
            System.out.println("media de hijos:" + (hijos / alday.size()));
        else System.out.println("no hay empleados");
    }

    private static Empleado buscarNif() {
        System.out.println("introduce NIF del empleado a buscar:");
        Scanner scan = new Scanner(System.in);
        String dni = scan.nextLine();
        for (Empleado empleado : alday) {
            if (empleado.getNIF().equals(dni)) {
                System.out.println("usuario encontrado");
                return empleado;
            } else {
                System.out.println("usuario no encontrado o DNI mal introducido");
            }
        }
        return null;
    }

    private static void borrarEmpleado() {
        alday.remove(buscarNif());
        System.out.println("usuario eliminado");
    }

    private static void anadirEmpleado() {
        boolean error = false;
        Empleado empleado = new Empleado();
        do {
            System.out.println("introduce NIF del empleado:");
            Scanner scan = new Scanner(System.in);
            String dni = scan.nextLine();
            empleado.setNIF(dni);
        } while (error);
        do {
            error = false;
            try {
                System.out.println("introduce Sueldo del empleado:");
                Scanner scan = new Scanner(System.in);
                float sueldo = scan.nextFloat();
                empleado.setSueldo(sueldo);
            } catch (Exception e) {
                System.out.println("sueldo no valido");
                error = true;
            }
        } while (error);
        do {
            error = false;
            try {
                System.out.println("introduce IRPF del empleado:");
                Scanner scan = new Scanner(System.in);
                int irpf = scan.nextInt();
                empleado.setIRPF(irpf);
            } catch (Exception e) {
                System.out.println("porcentaje de IRPF no valido");
                error = true;
            }
        } while (error);
        do {
            error = false;
            try {
                System.out.println("introduce horas extras del mes del empleado:");
                Scanner scan = new Scanner(System.in);
                int horas = scan.nextInt();
                empleado.setHorasExtraMes(horas);
            } catch (Exception e) {
                System.out.println("horas extras del mes no valido");
                error = true;
            }
        } while (error);
        do {
            error = false;
            try {
                System.out.println("introduce numero de hijos del empleado:");
                Scanner scan = new Scanner(System.in);
                int hijos = scan.nextInt();
                empleado.setHijos(hijos);
            } catch (Exception e) {
                System.out.println("numero de hijos no valido");
                error = true;
            }
        } while (error);
        alday.add(empleado);
    }

}
