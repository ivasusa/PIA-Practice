package com.example.backend;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;


import com.example.backend.models.Korisnik;
import com.example.backend.models.Proizvod;

@RestController
@RequestMapping("/bozic")
@CrossOrigin(origins = "http://localhost:4200")
public class Controller {

    @PostMapping("/prijava")
    public Korisnik prijava(@RequestBody Korisnik korisnik) {
        return new Repo().prijava(korisnik);
    }
    //sviProizvodi
    @GetMapping("/naslovna")
    public List<Proizvod> sviProizvodi() {
        return new Repo().sviProizvodi();
    }


@GetMapping("/detalji/{naziv}")
public Proizvod detaljiProizvod(@PathVariable String naziv) {
    return new Repo().detaljiProizvod(naziv);
}

@PostMapping("/promeniStatus/{naziv}")
public boolean izmeniProizvod(@PathVariable String naziv, @RequestBody Proizvod p) {
    p.setNaziv(naziv);
    return new Repo().izmeni(p);
}

}
