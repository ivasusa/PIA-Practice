import { Component, inject } from '@angular/core';
import { Logout } from '../logout/logout';
import { Router } from '@angular/router';
import { Korisnik, Narudzbina, Pica } from '../models/models';
import { Servis } from '../servis';

@Component({
  selector: 'app-kupac',
  imports: [Logout],
  templateUrl: './kupac.html',
  styleUrl: './kupac.css',
})
export class Kupac {

ulogovan: Korisnik = new Korisnik();
  narudzbine: Narudzbina[] = [];
  pice: Pica[] = [];
  private router = inject(Router)
  private servis = inject(Servis)

  ngOnInit(): void {
    let x = localStorage.getItem("ulogovan");
    if (x != null) {
      this.ulogovan = JSON.parse(x);

      this.servis.mojeNarudzbine(this.ulogovan.korisnicko_ime).subscribe(data => {
        this.narudzbine = data;
      });
      this.servis.dohvatiPice().subscribe(data => {
        this.pice = data;
      });
    }
  }

  naruci(pica: Pica) {
    localStorage.setItem("selektovana", JSON.stringify(pica));
    this.router.navigate(['/detalji', pica.naziv]);
}
}
