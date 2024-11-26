package com.example.abp_android.model;

import java.io.Serializable;

public class Actividad implements Serializable {
    private int id;
    private String nombre;
    private String descripcion;
    private int cupo;
    private int precio;
    private String fecha;
    private String imagen;
    private boolean isExpanded = false;  // Nuevo atributo para controlar la expansión

    public Actividad(int id, String nombre, String descripcion, int cupo, int precio, String fecha, String imagen) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cupo = cupo;
        this.precio = precio;
        this.fecha = fecha;
        this.imagen = imagen;
    }

    public String getNombre() { return nombre; }
    public String getDescripcion() { return descripcion; }
    public int getCupo() { return cupo; }
    public int getPrecio() { return precio; }
    public String getFecha() { return fecha; }
    public String getImagen() { return imagen; }
    public boolean isExpanded() { return isExpanded; }
    public void setExpanded(boolean expanded) { isExpanded = expanded; }
}
