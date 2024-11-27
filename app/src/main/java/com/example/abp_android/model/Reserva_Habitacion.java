package com.example.abp_android.model;

public class Reserva_Habitacion {
    private Habitacion habitacio;
    private String dataEntrada;
    private String dataSortida;

    public Reserva_Habitacion(Habitacion habitacio, String dataEntrada, String dataSortida) {
        this.habitacio = habitacio;
        this.dataEntrada = dataEntrada;
        this.dataSortida = dataSortida;
    }

    public Habitacion getHabitacio() {
        return habitacio;
    }

    public String getDataEntrada() {
        return dataEntrada;
    }

    public String getDataSortida() {
        return dataSortida;
    }

    @Override
    public String toString() {
        return habitacio.getDescripcio() + " - Entrada: " + dataEntrada + " / Sortida: " + dataSortida;
    }
}
