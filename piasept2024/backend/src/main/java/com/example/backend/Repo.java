package com.example.backend;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.backend.db.DB;
import com.example.backend.models.Aukcija;
import com.example.backend.models.Korisnik;
import com.example.backend.models.Umetnina;

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
                        rs.getString("mejl"),
                        rs.getString("tip"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<Aukcija> dohvatiAktuelneAukcije() {
        List<Aukcija> res = new ArrayList<>();

        try (Connection conn = DB.source().getConnection();
                PreparedStatement stmt = conn.prepareStatement("select * from aukcije order by kraj")) {

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Aukcija a = new Aukcija(
                        rs.getInt("idA"),
                        rs.getString("naziv"),
                        rs.getString("pocetak"),
                        rs.getString("kraj")
                       );

                res.add(a);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return res;
    }

    public List<Umetnina> dohvatiUmetnine(int idAkt) {
    List<Umetnina> res = new ArrayList<>();

        try (Connection conn = DB.source().getConnection();
                PreparedStatement stmt = conn.prepareStatement("select * from umetnine where idA = ?")) {

            stmt.setInt(1, idAkt);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Umetnina a = new Umetnina(
                        rs.getInt("idU"),
                        rs.getInt("idA"),
                        rs.getString("naziv"),
                        rs.getInt("ponuda"),
                        rs.getString("vlasnik")
                    
                       );

                res.add(a);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return res;    }

    public void unesiPonudu(int idU, int ponuda, String korisnik) {
        try (Connection conn = DB.source().getConnection();
                PreparedStatement stmtUpdate = conn
                        .prepareStatement("update umetnine set ponuda = ?, vlasnik = ? where idU = ?")) {
            stmtUpdate.setInt(1, ponuda);
            stmtUpdate.setString(2, korisnik);
            stmtUpdate.setInt(3, idU);

            stmtUpdate.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Umetnina> mojeUmetnine(String korisnicko_ime) {
    List<Umetnina> res = new ArrayList<>();

        try (Connection conn = DB.source().getConnection();
                PreparedStatement stmt = conn.prepareStatement("select * from umetnine where vlasnik = ?")) {

            stmt.setString(1, korisnicko_ime);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Umetnina a = new Umetnina(
                        rs.getInt("idU"),
                        rs.getInt("idA"),
                        rs.getString("naziv"),
                        rs.getInt("ponuda"),
                        rs.getString("vlasnik")
                    
                       );

                res.add(a);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return res;     
    }
    }

