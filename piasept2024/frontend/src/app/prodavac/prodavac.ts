import { Component, inject } from '@angular/core';
import { Logout } from '../logout/logout';
import { Router } from '@angular/router';
import { Korisnik, Aukcija } from '../models/models';
import { Servis } from '../servis';

@Component({
  selector: 'app-prodavac',
  imports: [Logout],
  templateUrl: './prodavac.html',
  styleUrl: './prodavac.css',
})
export class Prodavac {
ulogovan: Korisnik = new Korisnik();
  aktivneAukcije: Aukcija[] = [];
  private router = inject(Router)
  private servis = inject(Servis)

  ngOnInit(): void {
    let x = localStorage.getItem("ulogovan");
    if (x != null) {
      this.ulogovan = JSON.parse(x);

      this.servis.aktuelneAukcije().subscribe(data => {
        this.aktivneAukcije = data;
      });
    }
  }
  jeIstekla(kraj: string): boolean {
  return new Date(kraj) < new Date();
}

}
