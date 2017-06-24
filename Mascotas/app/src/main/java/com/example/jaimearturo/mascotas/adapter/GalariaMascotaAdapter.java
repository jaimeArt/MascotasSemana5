package com.example.jaimearturo.mascotas.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jaimearturo.mascotas.R;
import com.example.jaimearturo.mascotas.poyo.GaleriaMascota;
import com.example.jaimearturo.mascotas.poyo.Mascota;
import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by JaimeArturo on 10/06/2017.
 */

public class GalariaMascotaAdapter extends RecyclerView.Adapter<GalariaMascotaAdapter.MascotaViewHolder>
{
    ArrayList<GaleriaMascota> galeriaMascotas;

    public GalariaMascotaAdapter(ArrayList<GaleriaMascota> galeriaMascotas){
        this.galeriaMascotas = galeriaMascotas;
    }

    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.carview_galeria_mascota, parent, false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MascotaViewHolder mascotaViewHolder, int position) {
        GaleriaMascota galeriaMascota = galeriaMascotas.get(position);
        mascotaViewHolder.imFoto.setImageResource(galeriaMascota.getFotoMascota());

        mascotaViewHolder.imFoto11.setImageResource(galeriaMascota.getFotoMascota());
        mascotaViewHolder.imFoto12.setImageResource(galeriaMascota.getFotoMascota());
        mascotaViewHolder.imFoto13.setImageResource(galeriaMascota.getFotoMascota());
        mascotaViewHolder.imFoto21.setImageResource(galeriaMascota.getFotoMascota());
        mascotaViewHolder.imFoto22.setImageResource(galeriaMascota.getFotoMascota());
        mascotaViewHolder.imFoto23.setImageResource(galeriaMascota.getFotoMascota());
        mascotaViewHolder.imFoto31.setImageResource(galeriaMascota.getFotoMascota());
        mascotaViewHolder.imFoto32.setImageResource(galeriaMascota.getFotoMascota());
        mascotaViewHolder.imFoto33.setImageResource(galeriaMascota.getFotoMascota());

       mascotaViewHolder.tvLikeMascota11.setText(Aleatorio());
       mascotaViewHolder.tvLikeMascota12.setText(Aleatorio());
       mascotaViewHolder.tvLikeMascota13.setText(Aleatorio());
       mascotaViewHolder.tvLikeMascota21.setText(Aleatorio());
       mascotaViewHolder.tvLikeMascota22.setText(Aleatorio());
       mascotaViewHolder.tvLikeMascota23.setText(Aleatorio());
       mascotaViewHolder.tvLikeMascota31.setText(Aleatorio());
       mascotaViewHolder.tvLikeMascota32.setText(Aleatorio());
       mascotaViewHolder.tvLikeMascota33.setText(Aleatorio());

        mascotaViewHolder.tvNombreMascota.setText(galeriaMascota.getNombreMascota());

    }

    public String Aleatorio()
    {
        Random generar = new Random();
        int absoluto = Math.abs(generar.nextInt() % 10);
        return String.valueOf(absoluto);
    }

    @Override
    public int getItemCount() {
        return galeriaMascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder
    {
        private ImageView imFoto;
        private ImageView imFoto11;
        private ImageView imFoto12;
        private ImageView imFoto13;
        private ImageView imFoto21;
        private ImageView imFoto22;
        private ImageView imFoto23;
        private ImageView imFoto31;
        private ImageView imFoto32;
        private ImageView imFoto33;

        private TextView  tvLikeMascota11;
        private TextView  tvLikeMascota12;
        private TextView  tvLikeMascota13;
        private TextView  tvLikeMascota21;
        private TextView  tvLikeMascota22;
        private TextView  tvLikeMascota23;
        private TextView  tvLikeMascota31;
        private TextView  tvLikeMascota32;
        private TextView  tvLikeMascota33;

        private TextView tvNombreMascota;

        public MascotaViewHolder(View itemView) {
            super(itemView);
            imFoto = (ImageView) itemView.findViewById(R.id.imImagenMascota);

            imFoto11 = (ImageView) itemView.findViewById(R.id.imImagenMascota11);
            imFoto12 = (ImageView) itemView.findViewById(R.id.imImagenMascota12);
            imFoto13 = (ImageView) itemView.findViewById(R.id.imImagenMascota13);
            imFoto21 = (ImageView) itemView.findViewById(R.id.imImagenMascota21);
            imFoto22 = (ImageView) itemView.findViewById(R.id.imImagenMascota22);
            imFoto23 = (ImageView) itemView.findViewById(R.id.imImagenMascota23);
            imFoto31 = (ImageView) itemView.findViewById(R.id.imImagenMascota31);
            imFoto32 = (ImageView) itemView.findViewById(R.id.imImagenMascota32);
            imFoto33 = (ImageView) itemView.findViewById(R.id.imImagenMascota33);

            tvLikeMascota11 = (TextView) itemView.findViewById(R.id.tvLikeMascota11);
            tvLikeMascota12 = (TextView) itemView.findViewById(R.id.tvLikeMascota12);
            tvLikeMascota13 = (TextView) itemView.findViewById(R.id.tvLikeMascota13);
            tvLikeMascota21 = (TextView) itemView.findViewById(R.id.tvLikeMascota21);
            tvLikeMascota22 = (TextView) itemView.findViewById(R.id.tvLikeMascota22);
            tvLikeMascota23 = (TextView) itemView.findViewById(R.id.tvLikeMascota23);
            tvLikeMascota31 = (TextView) itemView.findViewById(R.id.tvLikeMascota31);
            tvLikeMascota32 = (TextView) itemView.findViewById(R.id.tvLikeMascota32);
            tvLikeMascota33 = (TextView) itemView.findViewById(R.id.tvLikeMascota33);

            tvNombreMascota = (TextView) itemView.findViewById(R.id.tvNombreMascota);
        }
    }
}


