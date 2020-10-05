package com.e.petagramsemana4;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PerfilAdapter extends RecyclerView.Adapter<PerfilAdapter.PerfilViewHolder> {

    public PerfilAdapter(ArrayList<Pets> mascotasPerf) {
        this.mascotasPerf = mascotasPerf;
    }

    ArrayList<Pets> mascotasPerf;

    @NonNull
    @Override
    public PerfilViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_perfil, parent, false);

        return new PerfilAdapter.PerfilViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final PerfilViewHolder holder, int position) {

        final Pets mascotaPerf = mascotasPerf.get(position);
        holder.fotoP.setImageResource(mascotaPerf.getImagen());

        holder.votosP.setText(String.valueOf(mascotaPerf.getVotos()));


        holder.fotoP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(holder.fotoP.getContext(), mascotaPerf.getNombre(), Toast.LENGTH_SHORT).show();

            }
        });

    }

    @Override
    public int getItemCount() {
        return mascotasPerf.size();
    }

    public class PerfilViewHolder extends RecyclerView.ViewHolder {
        private ImageView fotoP, fotoPerfil;
        private TextView  votosP,nombrePerfil;
        public PerfilViewHolder(@NonNull View itemView) {
            super(itemView);
            fotoP = itemView.findViewById(R.id.fotoP);
            votosP = itemView.findViewById(R.id.votosP);
            fotoPerfil = itemView.findViewById(R.id.fotoPerf);
            nombrePerfil= itemView.findViewById(R.id.descPerf);
        }
    }

}