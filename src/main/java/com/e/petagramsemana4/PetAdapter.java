package com.e.petagramsemana4;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import static android.content.Intent.getIntent;

public class PetAdapter extends RecyclerView.Adapter<PetAdapter.PetViewHolder>  {

    private Context conetxt;
    private AdapterView.OnItemClickListener itemClickListener;

    public PetAdapter (ArrayList<Pets> mascotas){
        this.mascotas = mascotas;
    }

    ArrayList<Pets> mascotas;

    @NonNull
    @Override
    public PetAdapter.PetViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_pets, parent, false);

        return new PetViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final PetAdapter.PetViewHolder holder, final int position) {
        final Pets mascota = mascotas.get(position);
        holder.foto.setImageResource(mascota.getImagen());
        holder.nombre.setText(mascota.getNombre());
        holder.votos.setText(String.valueOf(mascota.getVotos()));
        holder.huesoB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mascota.setVotos(mascota.getVotos()+1);

                holder.votos.setText(String.valueOf(mascota.getVotos()));



            }
        });


    }

    @Override
    public int getItemCount() {
        try {
            return mascotas.size();
        }catch (Exception e){
            return 0;
        }
    }

    public static class PetViewHolder extends RecyclerView.ViewHolder {
        private ImageView foto, huesoB, huesoA;
        private TextView nombre, votos, votosPer;
        public PetViewHolder(@NonNull View itemView) {
            super(itemView);
            foto = itemView.findViewById(R.id.foto);
            huesoA = itemView.findViewById(R.id.huesoA);
            huesoB = itemView.findViewById(R.id.huesoB);
            nombre = itemView.findViewById(R.id.nombre);
            votos = itemView.findViewById(R.id.votos);
            votosPer=itemView.findViewById(R.id.votosP);
        }
    }


}
