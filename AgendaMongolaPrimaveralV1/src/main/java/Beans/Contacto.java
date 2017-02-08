package Beans;

import org.bson.types.ObjectId;

//
//@Entity
//@SequenceGenerator(name = "generadorContactos",sequenceName = "IdContactos")
public class Contacto {
//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "generadorContactos")
    private ObjectId _id;
    private String nombre;
    private String apellidos;
    private String telefono;
    private String fecha;
    private String user;

    public Contacto() {
    }

    public Contacto(String nombre, String apellidos, String telefono, String fecha, String user) {

        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.fecha = fecha;
        this.user = user;
    }

    public Contacto(ObjectId _id, String nombre, String apellidos, String telefono, String fecha, String user) {
        this._id=_id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.fecha = fecha;
        this.user = user;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
