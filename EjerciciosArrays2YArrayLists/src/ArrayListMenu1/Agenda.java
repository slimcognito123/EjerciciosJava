package ArrayListMenu1;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Created by curso mañana on 30/11/2016.
 */
public class Agenda {
    Menu menu;
    static private ArrayList<Persona> personList;

    public Agenda() {
        personList=new ArrayList<>();
        menu = new Menu();
        menu.addMenu("1.Añadir Persona");
        menu.addMenu("2.Borrar Persona");
        menu.addMenu("3.Buscar Persona");
        menu.addMenu("4.Mostrar Agenda");
        menu.addMenu("5.Mostrar por mes");
        menu.addMenu("0.Salir");
        System.out.println("bienvenido al controlador:");
        boolean continuar = true;
        do {
            menu.showMenu();
            Scanner scan;
            try {
                scan= new Scanner(System.in);
                int envio = scan.nextInt();
                continuar = opcion(envio);
            } catch (InputMismatchException e) {
                System.out.println("introduce un numero para seleccionar una opcion");
            }/*catch (NoSuchElementException r){
                System.out.println("holiwis :3");
            }*/
        } while (continuar);
    }

    private boolean opcion(int envio) {
        switch (envio) {
            case 1:
                anadirPersona();
                break;
            case 2:
                borrarPersona();
                break;
            case 3:
                buscarPersonaDNI();
                break;
            case 4:
                mostrarAgenda();
                break;
            case 5:
                buscarPorMes();
                break;
            case 0:
                return false;
        }
        return true;
    }

    private void buscarPersonaDNI() {

        Persona persona=buscarDNI();
        if (persona==null){
            System.out.println("No se encuentra esa persona");
        }else{
            persona.showPerson();
        }
    }

    private void mostrarAgenda() {
        for (Persona persona : personList) {
            persona.showPerson();
        }
    }

    private void borrarPersona() {
        personList.remove(buscarDNI());
    }

    private Persona buscarDNI() {
        System.out.println("encuentra la persona buscando el DNI");
        String scan;
        try {
            Scanner escaner = new Scanner(System.in);
            scan = escaner.nextLine();
            for (Persona persona : personList) {
                if (persona.getDni().compareTo(scan)==0){
                    return persona;
                }
            }
        }catch (Exception e){
            System.out.println("error de busqueda");
        }

        return null;
    }

    private void buscarPorMes() {
        int mes=0;
        try{
            Scanner scan = new Scanner(System.in);
            mes=scan.nextInt();
        }catch(Exception e){
            System.out.println("mes no valido");
        }
        boolean contado=false;
        for (Persona persona : personList) {
            if (persona.getFechaNacimiento().getMes()==mes) {
                persona.showPerson();
                contado=true;
            }
        }
        if(!contado)System.out.println("no se ha encontrado ningun usuario");
    }

    private void anadirPersona() {
        boolean error = false;
        Persona persona = new Persona();

        System.out.println("introduce nombre de la Persona:");
        Scanner scan = new Scanner(System.in);
        String nombre = scan.nextLine();
        persona.setNombre(nombre);

        System.out.println("introduce apellido de la persona:");
        scan = new Scanner(System.in);
        String apellido = scan.nextLine();
        persona.setApellido(apellido);

        do {
            error = false;
            System.out.println("introduce tlf de la persona:");
            scan = new Scanner(System.in);
            String tlf = scan.nextLine();
            persona.setTlf(tlf);
            try {
                Integer.parseInt(tlf);
            } catch (Exception e) {
                System.out.println("no es un numero");
                error = true;
            }

        } while (error);

        System.out.println("introduce DNI de la persona:");
        scan = new Scanner(System.in);
        String dni = scan.nextLine();
        persona.setDni(dni);

        do {
            error = false;
            System.out.println("introduce Fecha de nacimiento:\n");
            scan = new Scanner(System.in);
            System.out.println("dia:");
            String dia = scan.nextLine();
            scan = new Scanner(System.in);
            System.out.println("mes:");
            String mes = scan.nextLine();
            scan = new Scanner(System.in);
            System.out.println("año:");
            String ano = scan.nextLine();

            if (!comprobarFecha(dia, mes, ano)) {
                System.out.println("fecha incorrecta");
                error = true;
            }else{
                persona.setFechaNacimiento(new Fecha(Integer.parseInt(dia),Integer.parseInt(mes),Integer.parseInt(ano)));
            }
        } while (error);
        personList.add(persona);
    }

    private boolean comprobarFecha(String dia, String mes, String ano) {
        int day=0,month=0,year=0;
        try{
            day=Integer.parseInt(dia);
            month=Integer.parseInt(mes);
            year=Integer.parseInt(ano);
        }catch(Exception e){
            System.out.println("error de conversion");
            return false;
        }
        return true;
    }

    public static void main(String[] args){
        new Agenda();
    }
}
