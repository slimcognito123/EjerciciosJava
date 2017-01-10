package DAO.BaseDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectorBD {
    public static final String BBDD = "AgendaBD";
    public static final String USER = "root";
    public static final String PASSWORD = "root";
    private Connection connection;

    public ConectorBD() {
        getConnection();
    }


    public void connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.connection = DriverManager.getConnection("jdbc:mysql://localhost/" + BBDD, USER, PASSWORD);
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Driver JDBC no encontrado");
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
}
