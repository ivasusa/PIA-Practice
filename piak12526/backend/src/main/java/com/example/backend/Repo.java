package com.example.backend;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.backend.db.DB;
import com.example.backend.models.Korisnik;
import com.example.backend.models.Proizvod;

public class Repo {

    public Korisnik prijava(Korisnik korisnik) {
        try (Connection conn = DB.source().getConnection();
                PreparedStatement stmt = conn.prepareStatement(
                        "select * from korisnici where kor_ime = ? and lozinka = ? and tip = ?")) {

            stmt.setString(1, korisnik.getKor_ime());
            stmt.setString(2, korisnik.getLozinka());
            stmt.setString(3, korisnik.getTip());

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Korisnik(
                        rs.getString("kor_ime"),
                        rs.getString("lozinka"),
                        rs.getString("tip"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
}

public List<Proizvod> sviProizvodi() {

        List<Proizvod> res = new ArrayList<>();

        try (Connection conn = DB.source().getConnection();
                PreparedStatement stmt = conn.prepareStatement("select * from proizvodi")) {

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Proizvod a = new Proizvod(
                        rs.getString("naziv"),
                        rs.getString("opis"),
                        rs.getInt("cena"));

                res.add(a);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return res;
    }

public Proizvod detaljiProizvod(String naziv) {

         Proizvod res = new Proizvod();
        try (Connection conn = DB.source().getConnection();
                PreparedStatement stmt = conn.prepareStatement(
                        "select * from proizvodi where naziv = ?")) {
            stmt.setString(1, naziv);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Proizvod a = new Proizvod(
                        rs.getString("naziv"),
                        rs.getString("opis"),
                        rs.getInt("cena"));
                res = a;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return res;  
}

public boolean izmeni(Proizvod p) {
    try (Connection conn = DB.source().getConnection();
         PreparedStatement stmt = conn.prepareStatement(
             "update proizvodi set cena = ?, opis = ? where naziv = ?")) {

        stmt.setInt(1, p.getCena());   
        stmt.setString(2, p.getOpis());
        stmt.setString(3, p.getNaziv());

        return stmt.executeUpdate() > 0;
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return false;
}

    



}
