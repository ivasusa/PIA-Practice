import { Component, inject } from '@angular/core';
import { Aktivnost, PrijavljeniVolonter } from '../models/models';
import { Servis } from '../servis';
import { Logout } from "../logout/logout";
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-detalji',
  imports: [Logout,FormsModule],
  templateUrl: './detalji.html',
  styleUrl: './detalji.css',
})
export class Detalji {
  naziv: string = '';
  datum: string = '';
  brojPotrebnih: number = 0;
  porukaDodavanje: string = '';

povecaj() {
  this.servis.povecaj(this.aktivnost.idA).subscribe(() => {
    this.osveziAktivnost();
  });
}
  aktivnost: Aktivnost = new Aktivnost();
  prijavljeni: PrijavljeniVolonter[] = [];

  private servis = inject(Servis)

  ucitajPrijavljene() {
    this.servis.prijavljeni(this.aktivnost.idA).subscribe(data => {
      this.prijavljeni = data;
    });
  }

  osveziAktivnost() {
    this.servis.aktuelneAktivnosti().subscribe(data => {
      const found = data.find(a => a.idA === this.aktivnost.idA);
      if (found) {
        this.aktivnost = found;
        localStorage.setItem("detAkt", JSON.stringify(found));
      }
    });
  }

  odobri(kor_ime: string) {
    this.servis.odobri(kor_ime, this.aktivnost.idA).subscribe(() => {
      this.ucitajPrijavljene();
      this.osveziAktivnost();
    });
  }

  dodajAktivnost() {
    this.porukaDodavanje = '';

    if (!this.naziv || !this.datum || this.brojPotrebnih <= 0) {
      this.porukaDodavanje = 'Popunite naziv, datum i broj potrebnih.';
      return;
    }

    const nova = new Aktivnost();
    nova.naziv = this.naziv;
    nova.datum = this.datum;
    nova.potrebno = this.brojPotrebnih;
    nova.prijavljeno = 0;

    this.servis.dodajAktivnost(nova).subscribe(() => {
      this.porukaDodavanje = 'Aktivnost je uspesno dodata.';
      this.naziv = '';
      this.datum = '';
      this.brojPotrebnih = 0;
    }, () => {
      this.porukaDodavanje = 'Greska pri dodavanju aktivnosti.';
    });
  }


  ngOnInit(): void {
    let ulogovanLS = localStorage.getItem('ulogovan');
    if (ulogovanLS != null) {
      this.aktivnost=JSON.parse(localStorage.getItem("detAkt") || '{}');
    }
    this.ucitajPrijavljene();
  }
}
