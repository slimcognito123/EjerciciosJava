package arrayListMenu2;

/**
 * Created by curso mañana on 01/12/2016.
 */
public class Coche {
    private String matricula;
    private String marca;
    private String modelo;
    private Integer kilometros;

    public Coche() {
        //blablablababla
    }

    public Coche(String matricula, String marca, String modelo, Integer kilometros) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.kilometros = kilometros;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getKilometros() {
        return kilometros;
    }

    public void setKilometros(Integer kilometros) {
        this.kilometros = kilometros;
    }

    @Override
    public String toString() {
        return "Coche{" +
                "matricula='" + matricula + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", kilometros=" + kilometros +
                '}';
    }
}
