package com.example.jaimearturo.mascotas.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jaimearturo.mascotas.DB.ConstructorMascotas;
import com.example.jaimearturo.mascotas.R;
import com.example.jaimearturo.mascotas.poyo.Mascota;

import java.util.ArrayList;

/**
 * Created by JaimeArturo on 10/06/2017.
 */

public class MascotaAdapter extends RecyclerView.Adapter<MascotaAdapter.MascotaViewHolder>
{
    ArrayList<Mascota> mascotas;
    Context activity;

    public MascotaAdapter(ArrayList<Mascota> mascotas, Activity activity){
        this.mascotas = mascotas;
        this.activity = activity;
    }

    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.carview_mascota, parent, false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final MascotaViewHolder mascotaViewHolder, int position) {
        final Mascota mascota = mascotas.get(position);
        mascotaViewHolder.imFoto.setImageResource(mascota.getFotoMascota());
        mascotaViewHolder.tvNombreMascota.setText(mascota.getNombreMascota());
        mascotaViewHolder.tvLikeMascota.setText(mascota.getLikeMascota());


        mascotaViewHolder.imLikeMascota.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v) {

                Toast.makeText(activity, "Diste like a " + mascota.getNombreMascota(),
                        Toast.LENGTH_SHORT).show();

                ConstructorMascotas constructorMascotas = new ConstructorMascotas(activity);
                constructorMascotas.darLikeMascota(mascota);
                mascotaViewHolder.tvLikeMascota.setText(String.valueOf(constructorMascotas.obtenerLikeMascota(mascota)));
            }
        }
        );

//        mascotaViewHolder.imLikeMascota.setImageResource(mascota.g());

/*        mascotaViewHolder.imLikeMascota.setOnClickListener((v) = {
                Toast.makeText(MainActivity, mascota.getNombreMascota(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity, Mascota.class);
        });*/

    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder
    {
        private ImageView imFoto;
        private TextView tvNombreMascota;
        private TextView tvLikeMascota;
        private ImageButton imLikeMascota;

        public MascotaViewHolder(View itemView) {
            super(itemView);
            imFoto = (ImageView) itemView.findViewById(R.id.imImagenMascota);
            tvNombreMascota = (TextView) itemView.findViewById(R.id.tvNombreMascota);
            tvLikeMascota = (TextView) itemView.findViewById(R.id.tvLikeMascota);
            imLikeMascota = (ImageButton) itemView.findViewById(R.id.btnLike);
        }
    }
}
