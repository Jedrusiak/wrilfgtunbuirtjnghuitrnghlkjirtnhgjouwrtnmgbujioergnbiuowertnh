package es.etg.dam.examen.model;

public class Descuento extends Adquirible{

    public Descuento(String descripcion, double precio) {
        super(descripcion, precio);
    }
    @Override
    public String toString() {
        return descripcion + " " + precio;
    }
}
