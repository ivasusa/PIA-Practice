package com.example.backend.models;

public class Korisnik {
    private String kor_ime;
    private String lozinka;
    private String tip;

    public Korisnik(String kor_ime, String lozinka, String tip) {
        this.kor_ime = kor_ime;
        this.lozinka = lozinka;
        this.tip = tip;
    }

    public Korisnik() {
    }

    public String getKor_ime() {
        return kor_ime;
    }

    public void setKor_ime(String kor_ime) {
        this.kor_ime = kor_ime;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    

}
