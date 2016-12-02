package EjerAbstract3;

/**
 * Created by curso mañana on 02/12/2016.
 */
public class Coche extends Vehiculo {
    private final float PRECIO_KILOMETRO = 0.4f;
    private final int PRECIO_EXTRAS = 20;
    private boolean hasExtras;

    public Coche(String matricula, int kilometraje, boolean isAlquilao, boolean hasExtras) {
        super(matricula, kilometraje, isAlquilao);
        this.hasExtras = hasExtras;
    }


    @Override
    public float calcularAlquiler(float kilometros) {
        if (hasExtras) return kilometros * PRECIO_KILOMETRO + PRECIO_EXTRAS;
        else return kilometros * PRECIO_KILOMETRO;
    }

    @Override
    public String mostrarDatos() {
        return super.mostrarDatos() + "\ntiene extras: " + hasExtras;
    }
}
