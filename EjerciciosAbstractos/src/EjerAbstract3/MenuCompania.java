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
                if (tipo != 1 || tipo != 2 || tipo != 3) {
                    System.out.println("Opcion no valida");
                    error = true;
                }
            } catch (Exception e) {
                System.out.println("Introduce un numero");
                error = true;
            }
        } while (error);

        matricula = pedirDatos("introduce matricula");

        do {
            error = false;
            try {
                kilometraje = Integer.parseInt(pedirDatos("kilometraje hecho"));
            } catch (Exception e) {
                System.out.println("Introduce un numero");
                error = true;
            }
        } while (error);

        if (tipo == 1) {
            boolean extras = false;
            do {
                error = false;
                String tieneExtras = pedirDatos("el coche tiene extras? Y or N");
                if (tieneExtras == "Y") extras = true;
                else if (tieneExtras == "N") extras = false;
                else {
                    System.out.println("esa no es una opcion valida");
                    error = true;
                }
            } while (error);
            listaVehiculos.add(new Coche(matricula, kilometraje, estado, extras));

        } else if (tipo == 2) {
            boolean tieneCasco = false;
            do {
                error = false;
                String casco = pedirDatos("la moto tiene casco? Y or N");
                if (casco == "Y") tieneCasco = true;
                else if (casco == "N") tieneCasco = false;
                else {
                    System.out.println("esa no es una opcion valida");
                    error = true;
                }
            } while (error);
            listaVehiculos.add(new Moto(matricula, kilometraje, estado, tieneCasco));
        } else {
            int capacidad = 0;
            do {
                error = false;
                try {
                    capacidad = Integer.parseInt(pedirDatos("el coche tiene extras? Y or N"));
                } catch (Exception e) {
                    System.out.println("eso no es un numero!");
                }
            } while (error);
            listaVehiculos.add(new Furgoneta(matricula, kilometraje, estado, capacidad));
        }
    }

    private String pedirDatos(String dato) {
        System.out.println(dato);
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }


    private void alquilarVehiculos() {
        for (Vehiculo vehiculo : listaVehiculos) {
            if (!vehiculo.isAlquilao()) {
                System.out.println("\n"+vehiculo.mostrarDatos());
            }
        }
        String matricula = pedirDatos("\nelije un vehiculo de la lista escribiendo la matricula");
        boolean alquiler=false;
        for (Vehiculo vehiculo : listaVehiculos) {
            if(!vehiculo.isAlquilao()&&vehiculo.getMatricula().equals(matricula)){
                vehiculo.Alquilar();
                alquiler=true;
            }
        }
        if(!alquiler)System.out.println("se metio una matricula incorrecta o de un coche ya alquilado\n");
    }

    private void devolverVehiculo() {
        for (Vehiculo vehiculo : listaVehiculos) {
            if (vehiculo.isAlquilao()) {
                System.out.println("\n"+vehiculo.mostrarDatos());
            }
        }
        String matricula = pedirDatos("\nelije un vehiculo de la lista escribiendo la matricula");
        boolean alquiler=false;
        for (Vehiculo vehiculo : listaVehiculos) {
            if(!vehiculo.isAlquilao()&&vehiculo.getMatricula().equals(matricula)){
                vehiculo.devolver();
                System.out.println("debes pagar "+vehiculo.calcularAlquiler(100)+"por tus 100 kms");
                alquiler=true;
            }
        }
        if(!alquiler)System.out.println("se metio una matricula incorrecta o de un coche sin alquilar\n");
    }

    private void mostrarVehiculos() {
        for (Vehiculo vehiculo : listaVehiculos) {
            System.out.println(vehiculo.mostrarDatos());
        }
    }
}
