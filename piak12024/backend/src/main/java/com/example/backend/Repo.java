package com.example.backend;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.backend.db.DB;
import com.example.backend.models.Aktivnost;
import com.example.backend.models.Korisnik;
import com.example.backend.models.PrijavljeniVolonter;

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

    public List<Aktivnost> dohvatiAktuelneAktivnosti() {

        List<Aktivnost> res = new ArrayList<>();

        try (Connection conn = DB.source().getConnection();
                PreparedStatement stmt = conn.prepareStatement("select * from aktivnosti where datum >= '2024-01-01'")) {

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Aktivnost a = new Aktivnost(
                        rs.getInt("idA"),
                        rs.getString("naziv"),
                        rs.getString("datum"),
                        rs.getInt("potrebno"),
                        rs.getInt("prijavljeno"));

                res.add(a);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return res;
    }

    public boolean postojiPrijava(String kor_ime, int idA) {
        try (Connection conn = DB.source().getConnection();
                PreparedStatement stmt = conn
                        .prepareStatement("select 1 from prijave where volonter = ? and aktivnost = ?")) {

            stmt.setString(1, kor_ime);
            stmt.setInt(2, idA);

            ResultSet rs = stmt.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

public void prijavi(String kor_ime, int idA) {
    Connection conn = null;

    try {
        conn = DB.source().getConnection();
        conn.setAutoCommit(false);

        try (PreparedStatement stmtAktivnost = conn
                .prepareStatement("select potrebno, prijavljeno from aktivnosti where idA = ?");
             PreparedStatement stmtPostoji = conn
                .prepareStatement("select 1 from prijave where volonter = ? and aktivnost = ?");
             PreparedStatement stmtInsert = conn
                .prepareStatement("insert into prijave (volonter, aktivnost, status) values (?, ?, ?)")) {

            stmtAktivnost.setInt(1, idA);
            ResultSet rsAktivnost = stmtAktivnost.executeQuery();
            if (!rsAktivnost.next()) { conn.rollback(); return; }

            int potrebno = rsAktivnost.getInt("potrebno");
            int prijavljeno = rsAktivnost.getInt("prijavljeno");
            if (prijavljeno >= potrebno) { conn.rollback(); return; }

            stmtPostoji.setString(1, kor_ime);
            stmtPostoji.setInt(2, idA);
            ResultSet rsPostoji = stmtPostoji.executeQuery();
            if (rsPostoji.next()) { conn.rollback(); return; }

            stmtInsert.setString(1, kor_ime);
            stmtInsert.setInt(2, idA);
            stmtInsert.setString(3, "neodobren");
            int insertRes = stmtInsert.executeUpdate();
            if (insertRes != 1) { conn.rollback(); return; }

            conn.commit();
        }
    } catch (SQLException e) {
        e.printStackTrace();
        if (conn != null) {
            try { conn.rollback(); } catch (SQLException ex) { ex.printStackTrace(); }
        }
    } finally {
        if (conn != null) {
            try {
                conn.setAutoCommit(true);
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

public List<PrijavljeniVolonter> prijavljeni(int idA) {

    List<PrijavljeniVolonter> res = new ArrayList<>();

    try (Connection conn = DB.source().getConnection();
         PreparedStatement stmt = conn.prepareStatement(
             "select k.kor_ime, k.ime, k.prezime, p.status " +
             "from korisnici k join prijave p on k.kor_ime = p.volonter " +
             "where p.aktivnost = ?")) {

        stmt.setInt(1, idA);

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {

            PrijavljeniVolonter k = new PrijavljeniVolonter(
                    rs.getString("kor_ime"),
                    rs.getString("ime"),
                    rs.getString("prezime"),
                    rs.getString("status")
            );

            res.add(k);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return res;
}

public void odobri(String kor_ime, int idA) {
    Connection conn = null;

    try {
        conn = DB.source().getConnection();
        conn.setAutoCommit(false);

        try (PreparedStatement stmtStatus = conn
                .prepareStatement("select status from prijave where volonter = ? and aktivnost = ?");
             PreparedStatement stmtAktivnost = conn
                .prepareStatement("select potrebno, prijavljeno from aktivnosti where idA = ?");
             PreparedStatement stmtOdobri = conn
                .prepareStatement("update prijave set status = 'odobren' where volonter = ? and aktivnost = ? and lower(status) in ('neodobren','prijavljen')");
             PreparedStatement stmtUpdateBroj = conn
                .prepareStatement("update aktivnosti set prijavljeno = prijavljeno + 1 where idA = ?")) {

            stmtStatus.setString(1, kor_ime);
            stmtStatus.setInt(2, idA);
            ResultSet rsStatus = stmtStatus.executeQuery();
            if (!rsStatus.next()) { conn.rollback(); return; }

            String status = rsStatus.getString("status");
            if (status == null) { conn.rollback(); return; }
            String statusLc = status.toLowerCase();
            if (!"neodobren".equals(statusLc) && !"prijavljen".equals(statusLc)) { conn.rollback(); return; }

            stmtAktivnost.setInt(1, idA);
            ResultSet rsAkt = stmtAktivnost.executeQuery();
            if (!rsAkt.next()) { conn.rollback(); return; }

            int potrebno = rsAkt.getInt("potrebno");
            int prijavljeno = rsAkt.getInt("prijavljeno");
            if (prijavljeno >= potrebno) { conn.rollback(); return; }

            stmtOdobri.setString(1, kor_ime);
            stmtOdobri.setInt(2, idA);
            int odobriRes = stmtOdobri.executeUpdate();
            if (odobriRes != 1) { conn.rollback(); return; }

            stmtUpdateBroj.setInt(1, idA);
            int updateRes = stmtUpdateBroj.executeUpdate();
            if (updateRes != 1) { conn.rollback(); return; }

            conn.commit();
        }
    } catch (SQLException e) {
        e.printStackTrace();
        if (conn != null) {
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    } finally {
        if (conn != null) {
            try {
                conn.setAutoCommit(true);
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

public void povecaj(int idA) {
    Connection conn = null;
    try {
        conn = DB.source().getConnection();
        conn.setAutoCommit(false);

        try (PreparedStatement stmt = conn.prepareStatement("update aktivnosti set potrebno = potrebno + 5 where idA = ?")) {
            stmt.setInt(1, idA);
            stmt.executeUpdate();
            conn.commit();
        }
    } catch (SQLException e) {
        e.printStackTrace();
        if (conn != null) {
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    } finally {
        if (conn != null) {
            try {
                conn.setAutoCommit(true);
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

public void dodajAktivnost(Aktivnost aktivnost) {
    try (Connection conn = DB.source().getConnection();
                PreparedStatement stmtInsert = conn
                        .prepareStatement("insert into aktivnosti (idA, naziv, datum, potrebno, prijavljeno) values ((select ifnull(max(idA), 0) + 1 from aktivnosti), ?, ?, ?, ?)");
){
            stmtInsert.setString(1, aktivnost.getNaziv());
            stmtInsert.setString(2, aktivnost.getDatum());
            stmtInsert.setInt(3, aktivnost.getPotrebno());
            stmtInsert.setInt(4, 0);

            int insertRes = stmtInsert.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }


}

}
