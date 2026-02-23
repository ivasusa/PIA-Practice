import { Component, inject } from '@angular/core';
import { Logout } from "../logout/logout";
import { Aktivnost, Korisnik } from '../models/models';
import { Servis } from '../servis';
import { Router } from '@angular/router';

@Component({
  selector: 'app-organizator',
  imports: [Logout],
  templateUrl: './organizator.html',
  styleUrl: './organizator.css',
})
export class Organizator {
ulogovan: Korisnik = new Korisnik();
  aktuelneAktivnosti: Aktivnost[] = [];
  aktivnost: Aktivnost = new Aktivnost();
  private router = inject(Router)

  private servis = inject(Servis)

  ngOnInit(): void {
    let ulogovanLS = localStorage.getItem('ulogovan');
    if (ulogovanLS != null) {
      this.ulogovan = JSON.parse(ulogovanLS);

      this.servis.aktuelneAktivnosti().subscribe(data => {
        this.aktuelneAktivnosti = data;
      });
    }
  }

  prijavi(aktivnost: Aktivnost) {
    localStorage.setItem("detAkt", JSON.stringify(aktivnost));
    this.router.navigate(['/detalji', aktivnost.idA]);
  }
}
