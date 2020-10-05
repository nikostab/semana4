package com.e.petagramsemana4;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class MascotasFragment extends Fragment {

    ArrayList<Pets> mascotas;
    ArrayList<String>nomList;
    ArrayList<Integer>fotList, votList;
    RecyclerView recycler;
    private Context context;
    MenuItem star;
    private int tam;

    public MascotasFragment() {
        // Required empty public constructor
    }




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mascotas, container, false);

       setHasOptionsMenu(true);

        recycler = view.findViewById(R.id.recycler);
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recycler.setLayoutManager(llm);
        llenarRecycler();
        iniciarAdapter();

        tam = mascotas.size();

        star = view.findViewById(R.id.star);




        Bundle bun = new Bundle();
      //  Intent in = new Intent(getContext(), MainActivity.class);
        votList = new ArrayList<>();
        fotList = new ArrayList<>();
        nomList = new ArrayList<>();
        for (int i=0; i<tam; i++) {
            fotList.add(mascotas.get(i).getImagen());
            votList.add(mascotas.get(i).getVotos());
            nomList.add(mascotas.get(i).getNombre());

        }
        bun.putIntegerArrayList("vot", votList);
        bun.putIntegerArrayList("fot", fotList);
        bun.putStringArrayList("nom", nomList);
        setArguments(bun);
       /* in.putExtra("vot", votList);
        in.putExtra("fot", fotList);
        in.putExtra("nom",nomList);
        startActivity(in);*/


        return view;
    }






    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){

            case R.id.star:

                ArrayList<Pets> lista = new ArrayList<Pets>();
                ArrayList<String>nombres = new ArrayList<>();
                ArrayList<Integer>fotos = new ArrayList<>();
                ArrayList<Integer>votos = new ArrayList<>();

                Intent datos = new Intent(getContext(), Ranking.class);

                Collections.sort(mascotas, new Comparator<Pets>() {
                    @Override
                    public int compare(Pets o1, Pets o2) {
                        return new Integer(o2.getVotos()).compareTo(new Integer(o1.getVotos()));
                    }
                });

                for(int i=0; i<mascotas.size(); i++){
                    nombres.add(mascotas.get(i).getNombre());
                    fotos.add(mascotas.get(i).getImagen());
                    votos.add(mascotas.get(i).getVotos());
                }

                datos.putExtra("Lista", lista);
                datos.putExtra("listaf", fotos);
                datos.putExtra("votos", votos);
                startActivity(datos);
                break;

            case R.id.about:
                Intent intabout = new Intent(getContext(), About.class);
                startActivity(intabout);
                break;

            case R.id.contact:
                Intent intconta = new Intent(getContext(), Contacto.class);
                startActivity(intconta);
                break;

        } return super.onOptionsItemSelected(item);
    }


    public void iniciarAdapter(){
        PetAdapter adaptador = new PetAdapter(mascotas);
        recycler.setAdapter(adaptador);
    }

    public void llenarRecycler(){
        mascotas = new ArrayList<>();

        mascotas.add(new Pets(R.drawable.perro1, "Simón") );
        mascotas.add(new Pets(R.drawable.perro2,"Lucas"));
        mascotas.add(new Pets(R.drawable.perro3, "Chico"));
        mascotas.add(new Pets(R.drawable.perro4, "Pirulo"));
        mascotas.add(new Pets(R.drawable.perro5, "Cachin"));
        mascotas.add(new Pets(R.drawable.perro6, "RunRun"));
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);

        if (hidden == true){
            MascotasFragment mfrag = new MascotasFragment();
            Bundle bun = new Bundle();
            Intent in = new Intent(getContext(), MainActivity.class);
            ArrayList<Integer>votList = new ArrayList<>();
            ArrayList<Integer>fotList = new ArrayList<>();
            ArrayList<String>nomList = new ArrayList<>();
            for (int i=0; i<tam; i++) {
                fotList.add(mascotas.get(i).getImagen());
                votList.add(mascotas.get(i).getVotos());
                nomList.add(mascotas.get(i).getNombre());

            }
            in.putExtra("vot", votList);
            in.putExtra("fot", fotList);
            in.putExtra("nom",nomList);
            startActivity(in);
            bun.putIntegerArrayList("vot",votList);
            bun.putIntegerArrayList("fot", fotList);
            bun.putStringArrayList("nom", nomList);
            mfrag.setArguments(bun);
        }
    }






}