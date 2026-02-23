package com.example.backend.models;
/*Columns:
idN
int AI PK
proizvod
int
kolicina
int
kupac
varchar(45)
*/
public class Narudzbina {
    private int idN;
    private int proizvod;
    private int kolicina;
    private String kupac;

    public Narudzbina() {
    }

    public Narudzbina(int idN, int proizvod, int kolicina, String kupac) {
        this.idN = idN;
        this.proizvod = proizvod;
        this.kolicina = kolicina;
        this.kupac = kupac;
    }

    public int getIdN() {
        return idN;
    }

    public void setIdN(int idN) {
        this.idN = idN;
    }

    public int getProizvod() {
        return proizvod;
    }

    public void setProizvod(int proizvod) {
        this.proizvod = proizvod;
    }

    public int getKolicina() {
        return kolicina;
    }

    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }

    public String getKupac() {
        return kupac;
    }

    public void setKupac(String kupac) {
        this.kupac = kupac;
    }
}
