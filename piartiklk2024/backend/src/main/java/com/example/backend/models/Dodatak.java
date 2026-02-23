package com.example.backend.models;

public class Dodatak {

private String naziv;
private int cena;
private boolean dostupan;
public Dodatak() {}
public Dodatak(String naziv, int cena, boolean dostupan) {
    this.naziv = naziv;
    this.cena = cena;
    this.dostupan = dostupan;
}
public String getNaziv() {
    return naziv;
}
public void setNaziv(String naziv) {
    this.naziv = naziv;
}
public int getCena() {
    return cena;
}
public void setCena(int cena) {
    this.cena = cena;
}
public boolean isDostupan() {
    return dostupan;
}
public void setDostupan(boolean dostupan) {
    this.dostupan = dostupan;
}

}
