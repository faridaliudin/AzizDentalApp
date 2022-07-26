package com.example.azizdentalapp;

public class ModelPasien {
    private String nama;
    private String umur;
    private String telepon;
    private String keluhan;
    private String key;

    public ModelPasien(){

    }

    public ModelPasien(String nama, String umur, String telepon, String keluhan) {
        this.nama = nama;
        this.umur = umur;
        this.telepon = telepon;
        this.keluhan = keluhan;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getUmur() {
        return umur;
    }

    public void setUmur(String umur) {
        this.umur = umur;
    }

    public String getTelepon() {
        return telepon;
    }

    public void setTelepon(String telepon) {
        this.telepon = telepon;
    }

    public String getKeluhan() {
        return keluhan;
    }

    public void setKeluhan(String keluhan) {
        this.keluhan = keluhan;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
