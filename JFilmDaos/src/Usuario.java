import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Patata kawaii on 18/01/2017.
 */
@Entity
public class Usuario {
    @Id
    private String NombreUsuario;
    private String Password;


    public Usuario() {
    }

    public Usuario(String nombreUsuario, String password) {
        NombreUsuario = nombreUsuario;
        Password = password;
    }

    public String getNombreUsuario() {

        return NombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        NombreUsuario = nombreUsuario;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
