package EjerAbstract3;

public abstract class Vehiculo {
    private String matricula;


    private int kilometraje;
    private boolean isAlquilao;


    public Vehiculo(String matricula, int kilometraje, boolean isAlquilao) {
        this.matricula = matricula;
        this.kilometraje = kilometraje;
        this.isAlquilao = isAlquilao;
    }

    public boolean isAlquilao() {
        return isAlquilao;
    }

    public void Alquilar() {
        isAlquilao = true;
    }

    public void devolver() {
        isAlquilao = false;
    }

    public String mostrarDatos() {
        return "matricula: " + matricula + "\nkilometros:" + kilometraje + "\nesta alquilado:" + isAlquilao;
    }

    public abstract float calcularAlquiler();

    public String getMatricula() {
        return matricula;
    }

    public int getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(int kilometraje) {
        this.kilometraje = kilometraje;
    }
}
