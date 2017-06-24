package com.example.jaimearturo.mascotas.presentador;

import android.content.Context;

import com.example.jaimearturo.mascotas.DB.ConstructorMascotasLike;
import com.example.jaimearturo.mascotas.poyo.Mascota;
import com.example.jaimearturo.mascotas.view_fragments.iRecycleViewLikeFragmentView;

import java.util.ArrayList;

/**
 * Created by vjaime_arturo on 21/06/2017.
 */

public class RecylceViewLikeFragmentPresenter implements IRecycleViewLikeFragmentPresenter {

    private iRecycleViewLikeFragmentView iRecycleViewLikeFragmentView;
    private Context context;
    private ConstructorMascotasLike constructorMascotasLike;
    private ArrayList<Mascota> mascotas;

    public RecylceViewLikeFragmentPresenter(iRecycleViewLikeFragmentView iRecycleViewLikeFragmentView, Context context) {
        this.iRecycleViewLikeFragmentView = iRecycleViewLikeFragmentView;
        this.context = context;
        obtenerMascotasLikeBD();
    }


    @Override
    public void obtenerMascotasLikeBD() {
        constructorMascotasLike = new ConstructorMascotasLike(context);
        mascotas = constructorMascotasLike.obtenerDatos();
        mostrarMascotasLikeRV();
    }

    @Override
    public void mostrarMascotasLikeRV() {
        iRecycleViewLikeFragmentView.inicializarAdaptadorRV(iRecycleViewLikeFragmentView.CrearAdaptador(mascotas));
        iRecycleViewLikeFragmentView.generarLinerLayoutVertical();
    }
}
