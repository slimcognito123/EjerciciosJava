package beans;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Created by Patata kawaii on 05/02/2017.
 */
@Entity
@SequenceGenerator(name = "generarJuegos", sequenceName = "IdJuego")
public class juegos {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generarJuegos")
    private Integer idJuego;
    private String titulo;
    private String genero;
    private String descripcion;
    private Double precio;
    @Column(columnDefinition = "Tinyint(1)")
    private Boolean vendido=false;
    @OneToOne
    private Usuario Vendedor;
    private LocalDate fechaVenta;
}
