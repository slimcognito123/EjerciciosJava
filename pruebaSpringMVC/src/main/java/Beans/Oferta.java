package Beans;

public class Oferta
{
    private double precio;
    private int numeroNoches;
    private String hotel;

    public Oferta() {

    }

    public Oferta(double precio, int numeroNoches, String hotel) {
        this.precio = precio;
        this.numeroNoches = numeroNoches;
        this.hotel = hotel;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getNumeroNoches() {
        return numeroNoches;
    }

    public void setNumeroNoches(int numeroNoches) {
        this.numeroNoches = numeroNoches;
    }

    public String getHotel() {
        return hotel;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }
}
