package EjerEsquema;

import java.io.*;

public class FicheroEscritura {
    FileWriter fichero;
    BufferedWriter bufferDelFichero;
    String nombreFichero;

    public FicheroEscritura(String nombreFichero,boolean addend) {
        this.nombreFichero = nombreFichero;
        this.fichero = initFileWriter(addend);
        this.bufferDelFichero = new BufferedWriter(fichero);
        /*System.out.println(this.nombreFichero);
        System.out.println(this.bufferDelFichero);
        System.out.println(this.fichero);*/
    }

    private FileWriter initFileWriter(boolean addend) {
        try {
            return new FileWriter(this.nombreFichero,addend);
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
