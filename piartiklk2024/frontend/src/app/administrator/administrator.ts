import { Component, inject } from '@angular/core';
import { Router } from '@angular/router';
import { Dodatak, Korisnik, Narudzbina, Pica } from '../models/models';
import { Servis } from '../servis';
import { Logout } from "../logout/logout";
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-administrator',
  imports: [Logout,FormsModule],
  templateUrl: './administrator.html',
  styleUrl: './administrator.css',
})
export class Administrator {


//sveNarudzbine
ulogovan: Korisnik = new Korisnik();
  narudzbine: Narudzbina[] = [];
  private router = inject(Router)
  private servis = inject(Servis)
    dodaci:Dodatak[] = [];
    dostupni:Dodatak[] = [];
    nedostupni:Dodatak[] = [];

  

  ngOnInit(): void {
    let x = localStorage.getItem("ulogovan");
    if (x != null) {
      this.ulogovan = JSON.parse(x);

      this.servis.sveNarudzbine().subscribe(data => {
        this.narudzbine = data;
      });
            this.servis.dohvatiDodatke().subscribe(d => this.dodaci = d);

      
    }
  }


  odbij(narudzbina: Narudzbina) {
  this.servis.odbij(narudzbina).subscribe(data => {
    if (data)
      this.ucitaj();
  });
  }
prihvati(narudzbina: Narudzbina) {
  this.servis.prihvati(narudzbina).subscribe(data => {
    if (data)
      this.ucitaj();
  });
}
 ucitaj() {
  this.servis.sveNarudzbine().subscribe(data => {
        this.narudzbine = data;
      });
}

azuriraj() {
  const dostupni = this.dodaci.filter(a => a.dostupan);
  const nedostupni = this.dodaci.filter(a => !a.dostupan);
  for (let d of dostupni) {
    this.servis.dostupi(d).subscribe();
  }
  for (let d of nedostupni) {
    this.servis.nedostupi(d).subscribe();
  }
}
}

