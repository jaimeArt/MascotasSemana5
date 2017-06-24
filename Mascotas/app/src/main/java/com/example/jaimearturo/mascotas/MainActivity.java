package com.example.jaimearturo.mascotas;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.jaimearturo.mascotas.adapter.PageAdapter;
import com.example.jaimearturo.mascotas.view_fragments.FavoritosFragment;
import com.example.jaimearturo.mascotas.view_fragments.RecycleViewFragment;
import com.example.jaimearturo.mascotas.poyo.Mascota;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMasotas;
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        setUpViewPager();
        /*
        listaMasotas =(RecyclerView)findViewById(R.id.rvMascotas);
        LinearLayoutManager lim = new LinearLayoutManager(this);
        lim.setOrientation(LinearLayoutManager.VERTICAL);
        listaMasotas.setLayoutManager(lim);
        inicializarListaMascotas();
        inicializarAdaptador();
        */
        if(toolbar != null)
        {
            setSupportActionBar(toolbar);
        }

    }

    public void irMascotaPreferida(View v)
    {
        Intent intentMascota = new Intent(this, MascotaActivity.class);
        startActivity(intentMascota);
    }

/*    public void inicializarAdaptador()
    {
        MascotaAdapter adaptador = new MascotaAdapter(mascotas);
        listaMasotas.setAdapter(adaptador);

    }
    public void inicializarListaMascotas()
    {
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota(R.drawable.conejo, "Max", "9"));
        mascotas.add(new Mascota(R.drawable.gato, "Tomas", "10"));
        mascotas.add(new Mascota(R.drawable.hamster, "Flor", "2"));
        mascotas.add(new Mascota(R.drawable.loro, "Roberto", "5"));
        mascotas.add(new Mascota(R.drawable.perro, "Nicky", "15"));
    }*/

    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new RecycleViewFragment());
        fragments.add(new FavoritosFragment());
        return fragments;
    }

    private void setUpViewPager()
    {
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_home);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_action_name);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menus, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.mAbout:
                    Intent intentAbout = new Intent(this, AboutActivity.class);
                    startActivity(intentAbout);
                break;
            case R.id.mContacto:
                Intent intentContacto = new Intent(this, ContactoActivity.class);
                startActivity(intentContacto);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
