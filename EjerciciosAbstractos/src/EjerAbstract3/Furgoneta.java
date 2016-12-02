package EjerAbstract3;

/**
 * Created by curso mañana on 02/12/2016.
 */

public class Furgoneta extends Vehiculo {
    private final float PRECIO = 0.5f;
    private int capacidadCarga;

    public Furgoneta(String matricula, int kilometraje, boolean isAlquilao, int capacidadCarga) {
        super(matricula, kilometraje, isAlquilao);
        this.capacidadCarga = capacidadCarga;
    }


    @Override
    public float calcularAlquiler() {
        return getKilometraje() * PRECIO;
    }

    @Override
    public String mostrarDatos() {
        return super.mostrarDatos() + "\ncapacidad de carga: " + capacidadCarga;
    }
}
