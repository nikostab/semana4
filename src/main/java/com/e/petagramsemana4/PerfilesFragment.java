package com.e.petagramsemana4;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class PerfilesFragment extends Fragment {

    ArrayList<Pets> perfiList;
    ArrayList<Integer> listaf, votos;
    ArrayList<Pets> mascotasPerf;
    RecyclerView gridRec;
    ImageView fotoPerf;
    TextView descPerf;
    PerfilAdapter adapter;

    public PerfilesFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_perfiles, container, false);
        setHasOptionsMenu(true);
        fotoPerf = view.findViewById(R.id.fotoPerf);
        descPerf = view.findViewById(R.id.descPerf);
        gridRec = view.findViewById(R.id.gridRec);

        fotoPerf.setImageResource(R.drawable.perro6);
        descPerf.setText("RunRun");

        GridLayoutManager glm = new GridLayoutManager(getContext(), 3);

        gridRec.setLayoutManager(glm);

        llenarRecycler();
        iniciarAdapter();

        return view;
    }


    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (hidden == false){

            Bundle bun = this.getArguments();
            if (bun != null){
                ArrayList<Integer> fotList = bun.getIntegerArrayList("fot");
                ArrayList<Integer> listVot = bun.getIntegerArrayList("vot");
                ArrayList<String> nomList = bun.getStringArrayList("nom");

                for (int i =0; i<perfiList.size(); i++){
                    String nombre = nomList.get(i);
                    int foto = fotList.get(i);
                    int votos = listVot.get(i);
                    perfiList.add(new Pets(foto, nombre, votos));
                    Toast.makeText(getContext(), nomList.get(i),Toast.LENGTH_SHORT).show();

                }
                PerfilAdapter adaptador = new PerfilAdapter(perfiList);
                gridRec.setAdapter(adaptador);
            }

        }
    }

    public void iniciarAdapter(){
        PerfilAdapter adaptador = new PerfilAdapter(perfiList);
        gridRec.setAdapter(adaptador);
    }

    public void llenarRecycler(){
        perfiList = new ArrayList<>();

        perfiList.add(new Pets(R.drawable.perro1, "Simón",3) );
        perfiList.add(new Pets(R.drawable.perro2,"Lucas",1));
        perfiList.add(new Pets(R.drawable.perro3, "Chico",4));
        perfiList.add(new Pets(R.drawable.perro4, "Pirulo",2));
        perfiList.add(new Pets(R.drawable.perro5, "Cachin",0));
        perfiList.add(new Pets(R.drawable.perro6, "RunRun",5));
    }
}