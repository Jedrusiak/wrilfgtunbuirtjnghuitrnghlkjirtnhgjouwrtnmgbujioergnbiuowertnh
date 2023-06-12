package es.etg.dam.examen.model.impresora;

import java.io.FileNotFoundException;
import java.io.IOException;

import es.etg.dam.examen.model.Supermercado;

public interface ImpresoraDAO {
    public void generarTicket(Supermercado supermercado) throws ImpresoraException, FileNotFoundException, IOException;
}
