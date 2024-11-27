package com.example.abp_android.adapters;

import android.app.DatePickerDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.abp_android.R;
import com.example.abp_android.fragments.HabitacionReservaFragment;
import com.example.abp_android.model.Habitacion;
import com.example.abp_android.model.Reserva_Habitacion;
import com.squareup.picasso.Picasso;

import java.util.Calendar;
import java.util.List;

public class HabitacionAdaptar extends RecyclerView.Adapter<HabitacionAdaptar.HabitacionViewHolder> {
    private final List<Habitacion> habitacions;
    private final Context context;
    private final FragmentManager fragmentManager;

    public HabitacionAdaptar(Context context, List<Habitacion> habitacions, FragmentManager fragmentManager) {
        this.context = context;
        this.habitacions = habitacions;
        this.fragmentManager = fragmentManager;
    }

    @NonNull
    @Override
    public HabitacionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_habitacion, parent, false);
        return new HabitacionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HabitacionViewHolder holder, int position) {
        Habitacion habitacion = habitacions.get(position);

        // Carga la imagen usando Picasso
        Picasso.get()
                .load(habitacion.getImageUrl()) // URL de la imagen
                .fit()
                .centerCrop()
                .into(holder.imageView);

        // Configura los datos de la habitación
        holder.descripcioTextView.setText(habitacion.getDescripcio());
        holder.preuTextView.setText("Preu: " + habitacion.getPreuPerNit() + "€/nit");

        // Configura el botón de reserva
        holder.reservarButton.setOnClickListener(v -> mostrarDatePicker(habitacion));
    }

    @Override
    public int getItemCount() {
        return habitacions.size();
    }

    private void mostrarDatePicker(Habitacion habitacion) {
        Calendar calendar = Calendar.getInstance();
        int any = calendar.get(Calendar.YEAR);
        int mes = calendar.get(Calendar.MONTH);
        int dia = calendar.get(Calendar.DAY_OF_MONTH);

        // Selección de fecha de entrada
        DatePickerDialog entradaDatePicker = new DatePickerDialog(context,
                (view, anySeleccionat, mesSeleccionat, diaSeleccionat) -> {
                    String dataEntrada = diaSeleccionat + "/" + (mesSeleccionat + 1) + "/" + anySeleccionat;

                    // Selección de fecha de salida
                    DatePickerDialog sortidaDatePicker = new DatePickerDialog(context,
                            (view1, anySortida, mesSortida, diaSortida) -> {
                                String dataSortida = diaSortida + "/" + (mesSortida + 1) + "/" + anySortida;

                                // Guardar reserva
                                if(diaSeleccionat<=diaSortida&& mesSeleccionat<=mesSortida) {
                                    Reserva_Habitacion reserva = new Reserva_Habitacion(habitacion, dataEntrada, dataSortida);
                                    ReservaManagerHabitacion.getInstance().afegirReserva(reserva);
                                    Toast.makeText(context, "Reserva guardada!", Toast.LENGTH_SHORT).show();
                                }else{
                                    Toast.makeText(context, "Fecha no valida!", Toast.LENGTH_SHORT).show();
                                }

                            }, any, mes, dia);
                    sortidaDatePicker.setTitle("Selecciona la data de sortida");
                    sortidaDatePicker.show();

                }, any, mes, dia);
        entradaDatePicker.setTitle("Selecciona la data d'entrada");
        entradaDatePicker.show();
    }

    static class HabitacionViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        TextView descripcioTextView, preuTextView;
        Button reservarButton;

        public HabitacionViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            descripcioTextView = itemView.findViewById(R.id.tv_habitacio_descripcio);
            preuTextView = itemView.findViewById(R.id.tv_habitacio_preu);
            reservarButton = itemView.findViewById(R.id.btn_reservar);
        }
    }
}
