package es.etg.dam.examen.model.baseDatos;

import java.sql.SQLException;

import es.etg.dam.examen.model.Descuento;
import es.etg.dam.examen.model.Producto;
import es.etg.dam.examen.model.Servicio;

public interface BaseDatosDAO {
    public Descuento obtenerDescuento(int id) throws BaseDatosException, SQLException;
    public Producto obtenerProducto(int id) throws BaseDatosException, SQLException;
    public Servicio obtenerServicio(int id) throws BaseDatosException, SQLException;
}
