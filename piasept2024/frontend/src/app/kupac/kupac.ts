import { Component, inject } from '@angular/core';
import { Aukcija, Korisnik, Umetnina } from '../models/models';
import { Logout } from '../logout/logout';
import { Servis } from '../servis';
import { Router } from '@angular/router';

@Component({
  selector: 'app-kupac',
  imports: [Logout],
  templateUrl: './kupac.html',
  styleUrl: './kupac.css',
})
export class Kupac {
ulogovan: Korisnik = new Korisnik();
  aktivneAukcije: Aukcija[] = [];
  mojeumetnine: Umetnina[] = [];
  private router = inject(Router)
  private servis = inject(Servis)

  ngOnInit(): void {
    let x = localStorage.getItem("ulogovan");
    if (x != null) {
      this.ulogovan = JSON.parse(x);

      this.servis.aktuelneAukcije().subscribe(data => {
        this.aktivneAukcije = data;
      });
      this.servis.mojeUmetnine(this.ulogovan.korisnicko_ime).subscribe(data => {
        this.mojeumetnine = data;
      });
    }
  }

  pogledaj(aukcija: Aukcija) {
    localStorage.setItem("selektovanaAukcija", JSON.stringify(aukcija));
    this.router.navigate(['/detalji', aukcija.idA]);
  }
}
