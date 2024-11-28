package com.example.abp_android.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.abp_android.R;
import com.example.abp_android.model.Reserva_Habitacion;

import java.util.List;

public class ReservaHabitacionAdapter extends BaseAdapter {

    private final Context context;
    private final List<Reserva_Habitacion> reservas;
    private final LayoutInflater inflater;

    public ReservaHabitacionAdapter(Context context, List<Reserva_Habitacion> reservas) {
        this.context = context;
        this.reservas = reservas;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return reservas.size();
    }

    @Override
    public Object getItem(int position) {
        return reservas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_reserva, parent, false);
        }

        // Obtener la reserva actual
        Reserva_Habitacion reserva = reservas.get(position);

        // Configurar el TextView y el botón
        TextView reservaTextView = convertView.findViewById(R.id.reservaTextView);
        Button cancelarReservaButton = convertView.findViewById(R.id.cancelarReservaButton);

        // Mostrar los datos de la reserva
        reservaTextView.setText(reserva.toString()); // Asegúrate de que `Reserva_Habitacion` tenga un método `toString()` adecuado

        // Configurar el evento del botón
        cancelarReservaButton.setOnClickListener(v -> {
            reservas.remove(position); // Eliminar la reserva de la lista
            notifyDataSetChanged();   // Notificar al adaptador que los datos han cambiado
        });

        return convertView;
    }
}
