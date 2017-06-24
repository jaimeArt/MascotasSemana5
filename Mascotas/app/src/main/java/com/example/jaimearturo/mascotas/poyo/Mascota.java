package com.example.jaimearturo.mascotas.poyo;

/**
 * Created by JaimeArturo on 10/06/2017.
 */

public class Mascota {
    private int idMascota;
    private int fotoMascota;
    private String nombreMascota;
    private String likeMascota;

    public Mascota(int fotoMascota, String nombreMascota, String likeMascota) {
        this.idMascota = idMascota;
        this.fotoMascota = fotoMascota;
        this.nombreMascota = nombreMascota;
        this.likeMascota = likeMascota;
    }

    public Mascota() {

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

    public String getLikeMascota() {
        return likeMascota;
    }

    public void setLikeMascota(String likeMascota) {
        this.likeMascota = likeMascota;
    }

    public int getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(int idMascota) {
        this.idMascota = idMascota;
    }
}
