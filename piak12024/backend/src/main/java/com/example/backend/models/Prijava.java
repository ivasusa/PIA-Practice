package com.example.backend.models;

public class Prijava {
    private int idP;
    private String volonter;
    private int aktivnost;
    private String status;
    
    public Prijava(int idP, String volonter, int aktivnost, String status) {
        this.idP = idP;
        this.volonter = volonter;
        this.aktivnost = aktivnost;
        this.status = status;
    }
    public int getIdP() {
        return idP;
    }
    public void setIdP(int idP) {
        this.idP = idP;
    }
    public String getVolonter() {
        return volonter;
    }
    public void setVolonter(String volonter) {
        this.volonter = volonter;
    }
    public int getAktivnost() {
        return aktivnost;
    }
    public void setAktivnost(int aktivnost) {
        this.aktivnost = aktivnost;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }


    
}
