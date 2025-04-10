package util;

import java.sql.*;

public class ConexionBD {
    private static String url = "jdbc:mysql://127.0.0.1:3306/jardineria";
    private static String usuario = "root";
    private static String clave = "Admin12345;";
    private static Connection connection;


    public static Connection conectar()
    {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(url, usuario, clave);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        return connection;
    }


    public static void desconectar(Connection connection)
    {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
