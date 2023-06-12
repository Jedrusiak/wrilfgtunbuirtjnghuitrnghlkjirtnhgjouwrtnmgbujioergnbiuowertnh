package es.etg.dam.examen.model;

public class Servicio extends Adquirible{

    public Servicio(String descripcion, double precio) {
        super(descripcion, precio);
    }
    @Override
    public String toString() {
        return descripcion + " " + precio;
    }
}
