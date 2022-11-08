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
import com.example.proyectoenfermeras.model.entities.Reporte;

import java.util.ArrayList;

public class AdaptadorPersonalizadoReporte extends RecyclerView.Adapter<AdaptadorPersonalizadoReporte.ViewHolder> {
    ArrayList<Reporte> listadoDatos;

    AdaptadorPersonalizadoReporte.OnItemClickListener OnItemClickListener;

    public AdaptadorPersonalizadoReporte(ArrayList<Reporte> listadoDatos) {
        this.listadoDatos = listadoDatos;
        this.OnItemClickListener = null;
    }

    public void setListadoDatos(ArrayList<Reporte> listadoDatos) {
        this.listadoDatos = listadoDatos;
        notifyDataSetChanged();
    }

    public void setOnItemClickListener(AdaptadorPersonalizadoReporte.OnItemClickListener onItemClickListener) {
        OnItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public AdaptadorPersonalizadoReporte.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_recycle_view, parent, false);
        return new AdaptadorPersonalizadoReporte.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorPersonalizadoReporte.ViewHolder holder, int position) {
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

        public void cargarDatos(Reporte reporte) {
            tvNombre.setText(reporte.getComentario());
            tvApellido.setText(reporte.getInformante());


            ivPrincipal.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(ivPrincipal.getContext(), "Click en imagen " + reporte.getComentario(), Toast.LENGTH_SHORT).show();
                }
            });

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(ivPrincipal.getContext(), "Click en general " + reporte.getComentario(), Toast.LENGTH_SHORT).show();
                }
            });

            if(OnItemClickListener != null){
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        OnItemClickListener.onItemClick(reporte, getAdapterPosition());
                    }
                });
            }

        }
    }



    public interface OnItemClickListener{
        void onItemClick(Reporte reporte, int posicion);
    }


}

