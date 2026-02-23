package com.example.backend.models;

public class Proizvod {
    //naziv opis cena
    private String naziv;
    private String opis;
    private int cena;

    public Proizvod(String naziv, String opis, int cena) {
        this.naziv = naziv;
        this.opis = opis;
        this.cena = cena;
    }

    public Proizvod() {
        //TODO Auto-generated constructor stub
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public int getCena() {
        return cena;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }

   
    
}
