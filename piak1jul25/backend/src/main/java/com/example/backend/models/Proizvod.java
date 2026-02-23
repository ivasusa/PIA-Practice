package com.example.backend.models;

public class Proizvod {
    private int idP;
    private String naziv;
    private String opis;
    private int cena;
    private String slika;

    public Proizvod(int idP, String naziv, String opis, int cena, String slika) {
        this.idP = idP;
        this.naziv = naziv;
        this.opis = opis;
        this.cena = cena;
        this.slika = slika;
    }

    public int getIdP() {
        return idP;
    }

    public void setIdP(int idP) {
        this.idP = idP;
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

    public String getSlika() {
        return slika;
    }

    public void setSlika(String slika) {
        this.slika = slika;
    }
}
