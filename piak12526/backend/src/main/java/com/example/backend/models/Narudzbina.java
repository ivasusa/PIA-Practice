package com.example.backend.models;

public class Narudzbina {

    private int idN;
    private String kupac;
    private String proizvodi;
    private int racun;
    private String datum;
    public int getIdN() {
        return idN;
    }
    public void setIdN(int idN) {
        this.idN = idN;
    }
    public String getKupac() {
        return kupac;
    }
    public void setKupac(String kupac) {
        this.kupac = kupac;
    }
    public String getProizvodi() {
        return proizvodi;
    }
    public void setProizvodi(String proizvodi) {
        this.proizvodi = proizvodi;
    }
    public int getRacun() {
        return racun;
    }
    public void setRacun(int racun) {
        this.racun = racun;
    }
    public String getDatum() {
        return datum;
    }
    public void setDatum(String datum) {
        this.datum = datum;
    }
    public Narudzbina(int idN, String kupac, String proizvodi, int racun, String datum) {
        this.idN = idN;
        this.kupac = kupac;
        this.proizvodi = proizvodi;
        this.racun = racun;
        this.datum = datum;
    }

}
