package repos;

import modelos.Oficina;
import util.ConexionBD;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OficinaRepo {

    private Connection obtenerConexion() {
        return ConexionBD.conectar();
    }

    public List<Oficina> listaDeOficinas(){

        try(
                Statement statement = obtenerConexion().createStatement();
                ResultSet rs = statement.executeQuery("SELECT * FROM oficina;")
        ){
            List<Oficina> lista = new ArrayList<>();
            while(rs.next()){
                Oficina oficina = new Oficina();

                oficina.setCodigoOficina(rs.getString("codigo_oficina"));
                oficina.setCiudad(rs.getString("ciudad"));
                oficina.setPais(rs.getString("pais"));
                oficina.setRegion(rs.getString("region"));
                oficina.setCodigoPostal(rs.getString("codigo_postal"));
                oficina.setTelefono(rs.getString("telefono"));
                oficina.setLineaDireccion1(rs.getString("linea_direccion1"));
                oficina.setLineaDireccion2(rs.getString("linea_direccion2"));

                lista.add(oficina);
            }

            return lista;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
