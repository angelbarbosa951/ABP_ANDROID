package com.example.abp_android.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.abp_android.R;
import com.example.abp_android.model.Actividad;
import com.example.abp_android.viewModel.ReservasViewModel;

import java.util.List;

public class ReservasAdapter extends RecyclerView.Adapter<ReservasAdapter.ReservasViewHolder> {

    private List<Actividad> reservas;
    private Context context;
    private ReservasViewModel reservasViewModel;


    public ReservasAdapter(Context context,  ReservasViewModel reservasViewModel) {
        this.context = context;
        this.reservasViewModel = reservasViewModel;
        this.reservas = reservasViewModel.getReservas();
    }
    //
    @Override
    public ReservasViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row_reserva, parent, false);
        return new ReservasViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ReservasViewHolder holder, int position) {
        Actividad actividad = reservas.get(position);

        holder.textNombreReserva.setText(actividad.getNombre());
        holder.textFechaReserva.setText(actividad.getFecha());

        // Botón para cancelar la reserva
        holder.btnCancelar.setOnClickListener(v -> {
            reservasViewModel.eliminarReserva(actividad); // Eliminar la actividad del ViewModel

            notifyItemRemoved(position);
            notifyItemRangeChanged(position, reservas.size());

            // Imprimir en consola para verificar
            System.out.println("Actividad cancelada: " + actividad.getNombre());
        });
    }

    @Override
    public int getItemCount() {
        return reservas.size();
    }

    public class ReservasViewHolder extends RecyclerView.ViewHolder {
        private TextView textNombreReserva;
        private TextView textFechaReserva;
        private Button btnCancelar;

        public ReservasViewHolder(@NonNull View itemView) {
            super(itemView);
            textNombreReserva = itemView.findViewById(R.id.textNombreReserva);
            textFechaReserva = itemView.findViewById(R.id.textFechaReserva);
            btnCancelar = itemView.findViewById(R.id.btnCancelar);
        }
    }
}
