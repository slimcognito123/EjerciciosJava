package EjerAbstract3;

public class Moto extends Vehiculo {
    final float CON_CASCO = 10f;
    final float SIN_CASCO = 0.6f;

    private boolean tieneCasco;

    public Moto(String matricula, int kilometraje, boolean isAlquilao) {
        super(matricula, kilometraje, isAlquilao);
    }

    @Override
    public float calcularAlquiler() {
        if (tieneCasco) return getKilometraje() * SIN_CASCO+CON_CASCO;
        else return getKilometraje() * SIN_CASCO;
    }

    @Override
    public String mostrarDatos() {
        return super.mostrarDatos();
    }
    public void setTieneCasco(boolean tieneCasco) {
        this.tieneCasco = tieneCasco;
    }

}
