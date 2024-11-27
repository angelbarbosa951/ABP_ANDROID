package com.example.abp_android.model;

public class Habitacion {
    private String descripcio;
    private double preuPerNit;
    private String imageUrl; // URL de la imagen

    public Habitacion(String descripcio, double preuPerNit,String imageUrl) {
        this.descripcio = descripcio;
        this.preuPerNit = preuPerNit;
        this.imageUrl = imageUrl;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public double getPreuPerNit() {
        return preuPerNit;
    }
    public String getImageUrl() {
        return imageUrl;
    }

    @Override
    public String toString() {
        return descripcio + " - " + preuPerNit + "€/nit";
    }
}
