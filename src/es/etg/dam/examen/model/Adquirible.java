package es.etg.dam.examen.model;

public abstract class Adquirible {
    protected String descripcion;
    protected double precio;

    public Adquirible(String descripcion, double precio) {
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getPrecio() {
        return precio;
    }
    
}
