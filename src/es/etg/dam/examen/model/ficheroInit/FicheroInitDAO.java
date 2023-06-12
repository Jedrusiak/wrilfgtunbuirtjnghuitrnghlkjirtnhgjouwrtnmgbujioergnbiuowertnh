package es.etg.dam.examen.model.ficheroInit;

import java.io.IOException;

import es.etg.dam.examen.model.Supermercado;

public interface FicheroInitDAO {
    public Supermercado inicializarSupermercado() throws FicheroInitException, IOException; 
}
