package com.example.abp_android.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.lifecycle.ViewModelProvider;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.abp_android.R;
import com.example.abp_android.adapters.MyAdapter;
import com.example.abp_android.model.Actividad;
import com.example.abp_android.viewModel.ReservasViewModel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ActividadFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ActividadFragment extends Fragment {

    private List<com. example. abp_android. model. Actividad> actividades = new ArrayList<>();
    RecyclerView recyclerView;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ActividadFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ActividadFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ActividadFragment newInstance(String param1, String param2) {
        ActividadFragment fragment = new ActividadFragment();
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

    private List<Actividad> reservasActividadArray = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_actividad, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerViewActividad);
        ReservasViewModel reservasViewModel = new ViewModelProvider(requireActivity()).get(ReservasViewModel.class);

        MyAdapter myAdapter = new MyAdapter(data(), getContext(), reservasViewModel);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        return view;
    }

    private List<Actividad> data() {
        if (actividades.size() == 0) {
            actividades.add(new Actividad(1, "Ciclismo", "Ciclismo de montaña en coll de l'Alba", 10, 10, "2024/12/10", "act1"));
            actividades.add(new Actividad(2, "Escalada", "Escalada en multilargos a Horta de Sanjuan", 15, 20, "2025/02/19", "act2"));
            actividades.add(new Actividad(3, "Tennis", "Torneo amateur de Tennis", 8, 15, "2026/09/20", "act3"));
        }
        return actividades;
    }
}