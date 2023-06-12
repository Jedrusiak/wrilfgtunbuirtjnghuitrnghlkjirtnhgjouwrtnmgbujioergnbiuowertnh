package es.etg.dam.examen.model.ficheroInit;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import es.etg.dam.examen.model.Supermercado;
/* Lo que hace esta clase es 1- Leer el contenido del fichero y almacenarlo en un String, 2- tockenizar el contenido marcando el delimitador y almacenarlo en un List<String> y con las partes que necesitemos devolvemos un Supermercado */
public class FicheroInitImp implements FicheroInitDAO{
    private static final String FICHERO = "fichero.txt";

    @Override
    public Supermercado inicializarSupermercado() throws FicheroInitException, IOException {
        String contenido = leerFicehro(FICHERO);
        List<String> listaContenido = procesar(contenido);
        Supermercado supermercado = new Supermercado(listaContenido.get(0),listaContenido.get(1),listaContenido.get(2));

        return supermercado;
    }
    private String leerFicehro(String fichero) throws IOException{
        FileInputStream fin = new FileInputStream(fichero); 
        String contenido = new String (fin.readAllBytes());
        fin.close();

        return contenido;
    }
    public List<String> procesar(String contenido){
        final String DELIMITADOR = ";";
        List<String> lista = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(contenido, DELIMITADOR);
        while(st.hasMoreTokens()){
            lista.add(st.nextToken());
        }
        return lista;
    }
}