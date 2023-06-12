package es.etg.dam.examen.model.impresora;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import es.etg.dam.examen.model.Descuento;
import es.etg.dam.examen.model.Imprimible;
import es.etg.dam.examen.model.Producto;
import es.etg.dam.examen.model.Servicio;
import es.etg.dam.examen.model.Supermercado;

public class ImpresoraDAOimp implements ImpresoraDAO{
    private static final String FICHERO = "ticket.txt";

    @Override
    public void generarTicket(Imprimible imprimible) throws ImpresoraException, IOException {
        
        FileOutputStream fout = new FileOutputStream(FICHERO);

        fout.write(imprimible.aString().getBytes());
        fout.close();
    }
 
}
