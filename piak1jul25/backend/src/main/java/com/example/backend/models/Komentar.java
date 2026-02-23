package com.example.backend.models;
/*Columns:
idK
int AI PK
proizvod
int
tekst
varchar(45)
korisnik
varchar(45)
status
varchar(45)
 */
public class Komentar {
    private int idK;
    private int proizvod;
    private String tekst;
    private String korisnik;
    private String status;
    public int getIdK() {
        return idK;
    }
    public void setIdK(int idK) {
        this.idK = idK;
    }
    public int getProizvod() {
        return proizvod;
    }
    public void setProizvod(int proizvod) {
        this.proizvod = proizvod;
    }
    public String getTekst() {
        return tekst;
    }
    public void setTekst(String tekst) {
        this.tekst = tekst;
    }
    public String getKorisnik() {
        return korisnik;
    }
    public void setKorisnik(String korisnik) {
        this.korisnik = korisnik;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public Komentar(int idK, int proizvod, String tekst, String korisnik, String status) {
        this.idK = idK;
        this.proizvod = proizvod;
        this.tekst = tekst;
        this.korisnik = korisnik;
        this.status = status;
    }


    
}
