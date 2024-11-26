package com.example.abp_android.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.abp_android.model.Actividad;

import java.util.ArrayList;
import java.util.List;

public class ReservasViewModel extends ViewModel {
    private final MutableLiveData<List<Actividad>> reservasLiveData = new MutableLiveData<>(new ArrayList<>());

    public LiveData<List<Actividad>> getReservasLiveData() {
        return reservasLiveData;
    }

    public List<Actividad> getReservas() {
        return reservasLiveData.getValue();
    }

    public void agregarReserva(Actividad actividad) {
        List<Actividad> reservas = getReservas();
        reservas.add(actividad);
        reservasLiveData.setValue(reservas); // Notificar cambios
    }

    public void eliminarReserva(Actividad actividad) {
        List<Actividad> reservas = getReservas();
        reservas.remove(actividad);
        reservasLiveData.setValue(reservas); // Notificar cambios
    }
}
