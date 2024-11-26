package com.example.abp_android.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.abp_android.model.Actividad;
import com.example.abp_android.R;
import com.example.abp_android.viewModel.ReservasViewModel;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private List<Actividad> actividades;
    private Context context;
    private List<Actividad> reservasActividadArray;
    private ReservasViewModel reservasViewModel;

    public MyAdapter(List<Actividad> actividades, Context context, ReservasViewModel reservasViewModel) {
        this.actividades = actividades;
        this.context = context;
        this.reservasViewModel = reservasViewModel;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row_actividad, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Actividad actividad = actividades.get(position);

        holder.textNombreActividad.setText(actividad.getNombre());
        holder.textFechaActividad.setText(actividad.getFecha());

        // Cargar imagen de la actividad
        String imageName = actividad.getImagen();
        int resId = context.getResources().getIdentifier(imageName, "drawable", context.getPackageName());
        holder.imageActividad.setImageResource(resId);

        // Mostrar los detalles si la actividad está expandida
        holder.linearDetalles.setVisibility(actividad.isExpanded() ? View.VISIBLE : View.GONE);
        holder.textCupo.setText("Cupo: " + actividad.getCupo());
        holder.textPrecio.setText("Precio: $" + actividad.getPrecio());
        holder.textDescripcion.setText("Descripción: " + actividad.getDescripcion());

        // Agregar un clic para alternar el estado de expansión
        holder.itemView.setOnClickListener(v -> {
            // Alternar el estado de la actividad expandida
            actividad.setExpanded(!actividad.isExpanded());
            notifyItemChanged(position);  // Actualizar solo el ítem afectado

            // Mostrar un mensaje para verificar el cambio de estado
            System.out.println("Estado expandido de " + actividad.getNombre() + ": " + actividad.isExpanded());
        });

        // Configurar el botón de reservar
        holder.btnReservar.setOnClickListener(v -> {
            reservasViewModel.agregarReserva(actividad); // Agrega la actividad al ViewModel

            // Imprimir en consola para verificar
            System.out.println("Reservada actividad: " + actividad.getNombre());

            // Mostrar un Toast de confirmación
            Toast.makeText(context, actividad.getNombre() + " reservada", Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public int getItemCount() {
        return actividades.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView textNombreActividad;
        private TextView textFechaActividad;
        private ImageView imageActividad;
        private LinearLayout linearDetalles;
        private TextView textCupo;
        private TextView textPrecio;
        private TextView textDescripcion;
        private Button btnReservar;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textNombreActividad = itemView.findViewById(R.id.textNombreActividad);
            textFechaActividad = itemView.findViewById(R.id.textFechaActividad);
            imageActividad = itemView.findViewById(R.id.imageActividad);
            linearDetalles = itemView.findViewById(R.id.linearDetalles);
            textCupo = itemView.findViewById(R.id.textCupo);
            textPrecio = itemView.findViewById(R.id.textPrecio);
            textDescripcion = itemView.findViewById(R.id.textDescripcion);
            btnReservar = itemView.findViewById(R.id.btnReservar);
        }
    }
}
