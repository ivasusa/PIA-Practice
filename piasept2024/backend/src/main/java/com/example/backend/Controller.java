package com.example.backend;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.models.Aukcija;
import com.example.backend.models.Korisnik;
import com.example.backend.models.Umetnina;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/aukcije")
@CrossOrigin(origins = "http://localhost:4200")
public class Controller {

    @PostMapping("/prijava")
    public Korisnik prijava(@RequestBody Korisnik korisnik) {
        return new Repo().prijava(korisnik);
    }

    @GetMapping("/aukcije")
    public List<Aukcija> dohvatiAktuelneAukcije() {
        return new Repo().dohvatiAktuelneAukcije();
    }

    @GetMapping("/umetnine/{idAkt}")
    public List<Umetnina> dohvatiUmetnine(@PathVariable int idAkt) {
        return new Repo().dohvatiUmetnine(idAkt);
    }

    /* unesiPonudu(idU: number, ponuda: number, korisnik: string) {
  return this.http.post(`${this.url}/ponuda`, {
    idU: idU,
    ponuda: ponuda,
    korisnik: korisnik
  });*/

  @PutMapping("/ponuda/{idU}/{ponuda}/{korisnik}")
  public void unesiPonudu(@PathVariable int idU, @PathVariable int ponuda, @PathVariable String korisnik) {
    new Repo().unesiPonudu(idU, ponuda, korisnik); }

    //    return this.http.get<Umetnina[]>(`${this.url}/mojeumetnine/${korisnicko_ime}`);
    @GetMapping("/mojeumetnine/{korisnicko_ime}")
    public List<Umetnina> mojeUmetnine(@PathVariable String korisnicko_ime) {
        return new Repo().mojeUmetnine(korisnicko_ime); }
}
