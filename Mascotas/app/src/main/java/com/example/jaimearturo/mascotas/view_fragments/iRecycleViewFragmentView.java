package com.example.jaimearturo.mascotas.view_fragments;

import com.example.jaimearturo.mascotas.adapter.MascotaAdapter;
import com.example.jaimearturo.mascotas.poyo.Mascota;

import java.util.ArrayList;

/**
 * Created by vjaime_arturo on 21/06/2017.
 */

public interface iRecycleViewFragmentView {
    public void generarLinerLayoutVertical();

    public MascotaAdapter CrearAdaptador(ArrayList<Mascota> mascotas);

    public void inicializarAdaptadorRV(MascotaAdapter adaptador);
}
