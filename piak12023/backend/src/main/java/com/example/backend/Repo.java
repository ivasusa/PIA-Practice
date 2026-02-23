package com.example.backend;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.backend.db.DB;
import com.example.backend.models.Korisnici;

public class Repo {

   public Korisnici prijava(Korisnici korisnik) {
        try (Connection conn = DB.source().getConnection();
                PreparedStatement stmt = conn.prepareStatement(
                        "select * from korisnici where korisnicko_ime = ? and lozinka = ? and tip = ?")) {

            stmt.setString(1, korisnik.getKorisnicko_ime());
            stmt.setString(2, korisnik.getLozinka());
            stmt.setString(3, korisnik.getTip());

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Korisnici(
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
    
}
