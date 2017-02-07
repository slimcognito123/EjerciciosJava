package modelo.DAO;

import beans.Usuario;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository(value = "usuarioDAO")
public class UsuarioDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public void insertarUsuario(Usuario usuario){
        entityManager.persist(usuario);
    }

    public boolean comprobarLogin(Usuario usuario){
        Usuario comprobar = getUsuario(usuario.getNombreUsuario());
        if (comprobar!=null && Objects.equals(comprobar.getPassword(), usuario.getPassword())) {
            return true;
        } else {
            return false;
        }
    }

    public boolean comprobarUsuarioExistente(String nombreUsuario){
        Usuario comprobar = getUsuario(nombreUsuario);
        if (comprobar!=null) {
            return true;
        }
        return false;
    }

    public Usuario getUsuario(String nombreUsuario){
        Usuario comprobar =null;
        try {
            comprobar=entityManager.find(Usuario.class,nombreUsuario);
        }catch (Exception e){
            System.out.println("no hay usuarios");
        }
        return comprobar;
    }

    public List<Usuario> recogerSeguidores(Usuario usuario) {
        Usuario usuario1 = getUsuario(usuario.getNombreUsuario());
        return usuario1.getSeguidos();
    }

    public void dejarDeSeguir(Usuario usuario, String siguiendo) {
        Usuario usuario1=getUsuario(usuario.getNombreUsuario());
        List<Usuario> lista = usuario1.getSeguidos();
        lista.remove(entityManager.find(Usuario.class,siguiendo));
    }

    public ArrayList<Usuario> buscar(Usuario buscador, String nombre) {
        String query = "Select usuario FROM Usuario usuario where usuario.nombreUsuario like :nombre and usuario not like :buscador";
        Query pregunta = entityManager.createQuery(query);
        pregunta.setParameter("nombre", '%'+nombre+'%');
        pregunta.setParameter("buscador", buscador);
        ArrayList<Usuario> resultados=null;
        try{
            resultados = (ArrayList<Usuario>) pregunta.getResultList();
        }catch (Exception e){
            System.out.println(e);
        }

        return resultados;
    }

    public List<Usuario> seguir(Usuario usuario, String follow) {
        Usuario usuario1=getUsuario(usuario.getNombreUsuario());
        List<Usuario> lista = usuario1.getSeguidos();
        Usuario usuarioSeguido = entityManager.find(Usuario.class, follow);
        if (!lista.contains(usuarioSeguido))lista.add(usuarioSeguido);
        usuario1.setSeguidos(lista);
        entityManager.merge(usuario1);
        return lista;
    }

    public void modificar(Usuario modificacion) {
        entityManager.merge(modificacion);
    }

    public void setEstado(Usuario usuario, String estado) {
        Usuario usuario1=getUsuario(usuario.getNombreUsuario());
        usuario1.setEstado(estado);
        entityManager.merge(usuario1);
    }

}
