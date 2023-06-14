package es.etg.dam.examen.model.impresora;

import java.io.FileOutputStream;
import java.io.IOException;
import es.etg.dam.examen.model.Imprimible;

public class ImpresoraDAOimp implements ImpresoraDAO{
    private static final String FICHERO = "ticket.txt";

    @Override
    public void generarTicket(Imprimible imprimible) throws ImpresoraException, IOException {
        
        FileOutputStream fout = new FileOutputStream(FICHERO);

        fout.write(imprimible.aString().getBytes());
        fout.close();
    }
}
