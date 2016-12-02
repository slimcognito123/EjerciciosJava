package EjerAbstract3;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by curso mañana on 02/12/2016.
 */
public class MenuCompania extends Menu {

    ArrayList<Vehiculo> listaVehiculos;

    public MenuCompania() {
        listaVehiculos = new ArrayList<>();
        menu.add("1.Dar de alta un vehiculo");
        menu.add("2.Alquilar un vehiculo");
        menu.add("3.Devolver un vehiculo");
        menu.add("4.Mostrar todos los vehiculos");
        menu.add("0.Salir");
    }

    @Override
    public boolean seleccionar(int opcion) {
        switch (opcion) {
            case 1:
                darDeAlta();
                break;
            case 2:
                alquilarVehiculos();
                break;
            case 3:
                devolverVehiculo();
                break;
            case 4:
                mostrarVehiculos();
                break;
            case 0:
                return false;
        }
        return true;
    }

    private void darDeAlta() {
        boolean error = false;
        String matricula;
        int kilometraje = 0;
        boolean estado = false;
        int tipo = 0;
        do {
            error = false;
            try {
                tipo = Integer.parseInt(pedirDatos("tipo de vehiculo a introducir:\n1.Coche\n2.Moto\n3.Furgoneta"));
                if (tipo != 1 && tipo != 2 && tipo != 3) {
                    System.out.println("Opcion no valida");
                    error = true;
                }
            } catch (Exception e) {
                System.out.println("Introduce un numero");
                error = true;
            }
        } while (error);

        matricula = pedirDatos("introduce matricula");


        if (tipo == 1) {
            listaVehiculos.add(new Coche(matricula, kilometraje, estado));
        } else if (tipo == 2) {
            listaVehiculos.add(new Moto(matricula, kilometraje, estado));
        } else {
            int capacidad = 0;
            do {
                error = false;
                try {
                    capacidad = Integer.parseInt(pedirDatos("Cuanta carga tiene la furgoneta?"));
                } catch (Exception e) {
                    System.out.println("eso no es un numero!");
                    error = true;
                }
            } while (error);
            listaVehiculos.add(new Furgoneta(matricula, kilometraje, estado, capacidad));
        }
    }

    private int getKilometraje() {
        boolean error;
        int kilometraje = 0;
        do {
            error = false;
            try {
                kilometraje = Integer.parseInt(pedirDatos("kilometraje hecho"));
            } catch (Exception e) {
                System.out.println("Introduce un numero");
                error = true;
            }
        } while (error);
        return kilometraje;
    }

    private boolean hasComplements(String dato, String x) {
        boolean error;
        boolean tieneCasco = false;
        do {
            error = false;
            String casco = pedirDatos(dato);
            if (casco.equals("Y") || casco.compareTo("y") == 0) tieneCasco = true;
            else if (casco.equals("N") || casco.compareTo("n") == 0) tieneCasco = false;
            else {
                System.out.println(x);
                error = true;
            }
        } while (error);
        return tieneCasco;
    }

    private boolean isExtras() {
        boolean extras = hasComplements("el coche tiene extras? Y or N", "esa no es una opcion valida\n");
        return extras;
    }

    private String pedirDatos(String dato) {
        System.out.println(dato);
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }


    private void alquilarVehiculos() {
        for (Vehiculo vehiculo : listaVehiculos) {
            if (!vehiculo.isAlquilao()) {
                if (vehiculo instanceof Moto)
                    System.out.println("\nMoto:");
                else if (vehiculo instanceof Coche)
                    System.out.println("\nCoche:");
                else
                    System.out.println("\nFurgoneta:");
                System.out.println(vehiculo.mostrarDatos());
            }
        }
        String matricula = pedirDatos("\nelije un vehiculo de la lista escribiendo la matricula");
        boolean alquiler = false;
        for (Vehiculo vehiculo : listaVehiculos) {
            if (!vehiculo.isAlquilao() && vehiculo.getMatricula().equals(matricula)) {
                vehiculo.Alquilar();
                if (vehiculo instanceof Moto)
                    ((Moto) vehiculo).setTieneCasco(hasComplements("la moto tiene casco? Y or N", "esa no es una opcion valida"));
                else if (vehiculo instanceof Coche) ((Coche) vehiculo).setHasExtras(isExtras());
                alquiler = true;
            }
        }
        if (!alquiler) System.out.println("se metio una matricula incorrecta o de un coche ya alquilado\n");
    }

    private void devolverVehiculo() {
        for (Vehiculo vehiculo : listaVehiculos) {
            if (vehiculo.isAlquilao()) {
                System.out.println("\n" + vehiculo.mostrarDatos() + "\n");
            }
        }
        String matricula = pedirDatos("\nelije un vehiculo de la lista escribiendo la matricula");
        boolean alquiler = false;
        for (Vehiculo vehiculo : listaVehiculos) {
            if (vehiculo.isAlquilao() && vehiculo.getMatricula().equals(matricula)) {
                int kilometraje = getKilometraje();
                vehiculo.setKilometraje(kilometraje);
                vehiculo.devolver();
                System.out.println("debes pagar " + vehiculo.calcularAlquiler() + " por tus " + vehiculo.getKilometraje() + " kms\n");
                alquiler = true;
            }
        }
        if (!alquiler) System.out.println("se metio una matricula incorrecta o de un coche sin alquilar\n");
    }

    private void mostrarVehiculos() {
        for (Vehiculo vehiculo : listaVehiculos) {
            if (!vehiculo.isAlquilao()) {
                if (vehiculo instanceof Moto)
                    System.out.println("\nMoto:");
                else if (vehiculo instanceof Coche)
                    System.out.println("\nCoche:");
                else
                    System.out.println("\nFurgoneta:");
                System.out.println(vehiculo.mostrarDatos());
            }
        }
        System.out.println("\n");
    }
}
