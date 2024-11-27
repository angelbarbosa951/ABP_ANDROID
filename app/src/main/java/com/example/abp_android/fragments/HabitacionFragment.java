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
import android.widget.FrameLayout;

import com.example.abp_android.R;
import com.example.abp_android.adapters.HabitacionAdaptar;
import com.example.abp_android.model.Habitacion;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HabitacionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HabitacionFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    private BottomNavigationView main_nav;
    private FrameLayout main_frame;

    private RecyclerView habitacionsRecyclerView;
    private HabitacionAdaptar habitacionAdapter;
    private List<Habitacion> habitacionList;

    public HabitacionFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HabitacionFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HabitacionFragment newInstance(String param1, String param2) {
        HabitacionFragment fragment = new HabitacionFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_habitacion, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView = view.findViewById(R.id.habitacionsRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));

        // Simula o recupera la lista de habitaciones
        List<Habitacion> habitacions = obtenerHabitaciones();

        // Asigna el adaptador
        HabitacionAdaptar adaptador = new HabitacionAdaptar(requireContext(), habitacions);
        recyclerView.setAdapter(adaptador);
    }

    private List<Habitacion> obtenerHabitaciones() {
        habitacionList = new ArrayList<>();

        habitacionList.add(new Habitacion("Habitació Deluxe", 100,"https://acortar.link/Q3Dm0h"));
        habitacionList.add(new Habitacion("Habitació Suite", 200,"https://acortar.link/tDtN6a"));
        habitacionList.add(new Habitacion("Habitació Estàndard", 75,"https://acortar.link/3Xj0nm"));
        habitacionList.add(new Habitacion("Suite Presidencial", 300.0,"https://acortar.link/qt0cae"));
        return habitacionList;
    }
}