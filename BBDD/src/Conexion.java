import java.sql.*;

public class Conexion {
    public static final String BBDD = "biblioteca";
    public static final String USER = "root";
    public static final String PASSWORD = "root";
    private Connection connection;

    public Conexion() {
        getConnection();
    }


    public void connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.connection = DriverManager.getConnection("jdbc:mysql://localhost/" + BBDD, USER, PASSWORD);
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Driver JBDC no encontrado");
            cnfe.printStackTrace();
        } catch (SQLException sqle) {
            System.out.println("Error al conectarse a la BD");
            sqle.printStackTrace();
        } catch (Exception e) {
            System.out.println("Error general");
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        if (connection == null) {
            this.connect();
        }
        return connection;
    }

    public static void main(String[] args) {
        Conexion con = new Conexion();

        con.connect();
        try {
            Statement st = con.getConnection().createStatement();

            st.execute("CREATE TABLE if not EXISTS libros (id int, title VARCHAR (200))");
            st.executeUpdate("INSERT INTO libros VALUES (4,'hoiwis')");
            st.executeUpdate("INSERT INTO libros VALUES(1,'qwertyu')");
            st.executeUpdate("INSERT INTO libros VALUES (2,'asdfghj')");
            st.executeUpdate("INSERT INTO libros VALUES(3,'zxcvbnm')");
            ResultSet rs = st.executeQuery("SELECT * FROM libros");
            while (rs.next()){
                System.out.println("el id es "+rs.getInt(1)+" el titulo es "+rs.getString("title"));
            }
            st.close();
            con.getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
