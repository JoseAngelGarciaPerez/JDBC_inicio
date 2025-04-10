package repos;

import util.ConexionBD;
import modelos.Cliente;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClienteRepo {

    private Connection obtenerConexion() {
        return ConexionBD.conectar();
    }

    public List<Cliente> listaDeClientes(){

        try(
                Statement statement = obtenerConexion().createStatement();
                ResultSet rs = statement.executeQuery("SELECT * FROM cliente;")
        ){
            List<Cliente> lista = new ArrayList<>();
            while(rs.next()){
                Cliente cliente = new Cliente();
                cliente.setCodigoCliente(rs.getInt("codigo_cliente"));
                cliente.setNombreCliente(rs.getString("nombre_cliente"));
                cliente.setNombreContacto(rs.getString("nombre_contacto"));
                cliente.setApellidoContacto(rs.getString("apellido_contacto"));
                cliente.setTelefono(rs.getString("telefono"));
                cliente.setFax(rs.getString("fax"));
                cliente.setLineaDireccion1(rs.getString("linea_direccion1"));
                cliente.setLineaDireccion2(rs.getString("linea_direccion2"));
                cliente.setCiudad(rs.getString("ciudad"));
                cliente.setRegion(rs.getString("region"));
                cliente.setPais(rs.getString("pais"));
                cliente.setCodigoPostal(rs.getString("codigo_postal"));
                cliente.setCodigoEmpleadoRepVentas(
                        rs.getObject("codigo_empleado_rep_ventas") != null ? rs.getInt("codigo_empleado_rep_ventas") : null
                );
                cliente.setLimiteCredito(rs.getFloat("limite_credito"));

                lista.add(cliente);
            }

            return lista;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
