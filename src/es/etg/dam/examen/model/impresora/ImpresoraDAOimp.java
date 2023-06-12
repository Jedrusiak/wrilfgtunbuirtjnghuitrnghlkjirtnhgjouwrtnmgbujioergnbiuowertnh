package es.etg.dam.examen.model.impresora;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import es.etg.dam.examen.model.Descuento;
import es.etg.dam.examen.model.Producto;
import es.etg.dam.examen.model.Servicio;
import es.etg.dam.examen.model.Supermercado;

public class ImpresoraDAOimp implements ImpresoraDAO{
    private static final String FICHERO = "ticket.txt";

    @Override
    public void generarTicket(Supermercado supermercado) throws ImpresoraException, IOException {
        List<Producto> listaProductos = supermercado.getListaProductos();
        List<Servicio> listaServicio = supermercado.getListaServicios();
        List<Descuento> listaDescuentos = supermercado.getListaDescuentos();
        String contenido = "";
        byte[] datos;
        for (Producto producto : listaProductos) {
            contenido += producto.toString() + "\n";
        }
        for (Servicio servicio : listaServicio) {
            contenido += servicio.toString() + "\n";
        }
        for (Descuento descuento : listaDescuentos) {
            contenido += descuento.toString() + "\n";
        }
        FileOutputStream fout = new FileOutputStream(FICHERO);
        datos = contenido.getBytes();
        fout.write(datos);
        fout.close();
    }
 
}
