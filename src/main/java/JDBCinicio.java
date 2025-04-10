import java.sql.*;
import util.ConexionBD;

public class JDBCinicio {
    public static void main(String[] args) {

            try (Connection connection = ConexionBD.conectar()) {
                Statement statement;
                ResultSet rs;

                statement = connection.createStatement();
                rs = statement.executeQuery("SELECT * FROM cliente");

                while(rs.next()) {
                    int id = rs.getInt(1);
                    String nombre = rs.getString(2);

                    System.out.println(id + " - " + nombre);
                }

                Statement statement2;
                ResultSet rs2;

                statement2 = connection.createStatement();
                rs2 = statement2.executeQuery("SELECT * FROM pedido");

                while(rs2.next()) {
                    int id = rs2.getInt(1);
                    String nombre = rs2.getString(2);

                    System.out.println(id + " - " + nombre);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }



    }
}
