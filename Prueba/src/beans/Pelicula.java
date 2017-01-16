package beans;

import javax.persistence.*;

@Entity
@SequenceGenerator(name = "idPeli", sequenceName = "peliculasId")
public class Pelicula {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "idPeli")
    private Long id;
    private String nombre;
    private Integer duration;
    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Descuento descuento;

    public Pelicula() {

    }

    public Pelicula(String nombre, Integer duration, Descuento descuento) {
        this.nombre = nombre;
        this.duration = duration;
        this.descuento = descuento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }


    public void setDescuento(Descuento descuento) {
        this.descuento = descuento;
    }
}
