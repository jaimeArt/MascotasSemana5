package com.example.jaimearturo.mascotas.presentador;

import android.content.Context;

import com.example.jaimearturo.mascotas.DB.ConstructorMascotas;
import com.example.jaimearturo.mascotas.poyo.Mascota;
import com.example.jaimearturo.mascotas.view_fragments.iRecycleViewFragmentView;

import java.util.ArrayList;

/**
 * Created by vjaime_arturo on 21/06/2017.
 */

public class RecylceViewFragmentPresenter implements IRecycleViewFragmentPresenter {

    private iRecycleViewFragmentView iRecycleViewFragmentView;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascota> mascotas;

    public RecylceViewFragmentPresenter(iRecycleViewFragmentView iRecycleViewFragmentView, Context context) {
        this.iRecycleViewFragmentView = iRecycleViewFragmentView;
        this.context = context;
        obtenerMascotasBD();
    }


    @Override
    public void obtenerMascotasBD() {
        constructorMascotas = new ConstructorMascotas(context);
        mascotas = constructorMascotas.obtenerDatos();
        mostrarMascotasRV();
    }

    @Override
    public void mostrarMascotasRV() {
        iRecycleViewFragmentView.inicializarAdaptadorRV(iRecycleViewFragmentView.CrearAdaptador(mascotas));
        iRecycleViewFragmentView.generarLinerLayoutVertical();
    }
}
