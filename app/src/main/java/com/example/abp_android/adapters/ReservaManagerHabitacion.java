package com.example.abp_android.adapters;

import com.example.abp_android.model.Reserva_Habitacion;

import java.util.ArrayList;

public class ReservaManagerHabitacion {
    private static ReservaManagerHabitacion instance;
    private ArrayList<Reserva_Habitacion> reserves;

    private ReservaManagerHabitacion() {
        reserves = new ArrayList<>();
    }

    public static ReservaManagerHabitacion getInstance() {
        if (instance == null) {
            instance = new ReservaManagerHabitacion();
        }
        return instance;
    }

    public void afegirReserva(Reserva_Habitacion reserva) {
        reserves.add(reserva);
    }

    public ArrayList<Reserva_Habitacion> getReserves() {
        return reserves;
    }
}
