package com.example.backend.models;

public class Pica {
    /*naziv
varchar(50) PK
cena
int
opis
varchar(100)
 */
private String naziv;
private int cena;
private String opis;        
public Pica() {}
public Pica(String naziv, int cena, String opis) {
    this.naziv = naziv;
    this.cena = cena;
    this.opis = opis;   
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
public String getOpis() {
    return opis;
}
public void setOpis(String opis) {
    this.opis = opis;
}

}
