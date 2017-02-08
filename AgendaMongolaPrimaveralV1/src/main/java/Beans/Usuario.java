package Beans;

import org.bson.types.ObjectId;

import java.util.List;

public class Usuario {

    private ObjectId _id;
    private String nombre;
    private String password;

    private List<ObjectId> listaContactos;

    public Usuario() {
    }

    public Usuario(String nombre, String password) {
        super();
        this.nombre = nombre;
        this.password = password;
    }

    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<ObjectId> getListaContactos() {
        return listaContactos;
    }

    public void setListaContactos(List<ObjectId> listaContactos) {
        this.listaContactos = listaContactos;
    }
}
