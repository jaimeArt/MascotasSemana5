package com.example.jaimearturo.mascotas.DB;

import android.content.ContentValues;
import android.content.Context;

import com.example.jaimearturo.mascotas.R;
import com.example.jaimearturo.mascotas.poyo.Mascota;

import java.util.ArrayList;

/**
 * Created by vjaime_arturo on 21/06/2017.
 */

public class ConstructorMascotas {
    private Context context;
    public ConstructorMascotas(Context context) {
        this.context=context;
    }

    public ArrayList<Mascota> obtenerDatos(){
        /*ArrayList<Mascota> mascotas= new ArrayList<Mascota>();
        mascotas.add(new Mascota(R.drawable.conejo, "Max", "9"));
        mascotas.add(new Mascota(R.drawable.gato, "Tomas", "10"));
        mascotas.add(new Mascota(R.drawable.hamster, "Flor", "2"));
        mascotas.add(new Mascota(R.drawable.loro, "Roberto", "5"));
        mascotas.add(new Mascota(R.drawable.perro, "Nicky", "15"));*/
        BaseDatos db = new BaseDatos(context);
        insertarLasMascotas(db);
        //return mascotas;
        return db.ObtenerTodaslasMascotas();
    }

    public void insertarLasMascotas(BaseDatos db)
    {
        ContentValues contentValues= new ContentValues();
        if(db.existeMascotas("Max")) {
            contentValues.put(ConstantesBD.TABLE_MASCOTAS_FOTO, R.drawable.conejo);
            contentValues.put(ConstantesBD.TABLE_MASCOTAS_NOMBRE, "Max");
            contentValues.put(ConstantesBD.TABLE_MASCOTAS_LIKE, 0);
            db.insertarMascotas(contentValues);
        }
        if(db.existeMascotas("Tomas")) {
            contentValues = new ContentValues();
            contentValues.put(ConstantesBD.TABLE_MASCOTAS_FOTO, R.drawable.gato);
            contentValues.put(ConstantesBD.TABLE_MASCOTAS_NOMBRE, "Tomas");
            contentValues.put(ConstantesBD.TABLE_MASCOTAS_LIKE, 0);
            db.insertarMascotas(contentValues);
        }
        if(db.existeMascotas("Flor")) {
            contentValues = new ContentValues();
            contentValues.put(ConstantesBD.TABLE_MASCOTAS_FOTO, R.drawable.hamster);
            contentValues.put(ConstantesBD.TABLE_MASCOTAS_NOMBRE, "Flor");
            contentValues.put(ConstantesBD.TABLE_MASCOTAS_LIKE, 0);
            db.insertarMascotas(contentValues);
        }
        if(db.existeMascotas("Roberto")) {
            contentValues = new ContentValues();
            contentValues.put(ConstantesBD.TABLE_MASCOTAS_FOTO, R.drawable.loro);
            contentValues.put(ConstantesBD.TABLE_MASCOTAS_NOMBRE, "Roberto");
            contentValues.put(ConstantesBD.TABLE_MASCOTAS_LIKE, 0);
            db.insertarMascotas(contentValues);
        }
        if(db.existeMascotas("Nicky")) {
            contentValues = new ContentValues();
            contentValues.put(ConstantesBD.TABLE_MASCOTAS_FOTO, R.drawable.perro);
            contentValues.put(ConstantesBD.TABLE_MASCOTAS_NOMBRE, "Nicky");
            contentValues.put(ConstantesBD.TABLE_MASCOTAS_LIKE, 0);
            db.insertarMascotas(contentValues);
        }
    }

    public void darLikeMascota(Mascota mascota)
    {
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBD.TABLE_MASCOTAS_LIKE, obtenerLikeMascota(mascota)
                 + 1);//mascota.getLikeMascota()
        db.actualizarLikeMascota(contentValues ,mascota.getIdMascota());
    }
    public int obtenerLikeMascota(Mascota mascota)
    {
        BaseDatos db = new BaseDatos(context);
        return db.obtenerLikesMascota(mascota);
    }
}
