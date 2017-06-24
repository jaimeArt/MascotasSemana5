package com.example.jaimearturo.mascotas.DB;

import android.content.Context;

import com.example.jaimearturo.mascotas.poyo.Mascota;

import java.util.ArrayList;

/**
 * Created by vjaime_arturo on 21/06/2017.
 */

public class ConstructorMascotasLike {
    private Context context;
    public ConstructorMascotasLike(Context context) {
        this.context=context;
    }

    public ArrayList<Mascota> obtenerDatos(){
        BaseDatos db = new BaseDatos(context);
        return db.ObtenerMasLikesMascotas();
    }


}
