package com.example.backend;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;

import com.example.backend.db.DB;
import com.example.backend.models.Komentar;
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
                        rs.getString("ime"),
                        rs.getString("prezime"),
                        rs.getString("mejl"),
                        rs.getString("tip"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

public List<Proizvod> dohvatiProizvode() {
     List<Proizvod> res = new ArrayList<>();

        try (Connection conn = DB.source().getConnection();
                PreparedStatement stmt = conn.prepareStatement("select * from proizvodi")) {

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Proizvod a = new Proizvod(
                        rs.getInt("idP"),
                        rs.getString("naziv"),
                        rs.getString("opis"),
                        rs.getInt("cena"),
                        rs.getString("slika"));

                res.add(a);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return res;
}

public List<Komentar> dohvatiKomentare(int idP) {
   List<Komentar> res = new ArrayList<>();

        try (Connection conn = DB.source().getConnection();
                PreparedStatement stmt = conn.prepareStatement("select * from komentari where proizvod = ? and status = 'odobren'")) {
            stmt.setInt(1, idP);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Komentar a = new Komentar(
                        rs.getInt("idK"),
                        rs.getInt("proizvod"),
                        rs.getString("tekst"),
                        rs.getString("korisnik"),
                        rs.getString("status"));

                res.add(a);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return res;

}

public void kupi(int proizvod, String kupac) {
    try (Connection conn = DB.source().getConnection();
         PreparedStatement stmtInsert = conn.prepareStatement(
                 "insert into narudzbine (proizvod, kolicina, kupac) values (?, ?, ?)")) {

        stmtInsert.setInt(1, proizvod);
        stmtInsert.setInt(2, 1);
        stmtInsert.setString(3, kupac);

        stmtInsert.executeUpdate();

    } catch (SQLException e) {
        e.printStackTrace();
    }
}

public void komentarisi(Komentar komentar) {
    try (Connection conn = DB.source().getConnection();
         PreparedStatement stmtInsert = conn.prepareStatement(
                 "insert into komentari (proizvod, tekst, korisnik, status) values (?, ?, ?, 'neodobren')")) {

        stmtInsert.setInt(1, komentar.getProizvod());
        stmtInsert.setString(2, komentar.getTekst());
        stmtInsert.setString(3, komentar.getKorisnik());

        stmtInsert.executeUpdate();

    } catch (SQLException e) {
        e.printStackTrace();
    }
}

public List<Komentar> dohvatiNeodobreneKomentare() {
   List<Komentar> res = new ArrayList<>();

        try (Connection conn = DB.source().getConnection();
                PreparedStatement stmt = conn.prepareStatement("select * from komentari where status = 'neodobren'")) {

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Komentar a = new Komentar(
                        rs.getInt("idK"),
                        rs.getInt("proizvod"),
                        rs.getString("tekst"),
                        rs.getString("korisnik"),
                        rs.getString("status"));

                res.add(a);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return res;
}

public void odbaci(Komentar komentar) {
try (Connection conn = DB.source().getConnection();
                PreparedStatement stmtUpdate = conn
                        .prepareStatement("update komentari set status = 'odbijen' where idK = ?")) {
            stmtUpdate.setInt(1, komentar.getIdK());

            stmtUpdate.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

public void odobri(Komentar komentar) {
    try (Connection conn = DB.source().getConnection();
                PreparedStatement stmtUpdate = conn
                        .prepareStatement("update komentari set status = 'odobren' where idK = ?")) {
            stmtUpdate.setInt(1, komentar.getIdK());

            stmtUpdate.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
}
}

