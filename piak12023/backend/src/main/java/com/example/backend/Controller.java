package com.example.backend;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.models.Korisnici;

@RestController
@RequestMapping("/prijave")
@CrossOrigin(origins = "http://localhost:4200")
public class Controller {

    @PostMapping("/prijava")
    public Korisnici prijava(@RequestBody Korisnici korisnik) {
        return new Repo().prijava(korisnik);
    }
}