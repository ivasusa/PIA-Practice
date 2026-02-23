package com.example.backend.models;

public class PrijavljeniVolonter {
    private String kor_ime;
    private String ime;
    private String prezime;
    private String status;

    public PrijavljeniVolonter(String kor_ime, String ime, String prezime, String status) {
        this.kor_ime = kor_ime;
        this.ime = ime;
        this.prezime = prezime;
        this.status = status;
    }

    public String getKor_ime() {
        return kor_ime;
    }

    public void setKor_ime(String kor_ime) {
        this.kor_ime = kor_ime;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
