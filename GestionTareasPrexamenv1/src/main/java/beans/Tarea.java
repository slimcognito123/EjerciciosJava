package beans;

import javax.persistence.*;

@Entity
@SequenceGenerator(name = "generarTareas", sequenceName = "IdTarea")
public class Tarea {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generarTareas")
    private Integer idTarea;
    private String titulo;
    private String descripcion;
    @Column(columnDefinition = "Tinyint(1)")
    private Boolean realizada=false;
    @OneToOne
    private Usuario usuarioRealiza;
    private String fechaRealizacion;

    public Tarea() {
    }

    public Tarea(String titulo, String descripcion) {
        this.titulo = titulo;
        this.descripcion = descripcion;
    }

    public Integer getIdTarea() {
        return idTarea;
    }

    public void setIdTarea(Integer idTarea) {
        this.idTarea = idTarea;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setRealizada(Boolean realizada) {
        this.realizada = realizada;
    }

    public Usuario getUsuarioRealiza() {
        return usuarioRealiza;
    }

    public void setUsuarioRealiza(Usuario usuarioRealiza) {
        this.usuarioRealiza = usuarioRealiza;
    }

    public String getFechaRealizacion() {
        return fechaRealizacion;
    }

    public void setFechaRealizacion(String fechaRealizacion) {
        this.fechaRealizacion = fechaRealizacion;
    }

    public boolean isRealizada() {
        return this.realizada;
    }
}
