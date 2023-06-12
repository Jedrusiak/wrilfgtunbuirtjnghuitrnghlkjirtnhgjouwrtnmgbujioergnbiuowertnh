package es.etg.dam.examen.model;

public class Producto extends Adquirible {

    public Producto(String descripcion, double precio) {
        super(descripcion, precio);
    }

    @Override
    public String toString() {
        return descripcion + " " + precio;
    }
}
