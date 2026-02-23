package com.example.backend.models;

public class Korisnici {
    private String korisnicko_ime;
    private String lozinka;
    private String ime;
    private String prezime;
    private String tip;


    
    public Korisnici(String korisnicko_ime, String lozinka, String ime, String prezime, String tip) {
        this.korisnicko_ime = korisnicko_ime;
        this.lozinka = lozinka;
        this.ime = ime;
        this.prezime = prezime;
        this.tip = tip;
    }
    public String getKorisnicko_ime() {
        return korisnicko_ime;
    }
    public String getLozinka() {
        return lozinka;
    }
    public String getIme() {
        return ime;
    }
    public String getPrezime() {
        return prezime;
    }
    public String getTip() {
        return tip;
    } 
    
}
