package com.example.abp_android.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.abp_android.R;
import com.example.abp_android.adapters.HabitacionAdaptar;
import com.example.abp_android.model.Habitacion;

import java.util.ArrayList;
import java.util.List;

public class HabitacionFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_habitacion, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Configura el RecyclerView
        RecyclerView recyclerView = view.findViewById(R.id.habitacionsRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));

        // Simula o recupera la lista de habitaciones
        List<Habitacion> habitacions = obtenerHabitaciones();

        // Crea y asigna el adaptador
        HabitacionAdaptar adaptador = new HabitacionAdaptar(requireContext(), habitacions, getParentFragmentManager());
        recyclerView.setAdapter(adaptador);
    }

    private List<Habitacion> obtenerHabitaciones() {
        List<Habitacion> habitacionList = new ArrayList<>();
        habitacionList.add(new Habitacion("Habitació Deluxe", 100, "https://acortar.link/Q3Dm0h"));
        habitacionList.add(new Habitacion("Habitació Suite", 200, "https://acortar.link/tDtN6a"));
        habitacionList.add(new Habitacion("Habitació Estàndard", 75, "https://n9.cl/kxtt8"));
        habitacionList.add(new Habitacion("Suite Presidencial", 300.0, "https://acortar.link/qt0cae"));
        return habitacionList;
    }
}
