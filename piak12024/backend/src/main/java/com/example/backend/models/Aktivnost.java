package com.example.backend.models;
//datum potrebno prijavljeno
public class Aktivnost {
    private int idA;
    private String naziv;
    private String datum;
    private int potrebno;
    private int prijavljeno;

    

    public Aktivnost(int idA, String naziv, String datum, int potrebno, int prijavljeno) {
        this.idA = idA;
        this.naziv = naziv;
        this.datum = datum;
        this.potrebno = potrebno;
        this.prijavljeno = prijavljeno;
    }
    public int getIdA() {
        return idA;
    }
    public void setIdA(int idA) {
        this.idA = idA;
    }
    public String getNaziv() {
        return naziv;
    }
    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }
    public String getDatum() {
        return datum;
    }
    public void setDatum(String datum) {
        this.datum = datum;
    }
    public int getPotrebno() {
        return potrebno;
    }
    public void setPotrebno(int potrebno) {
        this.potrebno = potrebno;
    }
    public int getPrijavljeno() {
        return prijavljeno;
    }
    public void setPrijavljeno(int prijavljeno) {
        this.prijavljeno = prijavljeno;
    }

    

}
