package Beans;

public class BusquedaOferta {
    private double precio;
    private int numeroNoches;

    public BusquedaOferta() {
    }

    public BusquedaOferta(double precio, int numeroNoches) {
        this.precio = precio;
        this.numeroNoches = numeroNoches;
    }

    public int getNumeroNoches() {
        return numeroNoches;
    }

    public void setNumeroNoches(int numeroNoches) {
        this.numeroNoches = numeroNoches;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
