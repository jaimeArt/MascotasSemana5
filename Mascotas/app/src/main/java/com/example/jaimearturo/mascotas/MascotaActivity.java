package com.example.jaimearturo.mascotas;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.jaimearturo.mascotas.adapter.PageAdapter;
import com.example.jaimearturo.mascotas.poyo.Mascota;
import com.example.jaimearturo.mascotas.view_fragments.RecycleViewLikeFragment;

import java.util.ArrayList;

public class MascotaActivity extends AppCompatActivity {
    ArrayList<Mascota> mascotas;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mascota);


        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        setUpViewPager();
 /*
        getActionBar().setHomeButtonEnabled(true);

        listaMasotas =(RecyclerView)findViewById(R.id.rvMascotas);
        LinearLayoutManager lim = new LinearLayoutManager(this);
        lim.setOrientation(LinearLayoutManager.VERTICAL);
        listaMasotas.setLayoutManager(lim);
        inicializarListaMascotas();
        inicializarAdaptador();
*/

    }

    private void setUpViewPager()
    {
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragments()));

    }

    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new RecycleViewLikeFragment());
         return fragments;
    }

/*    public void irMascota(View v)
    {
        NavUtils.navigateUpFromSameTask(this);
*//*        Intent intentMascota = new Intent(this, MainActivity.class);
        startActivity(intentMascota);*//*
    }
    public void inicializarAdaptador()
    {
        MascotaAdapter adaptador = new MascotaAdapter(mascotas, this);
        listaMasotas.setAdapter(adaptador);

    }
    public void inicializarListaMascotas()
    {
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota( R.drawable.conejo, "Max", "9"));
        mascotas.add(new Mascota(R.drawable.gato, "Tomas", "10"));
        mascotas.add(new Mascota(R.drawable.perro, "Nicky", "15"));
    }*/
}
