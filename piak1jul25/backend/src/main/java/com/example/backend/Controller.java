package com.example.backend;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.models.Komentar;
import com.example.backend.models.Korisnik;
import com.example.backend.models.Narudzbina;
import com.example.backend.models.Proizvod;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/oprema")
@CrossOrigin(origins = "http://localhost:4200")
public class Controller {

    @PostMapping("/prijava")
    public Korisnik prijava(@RequestBody Korisnik korisnik) {
        return new Repo().prijava(korisnik);
    }

    @GetMapping("/proizvodi")
    public List<Proizvod> dohvatiProizvode() {
        return new Repo().dohvatiProizvode();
    }

    @GetMapping("/komentari/{idP}")
    public List<Komentar> dohvatiKomentare(@PathVariable int idP) {
        return new Repo().dohvatiKomentare(idP);
    }
     
     @GetMapping("/komentari/neodobreni")
    public List<Komentar> dohvatiNeodobreneKomentare() {
        return new Repo().dohvatiNeodobreneKomentare();
    }

    @PostMapping("/kupi")
    public void kupi(@RequestBody Narudzbina narudzbina) {
        new Repo().kupi(narudzbina.getProizvod(), narudzbina.getKupac());
    }

    @PostMapping("/komentarisi")
    public void komentarisi(@RequestBody Komentar komentar) {
        new Repo().komentarisi(komentar);
    }

    @PutMapping("/odobri")
    public void odobri(@RequestBody Komentar komentar) {
        new Repo().odobri(komentar);

    }

    @PutMapping("/odbaci")
    public void odbaci(@RequestBody Komentar komentar) {
        new Repo().odbaci(komentar);
    }


}