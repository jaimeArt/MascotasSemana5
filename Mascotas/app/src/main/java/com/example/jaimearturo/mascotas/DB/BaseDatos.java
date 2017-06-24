package com.example.jaimearturo.mascotas.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.jaimearturo.mascotas.poyo.Mascota;

import java.util.ArrayList;

/**
 * Created by vjaime_arturo on 21/06/2017.
 */

public class BaseDatos extends SQLiteOpenHelper {
    private Context context;
    public BaseDatos(Context context) {
        super(context, ConstantesBD.DATABASE_NAME,null, ConstantesBD.DATABASE_VERSION);
        this.context=context;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryCrearTablaMascota = "CREATE TABLE " + ConstantesBD.TABLE_MASCOTAS +
                "("+
                    ConstantesBD.TABLE_MASCOTAS_ID      + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    ConstantesBD.TABLE_MASCOTAS_FOTO    + " INTEGER, " +
                    ConstantesBD.TABLE_MASCOTAS_NOMBRE + " TEXT, " +
                    ConstantesBD.TABLE_MASCOTAS_LIKE    + " INTEGER " +
                ")";
        /*String queryCrearTablaGaleriaMascotas= "CREATE TABLE " + ConstantesBD.DATABASE_NAME +
                "("+
                ")";*/
        db.execSQL(queryCrearTablaMascota);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST " +  ConstantesBD.TABLE_MASCOTAS);
        onCreate(db);
    }

    public ArrayList<Mascota> ObtenerTodaslasMascotas()
    {
        ArrayList<Mascota> mascotas = new ArrayList<>();
        String query = "SELECT * FROM "+ ConstantesBD.TABLE_MASCOTAS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query,null);
        while (registros.moveToNext())
        {
            Mascota mascotaActual = new Mascota();
            mascotaActual.setIdMascota(registros.getInt(0));
            mascotaActual.setFotoMascota(registros.getInt(1));
            mascotaActual.setNombreMascota(registros.getString(2));
            mascotaActual.setLikeMascota(String.valueOf( registros.getInt(3)));

            mascotas.add(mascotaActual);
        }
        db.close();

        return mascotas;
    }

    public ArrayList<Mascota> ObtenerMasLikesMascotas()
    {
        ArrayList<Mascota> mascotas = new ArrayList<>();
        String query = "SELECT * FROM "+ ConstantesBD.TABLE_MASCOTAS + " ORDER BY " + ConstantesBD.TABLE_MASCOTAS_LIKE + " DESC";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query,null);
        int iNumLikes = 1;
        while (registros.moveToNext())
        {
            if(iNumLikes++ <= ConstantesBD.NUM_LIKE) {
                Mascota mascotaActual = new Mascota();
                mascotaActual.setIdMascota(registros.getInt(0));
                mascotaActual.setFotoMascota(registros.getInt(1));
                mascotaActual.setNombreMascota(registros.getString(2));
                mascotaActual.setLikeMascota(String.valueOf(registros.getInt(3)));

                mascotas.add(mascotaActual);
            }
        }
        db.close();

        return mascotas;
    }
    public void insertarMascotas(ContentValues contentValues)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBD.TABLE_MASCOTAS, null, contentValues);
        db.close();
    }
    public boolean existeMascotas(String nombreMascota)
    {
        String existeQuery = "SELECT  * FROM " + ConstantesBD.TABLE_MASCOTAS +
                             " WHERE " + ConstantesBD.TABLE_MASCOTAS_NOMBRE + " = '" + nombreMascota + "'" ;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(existeQuery, null);
        int cnt = cursor.getCount();
        cursor.close();
        db.close();
        return (cnt == 0);
    }

    public void actualizarLikeMascota(ContentValues contentValues, int idMascota)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.update(ConstantesBD.TABLE_MASCOTAS,contentValues, ConstantesBD.TABLE_MASCOTAS_ID + " = "  + idMascota, null);
        db.close();
    }

    public int obtenerLikesMascota(Mascota mascota)
    {
        int like =0;
        String query = "SELECT " + ConstantesBD.TABLE_MASCOTAS_LIKE + " FROM " + ConstantesBD.TABLE_MASCOTAS +
                " WHERE " + ConstantesBD.TABLE_MASCOTAS_ID + " = " + mascota.getIdMascota();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor registros = db.rawQuery(query, null);
        if (registros.moveToNext() )
        {
            like = registros.getInt(0);
        }
        db.close();
        return like;
    }
}
