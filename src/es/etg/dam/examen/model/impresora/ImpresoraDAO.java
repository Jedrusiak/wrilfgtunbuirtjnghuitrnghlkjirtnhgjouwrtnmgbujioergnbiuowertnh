package es.etg.dam.examen.model.impresora;

import java.io.FileNotFoundException;
import java.io.IOException;

import es.etg.dam.examen.model.Imprimible;

public interface ImpresoraDAO {
    public void generarTicket(Imprimible imprimible) throws ImpresoraException, FileNotFoundException, IOException;
}
