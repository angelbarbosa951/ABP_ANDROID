package com.example.abp_android.model;


import com.example.abp_android.utils.Estado_Reserva;

public class Reserva_Actividad {
    private int id;
    private int id_user;
    private int id_actividad;
    private Estado_Reserva estadoReserva;
    private String fecha;

    public Reserva_Actividad(int id, int id_user, int id_actividad, Estado_Reserva estadoReserva, String fecha) {
        this.id = id;
        this.id_user = id_user;
        this.id_actividad = id_actividad;
        this.estadoReserva = estadoReserva;
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getId_actividad() {
        return id_actividad;
    }

    public void setId_actividad(int id_actividad) {
        this.id_actividad = id_actividad;
    }

    public Estado_Reserva getEstadoReserva() {
        return estadoReserva;
    }

    public void setEstadoReserva(Estado_Reserva estadoReserva) {
        this.estadoReserva = estadoReserva;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }



}
