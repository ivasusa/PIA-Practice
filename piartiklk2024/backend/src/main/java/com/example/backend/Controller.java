package com.example.backend;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.models.Dodatak;
import com.example.backend.models.Korisnik;
import com.example.backend.models.Narudzbina;
import com.example.backend.models.Pica;

@RestController
@RequestMapping("/picerija")
@CrossOrigin(origins = "http://localhost:4200")
public class Controller {

    @PostMapping("/prijava")
    public Korisnik prijava(@RequestBody Korisnik korisnik) {
        return new Repo().prijava(korisnik);
    }

    
    @GetMapping("/pice")
    public List<Pica> dohvatiPice() {
        return new Repo().dohvatiPice();
    }

    @GetMapping("/moje/{username}")
    public List<Narudzbina> mojeNarudzbine(@PathVariable String username) {
        return new Repo().dohvatiMojeNarudzbine(username);
    }
     @GetMapping("/narudzbine")
    public List<Narudzbina> sveNarudzbine() {
         return new Repo().dohvatiSveNarudzbine();
    }
     @GetMapping("/dodaci")
    public List<Dodatak> sveDodatke() {
         return new Repo().dohvatiSveDodatke();
    }

    @PutMapping("/prihvati")
    public boolean prihvati(@RequestBody Narudzbina narudzbina) {
        return new Repo().prihvati(narudzbina);}

    @PutMapping("/odbij")
    public boolean odbij(@RequestBody Narudzbina narudzbina) {
        return new Repo().odbij(narudzbina);}

 @PostMapping("/gotovo")
    public boolean gotovo(@RequestBody Narudzbina narudzbina) {
        return new Repo().gotovo(narudzbina);
    }

     @PutMapping("/dostupno")
    public boolean dostupno(@RequestBody Dodatak dodatak) {
        return new Repo().dostupno(dodatak);}

         @PutMapping("/nedostupno")
    public boolean nedostupno(@RequestBody Dodatak dodatak) {
        return new Repo().nedostupno(dodatak);}
}
