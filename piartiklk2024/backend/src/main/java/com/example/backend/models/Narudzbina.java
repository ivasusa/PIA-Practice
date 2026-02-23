package com.example.backend.models;

public class Narudzbina {
    /* id
int AI PK
kupac
varchar(50)
pica
varchar(50)
velicina
varchar(50)
dodaci
varchar(200)
cena
int
status
varchar(50)
*/
private int id;
private String kupac;
private String pica;
private String velicina;
private String dodaci;
private int cena;
private String status;
public Narudzbina() {}
public Narudzbina(int id, String kupac, String pica, String velicina, String dodaci, int cena, String status) {
    this.id = id;
    this.kupac = kupac;
    this.pica = pica;
    this.velicina = velicina;
    this.dodaci = dodaci;
    this.cena = cena;
    this.status = status;   }
public int getId() {
    return id;
}
public void setId(int id) {
    this.id = id;
}
public String getKupac() {
    return kupac;
}
public void setKupac(String kupac) {
    this.kupac = kupac;
}
public String getPica() {
    return pica;
}
public void setPica(String pica) {
    this.pica = pica;
}
public String getVelicina() {
    return velicina;
}
public void setVelicina(String velicina) {
    this.velicina = velicina;
}
public String getDodaci() {
    return dodaci;
}
public void setDodaci(String dodaci) {
    this.dodaci = dodaci;
}
public int getCena() {
    return cena;
}
public void setCena(int cena) {
    this.cena = cena;
}
public String getStatus() {
    return status;
}
public void setStatus(String status) {
    this.status = status;
}
    
}
