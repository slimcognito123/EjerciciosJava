import java.sql.Connection;
import java.sql.DriverManager;

public class AgenteConexion {
    protected static AgenteConexion mInstancia = null;
    protected Connection mBD;

    protected AgenteConexion() throws Exception {
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        String url = "jdbc:odbc.JdbcOdbcDriver";
        mBD = DriverManager.getConnection(url);
    }

    public static AgenteConexion getAgente() throws Exception {
        if (mInstancia == null) {
            mInstancia = new AgenteConexion();
        }
        return mInstancia;
    }

}