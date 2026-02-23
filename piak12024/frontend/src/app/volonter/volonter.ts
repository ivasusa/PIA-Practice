import { Component, inject } from '@angular/core';
import { Logout } from "../logout/logout";
import { Aktivnost, Korisnik } from '../models/models';
import { Servis } from '../servis';

@Component({
  selector: 'app-volonter',
  imports: [Logout],
  templateUrl: './volonter.html',
  styleUrl: './volonter.css',
})
export class Volonter {

ulogovan: Korisnik = new Korisnik();
aktuelneAktivnosti: Aktivnost[] = [];
  prijavljenPoAktivnosti: { [key: number]: boolean } = {};
  poruka: string = '';


  private servis = inject(Servis)

  prijavi(a: Aktivnost) {
    this.poruka = '';

    if (this.prijavljenPoAktivnosti[a.idA]) {
      this.poruka = 'Vec ste se prijavili za ovu aktivnost.';
      return;
    }

    this.servis.prijavi(this.ulogovan.kor_ime, a.idA).subscribe(() => {
      this.prijavljenPoAktivnosti[a.idA] = true;
      this.poruka = 'Uspesno ste prijavljeni. Status prijave: neodobren.';
      this.ucitajAktivnosti();
    });
  }

  ucitajAktivnosti() {
    this.servis.aktuelneAktivnosti().subscribe(data => {
      this.aktuelneAktivnosti = data;

      data.forEach(a => {
        this.servis.postojiPrijava(this.ulogovan.kor_ime, a.idA).subscribe(daLiPostoji => {
          this.prijavljenPoAktivnosti[a.idA] = daLiPostoji;
        });
      });
    });
  }

  ngOnInit(): void {
    let x = localStorage.getItem("ulogovan");
    if (x != null) {
      this.ulogovan = JSON.parse(x);
      this.ucitajAktivnosti();
    }

  }
}
