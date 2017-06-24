package com.example.jaimearturo.mascotas.view_fragments;

import com.example.jaimearturo.mascotas.adapter.MascotaLikeAdapter;
import com.example.jaimearturo.mascotas.poyo.Mascota;

import java.util.ArrayList;

/**
 * Created by vjaime_arturo on 21/06/2017.
 */

public interface iRecycleViewLikeFragmentView {
    public void generarLinerLayoutVertical();

    public MascotaLikeAdapter CrearAdaptador(ArrayList<Mascota> mascotas);

    public void inicializarAdaptadorRV(MascotaLikeAdapter adaptador);
}
