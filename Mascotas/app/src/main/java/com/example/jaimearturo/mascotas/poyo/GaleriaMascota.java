package com.example.jaimearturo.mascotas.poyo;

/**
 * Created by JaimeArturo on 10/06/2017.
 */

public class GaleriaMascota {
    private int fotoMascota;
    private String nombreMascota;


    public GaleriaMascota(int fotoMascota, String nombreMascota) {
        this.fotoMascota = fotoMascota;
        this.nombreMascota = nombreMascota;

    }

    public int getFotoMascota() {
        return fotoMascota;
    }

    public void setFotoMascota(int fotoMascota) {
        this.fotoMascota = fotoMascota;
    }

    public String getNombreMascota() {
        return nombreMascota;
    }

    public void setNombreMascota(String nombreMascota) {
        this.nombreMascota = nombreMascota;
    }
}
