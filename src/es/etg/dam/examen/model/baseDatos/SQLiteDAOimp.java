package es.etg.dam.examen.model.baseDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import es.etg.dam.examen.model.Descuento;
import es.etg.dam.examen.model.Producto;
import es.etg.dam.examen.model.Servicio;

public class SQLiteDAOimp implements BaseDatosDAO{
    private static final String URL = "jdbc:sqlite:database.db";

    @Override
    public Descuento obtenerDescuento(int id) throws BaseDatosException, SQLException {
        final String query = "SELECT descripcion, descuento FROM DESCUENTOS WHERE id = ?";
        try(Connection conn = connect(); PreparedStatement ps = conn.prepareStatement(query)){
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            String descripcion = rs.getString("descripcion");
            double descuento = rs.getInt("descuento");

            return new Descuento(descripcion, descuento);
        }
    }

    @Override
    public Producto obtenerProducto(int id) throws BaseDatosException, SQLException {
        final String query = "SELECT descripcion, precio FROM PRODUCTO WHERE id = ?";
        try(Connection conn = connect(); PreparedStatement ps = conn.prepareStatement(query)){
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            String descripcion = rs.getString("descripcion");
            double precio = rs.getDouble("precio");

            return new Producto(descripcion, precio);
        }
    }

    @Override
    public Servicio obtenerServicio(int id) throws BaseDatosException, SQLException {
        final String query = "SELECT descripcion, precio FROM SERVICIOS WHERE id = ?";
        try (Connection conn = connect(); PreparedStatement ps = conn.prepareStatement(query)){
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            String descripcion = rs.getString("descripcion");
            double precio = rs.getDouble("precio");

            return new Servicio(descripcion, precio);
        }
    }

    private Connection connect() throws SQLException{
        Connection conn = DriverManager.getConnection(URL);
        return conn;
    }
    
}
