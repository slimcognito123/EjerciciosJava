package beans;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@SequenceGenerator(name = "comotedelagana", sequenceName = "descuentoId")
public class Descuento {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "comotedelagana")
    private Integer id;
    private int value;
    private LocalDate fechaFinal;


    public Descuento() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setFechaFinal(LocalDate fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
