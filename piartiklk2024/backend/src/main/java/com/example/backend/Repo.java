package com.example.backend;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.backend.db.DB;
import com.example.backend.models.Dodatak;
import com.example.backend.models.Korisnik;
import com.example.backend.models.Narudzbina;
import com.example.backend.models.Pica;

public class Repo {
    public Korisnik prijava(Korisnik korisnik) {
        try (Connection conn = DB.source().getConnection();
                PreparedStatement stmt = conn.prepareStatement(
                        "select * from korisnici where korisnicko_ime = ? and lozinka = ? and tip = ?")) {

            stmt.setString(1, korisnik.getKorisnicko_ime());
            stmt.setString(2, korisnik.getLozinka());
            stmt.setString(3, korisnik.getTip());

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Korisnik(
                        rs.getString("korisnicko_ime"),
                        rs.getString("lozinka"),
                        rs.getString("ime"),
                        rs.getString("prezime"),
                        rs.getString("tip"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<Pica> dohvatiPice() {

        List<Pica> res = new ArrayList<>();

        try (Connection conn = DB.source().getConnection();
                PreparedStatement stmt = conn.prepareStatement("select * from pice")) {

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Pica a = new Pica(
                        rs.getString("naziv"),
                        rs.getInt("cena"),
                        rs.getString("opis"));
                res.add(a);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return res;
    }
    

    public List<Narudzbina> dohvatiMojeNarudzbine(String username) {

        List<Narudzbina> res = new ArrayList<>();

        try (Connection conn = DB.source().getConnection();
                PreparedStatement stmt = conn.prepareStatement("select * from narudzbine where kupac = ?")) {

            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Narudzbina a = new Narudzbina(
                        rs.getInt("id"),
                        rs.getString("kupac"),
                        rs.getString("pica"),
                        rs.getString("velicina"),
                        rs.getString("dodaci"),
                        rs.getInt("cena"),
                        rs.getString("status"));    

                res.add(a);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return res;
    }

    public List<Narudzbina> dohvatiSveNarudzbine() {

        List<Narudzbina> res = new ArrayList<>();

        try (Connection conn = DB.source().getConnection();
                PreparedStatement stmt = conn.prepareStatement("select * from narudzbine ")) {


            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Narudzbina a = new Narudzbina(
                        rs.getInt("id"),
                        rs.getString("kupac"),
                        rs.getString("pica"),
                        rs.getString("velicina"),
                        rs.getString("dodaci"),
                        rs.getInt("cena"),
                        rs.getString("status"));    

                res.add(a);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return res; }

    public List<Dodatak> dohvatiSveDodatke() {
    List<Dodatak> res = new ArrayList<>();

        try (Connection conn = DB.source().getConnection();
                PreparedStatement stmt = conn.prepareStatement("select * from dodaci ")) {


            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Dodatak a = new Dodatak(
                        rs.getString("naziv"),
                        rs.getInt("cena"),
                        rs.getBoolean("dostupan"));
                        
                res.add(a);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return res;    
    }

    public boolean prihvati(Narudzbina narudzbina) {
try (Connection conn = DB.source().getConnection();
                PreparedStatement stmtUpdate = conn
                        .prepareStatement("update narudzbine set status = 'prihvacena' where id = ?")) {
            stmtUpdate.setInt(1, narudzbina.getId());

            return stmtUpdate.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean odbij(Narudzbina narudzbina) {
try (Connection conn = DB.source().getConnection();
                PreparedStatement stmtUpdate = conn
                        .prepareStatement("update narudzbine set status = 'odbijena' where id = ?")) {
            stmtUpdate.setInt(1, narudzbina.getId());

            return stmtUpdate.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean gotovo(Narudzbina narudzbina) {
     try (Connection conn = DB.source().getConnection();
                PreparedStatement stmtInsert = conn
                        .prepareStatement("insert into narudzbine (kupac, pica, velicina, dodaci, cena, status) values (?, ?, ?, ?, ?, 'nova')");)
 {

            stmtInsert.setString(1, narudzbina.getKupac());
            stmtInsert.setString(2, narudzbina.getPica());
            stmtInsert.setString(3, narudzbina.getVelicina());
            stmtInsert.setString(4, narudzbina.getDodaci());
            stmtInsert.setInt(5, narudzbina.getCena());
            int insertRes = stmtInsert.executeUpdate();
            return insertRes > 0 ;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean dostupno(Dodatak dodatak) {
       try (Connection conn = DB.source().getConnection();
                PreparedStatement stmtUpdate = conn
                        .prepareStatement("update dodaci set dostupan = true where naziv = ?")) {
            stmtUpdate.setString(1, dodatak.getNaziv());

            return stmtUpdate.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean nedostupno(Dodatak dodatak) {
        try (Connection conn = DB.source().getConnection();
                PreparedStatement stmtUpdate = conn
                        .prepareStatement("update dodaci set dostupan = false where naziv = ?")) {
            stmtUpdate.setString(1, dodatak.getNaziv());

            return stmtUpdate.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
    }

