package com.example.backend;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.backend.models.Aktivnost;
import com.example.backend.models.Korisnik;
import com.example.backend.models.PrijavljeniVolonter;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/grad")
@CrossOrigin(origins = "http://localhost:4200")
public class Controller {

    @PostMapping("/prijava")
    public Korisnik prijava(@RequestBody Korisnik korisnik) {
        return new Repo().prijava(korisnik);
    }
    @GetMapping("/aktuelne")
    public List<Aktivnost> dohvatiAktuelneAktivnosti() {
        return new Repo().dohvatiAktuelneAktivnosti();
    }
 @GetMapping("/postojiPrijava")
 public boolean postojiPrijava(@RequestParam String kor_ime, @RequestParam int idA) {
     return new Repo().postojiPrijava(kor_ime, idA);
 }
    @PostMapping("/prijavi")     
    public void prijavi(@RequestParam String kor_ime, @RequestParam int idA) {
        new Repo().prijavi(kor_ime, idA);
    }


    @GetMapping("/prijavljeni/{idA}")
    public List<PrijavljeniVolonter> prijavljeni(@PathVariable int idA) {
        return new Repo().prijavljeni(idA); }

    @PostMapping("/odobri")
    public void odobri(@RequestParam String kor_ime, @RequestParam int idA) {
        new Repo().odobri(kor_ime, idA);
    }
    
    @PutMapping("/povecaj/{idA}")
    public void povecaj(@PathVariable int idA) {
        new Repo().povecaj(idA);        }

    @PostMapping("/dodajAktivnost")
    public void dodajAktivnost(@RequestBody Aktivnost aktivnost) {
        new Repo().dodajAktivnost(aktivnost);
    }
 
}
