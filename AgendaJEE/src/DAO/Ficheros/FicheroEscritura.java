package DAO.Ficheros;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class FicheroEscritura {
    FileWriter fichero;
    BufferedWriter bufferDelFichero;
    String nombreFichero;

    public FicheroEscritura(String nombreFichero,boolean addEnd) {
        this.nombreFichero = nombreFichero;
        this.fichero = initFileWriter(addEnd);
        this.bufferDelFichero = new BufferedWriter(fichero);
    }

    private FileWriter initFileWriter(boolean addEnd) {
        try {
            return new FileWriter(this.nombreFichero,addEnd);
        } catch (FileNotFoundException e) {
            System.out.println("no se ha encontrado el fichero " + e);
        } catch (IOException e) {
            System.out.println("ha habido un fallo en el al iniciar el archivo " + e);
        }
        return null;
    }

    public void escribirLinea(String contenido){
        try {
            System.out.println(contenido);
            bufferDelFichero.write(contenido);
            bufferDelFichero.newLine();
        } catch (IOException e) {
            this.bufferDelFichero = new BufferedWriter(fichero);
            this.escribirLinea(contenido);
        }
    }

    public void cerrar() {
        try {
            if (bufferDelFichero != null) bufferDelFichero.close();//tiene que ser primero el buffer y despues el fichero
            if (fichero != null) fichero.close();//si no se cierra el fichero sin guardar la informacion del buffer
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
