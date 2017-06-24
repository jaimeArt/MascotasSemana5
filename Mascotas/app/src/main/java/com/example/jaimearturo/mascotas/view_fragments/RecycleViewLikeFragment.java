package com.example.jaimearturo.mascotas.view_fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jaimearturo.mascotas.R;
import com.example.jaimearturo.mascotas.adapter.MascotaLikeAdapter;
import com.example.jaimearturo.mascotas.poyo.Mascota;
import com.example.jaimearturo.mascotas.presentador.IRecycleViewLikeFragmentPresenter;
import com.example.jaimearturo.mascotas.presentador.RecylceViewLikeFragmentPresenter;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class RecycleViewLikeFragment extends Fragment implements iRecycleViewLikeFragmentView {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMasotas;
    private IRecycleViewLikeFragmentPresenter presenter;

    public RecycleViewLikeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =inflater.inflate(R.layout.fragment_recycle_view_like, container, false);
        listaMasotas =(RecyclerView) v.findViewById(R.id.rvMascotasLike);
        presenter = new RecylceViewLikeFragmentPresenter(this,  getContext());
        return v;
    }


    @Override
    public void generarLinerLayoutVertical() {
            LinearLayoutManager lim = new LinearLayoutManager(getActivity());
            lim.setOrientation(LinearLayoutManager.VERTICAL);
            listaMasotas.setLayoutManager(lim);
    }

    @Override
    public MascotaLikeAdapter CrearAdaptador(ArrayList<Mascota> mascotas) {
        MascotaLikeAdapter adaptador = new MascotaLikeAdapter(mascotas, getActivity()); //, getActivity()
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(MascotaLikeAdapter adaptador) {
        listaMasotas.setAdapter(adaptador);
    }
}
