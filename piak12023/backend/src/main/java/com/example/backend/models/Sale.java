package com.example.backend.models;

public class Sale {
    private String naziv;
    private int broj_mesta;

    public Sale(String naziv, int broj_mesta) {
        this.naziv = naziv;
        this.broj_mesta = broj_mesta;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getBroj_mesta() {
        return broj_mesta;
    }

    public void setBroj_mesta(int broj_mesta) {
        this.broj_mesta = broj_mesta;
    }
    
}
