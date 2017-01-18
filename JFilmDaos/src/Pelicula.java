import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Created by Patata kawaii on 18/01/2017.
 */
@Entity
public class Pelicula {
    @Id
    @GeneratedValue
    private Integer id;
    private String titulo;
    private String portada;
    private String descripcion;
    private LocalDate fechaEstreno;
    @ManyToMany
    private ArrayList<Celebrity> famosos;

    public Pelicula() {
    }

    public Pelicula(String titulo, String portada, String descripcion, LocalDate fechaEstreno) {
        this.titulo = titulo;
        this.portada = portada;
        this.descripcion = descripcion;
        this.fechaEstreno = fechaEstreno;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getPortada() {
        return portada;
    }

    public void setPortada(String portada) {
        this.portada = portada;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFechaEstreno() {
        return fechaEstreno;
    }

    public void setFechaEstreno(LocalDate fechaEstreno) {
        this.fechaEstreno = fechaEstreno;
    }

    public ArrayList<Celebrity> getFamosos() {
        return famosos;
    }

    public void setFamosos(ArrayList<Celebrity> famosos) {
        this.famosos = famosos;
    }
}
