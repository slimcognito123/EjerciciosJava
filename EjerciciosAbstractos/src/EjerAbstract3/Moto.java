package EjerAbstract3;

public class Moto extends Vehiculo {
    final float CON_CASCO = 0.6f;
    final float SIN_CASCO = 10f;
    private boolean tieneCasco;

    public Moto(String matricula, int kilometraje, boolean isAlquilao, boolean tieneCasco) {
        super(matricula, kilometraje, isAlquilao);
        this.tieneCasco = tieneCasco;
    }

    @Override
    public float calcularAlquiler(float km) {
        if (tieneCasco) return km * CON_CASCO;
        else return km * SIN_CASCO;
    }

    @Override
    public String mostrarDatos() {
        return super.mostrarDatos() + "\ntiene casco: " + tieneCasco;
    }
}
