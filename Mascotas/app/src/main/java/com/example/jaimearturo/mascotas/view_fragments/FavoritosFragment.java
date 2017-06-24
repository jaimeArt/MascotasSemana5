package com.example.jaimearturo.mascotas.view_fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jaimearturo.mascotas.R;
import com.example.jaimearturo.mascotas.adapter.GalariaMascotaAdapter;
import com.example.jaimearturo.mascotas.adapter.MascotaAdapter;
import com.example.jaimearturo.mascotas.poyo.GaleriaMascota;
import com.example.jaimearturo.mascotas.poyo.Mascota;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class FavoritosFragment extends Fragment {

    ArrayList<GaleriaMascota> galeriaMascotas;
    private RecyclerView listaMascotas;
    public FavoritosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.fragment_favoritos, container, false);
        listaMascotas =(RecyclerView) v.findViewById(R.id.rvFavoritoMascotas);
        LinearLayoutManager lim = new LinearLayoutManager(getActivity());
        lim.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(lim);
        inicializarListaMascotas();
        inicializarAdaptador();

        return v;
    }
    public void inicializarAdaptador()
    {
        GalariaMascotaAdapter adaptador = new GalariaMascotaAdapter(galeriaMascotas); //, getActivity()
        listaMascotas.setAdapter(adaptador);

    }
    public void inicializarListaMascotas()
    {
        galeriaMascotas = new ArrayList<GaleriaMascota>();
        galeriaMascotas.add(new GaleriaMascota(R.drawable.conejo, "Max"));
        galeriaMascotas.add(new GaleriaMascota(R.drawable.gato, "Tomas"));
        galeriaMascotas.add(new GaleriaMascota(R.drawable.hamster, "Flor"));
        galeriaMascotas.add(new GaleriaMascota(R.drawable.loro, "Roberto"));
        galeriaMascotas.add(new GaleriaMascota(R.drawable.perro, "Nicky"));
    }

}
