package com.example.proyectoenfermeras.view.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyectoenfermeras.R;
import com.example.proyectoenfermeras.model.entities.Paciente;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AdaptadorPersonalizado extends RecyclerView.Adapter<AdaptadorPersonalizado.ViewHolder> {

    ArrayList<Paciente> listadoDatos;

    OnItemClickListener OnItemClickListener;

    public AdaptadorPersonalizado(ArrayList<Paciente> listadoDatos) {
        this.listadoDatos = listadoDatos;
        this.OnItemClickListener = null;
    }

    public void setListadoDatos(ArrayList<Paciente> listadoDatos) {
        this.listadoDatos = listadoDatos;
        notifyDataSetChanged();
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        OnItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public AdaptadorPersonalizado.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_recycle_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorPersonalizado.ViewHolder holder, int position) {
        holder.cargarDatos(listadoDatos.get(position));
    }

    @Override
    public int getItemCount() {
        return listadoDatos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvNombre, tvApellido;
        ImageView ivPrincipal;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvNombre = itemView.findViewById(R.id.textViewNombre);
            tvApellido = itemView.findViewById(R.id.textViewApellido);
            ivPrincipal = itemView.findViewById(R.id.ivPrincipal);
        }

        public void cargarDatos(Paciente paciente) {
            tvNombre.setText(paciente.getNombre());
            tvApellido.setText(paciente.getApellido());
            Picasso.get().load(paciente.getUrl()).resize(300, 300).centerCrop().into(ivPrincipal);

            ivPrincipal.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(ivPrincipal.getContext(), "Click en imagen " + paciente.getNombre(), Toast.LENGTH_SHORT).show();
                }
            });

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(ivPrincipal.getContext(), "Click en general " + paciente.getNombre(), Toast.LENGTH_SHORT).show();
                }
            });

            if(OnItemClickListener != null){
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        OnItemClickListener.onItemClick(paciente, getAdapterPosition());
                    }
                });
            }

        }
    }



    public interface OnItemClickListener{
        void onItemClick(Paciente paciente, int posicion);
    }


}
