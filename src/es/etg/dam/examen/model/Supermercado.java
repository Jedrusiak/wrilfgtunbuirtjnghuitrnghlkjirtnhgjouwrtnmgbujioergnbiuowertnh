package es.etg.dam.examen.model;

import java.util.ArrayList;
import java.util.List;

public class Supermercado implements Imprimible{
    private String nombre;
    private String id;
    private String direccion;
    private String localidad;
    private int codPostal;
    private List<Producto> listaProductos = new ArrayList<Producto>();
    private List<Servicio> listaServicios = new ArrayList<Servicio>();
    private List<Descuento> listaDescuentos = new ArrayList<Descuento>();
    
    public Supermercado(String id, String nombre, String direccion) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getId() {
        return id;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getLocalidad() {
        return localidad;
    }

    public int getCodPostal() {
        return codPostal;
    }
    public void agregar(Producto p){
        listaProductos.add(p);
    }
     public void agregar(Servicio s){
        listaServicios.add(s);
    } 
    public void agregar(Descuento d){
        listaDescuentos.add(d);
    }

    public List<Producto> getListaProductos() {
        return listaProductos;
    }

    public List<Servicio> getListaServicios() {
        return listaServicios;
    }

    public List<Descuento> getListaDescuentos() {
        return listaDescuentos;
    }
    public String obtenerImpresion(List<? extends Adquirible> listaAdquiribles){
        String contenido = "";
        for (Adquirible adquirible : listaAdquiribles) {
            contenido += adquirible.imprimir() + "\n";
        }
        return contenido;
    }

    @Override
    public String aString() {
        String productos = obtenerImpresion(listaProductos);
        String servicios = obtenerImpresion(listaServicios);
        String descuentos = obtenerImpresion(listaDescuentos);

        return productos + "\n" + servicios + "\n" + descuentos;
    }

}
