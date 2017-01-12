package DAO.Usuarios;

public class Usuario {
    private String nomUsuario;
    private String password;
    private String email;
    public Usuario(String usuario, String password, String email) {
        this.nomUsuario=usuario;
        this.password=password;
        this.email=email;
    }

    public String getNomUsuario() {
        return nomUsuario;
    }


    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

}
