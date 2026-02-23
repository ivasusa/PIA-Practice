import { Component, inject } from '@angular/core';
import { Komentar, Korisnik, Proizvod } from '../models/models';
import { Router } from '@angular/router';
import { Servis } from '../servis';
import { Logout } from '../logout/logout';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-proizvod',
  imports: [Logout, FormsModule],
  templateUrl: './proizvod.html',
  styleUrl: './proizvod.css',
})
export class Proizvodi {
  proizvod: Proizvod = new Proizvod();
  ulogovan: Korisnik = new Korisnik();
  tekst: string = '';

  komentari: Komentar[] = [];

  private router = inject(Router);
  private servis = inject(Servis);

  ngOnInit(): void {
    let x = localStorage.getItem('ulogovan');
    if (x != null) {
      this.ulogovan = JSON.parse(x);
      this.proizvod = JSON.parse(localStorage.getItem('proizvod') || '{}');
      this.servis.komentari(this.proizvod.idP).subscribe((data) => {
        this.komentari = data;
      });
    }
  }

  kupi(p: Proizvod) {
    this.servis.kupi(this.proizvod.idP, this.ulogovan.kor_ime).subscribe({
      next: () => {
        alert('Kupovina je uspešna.');
      },
      error: () => {
        alert('Kupovina nije uspela.');
      },
    });
  }

  //   komentarisi(tekst: string, proizvod: number, korisnik: string) {
  komentarisi(tekst: string) {
    this.servis
      .komentarisi(tekst, this.proizvod.idP, this.ulogovan.kor_ime)
      .subscribe({
        next: () => {
          alert('Komentar je uspešno dodat.');
          this.tekst = '';
        },
        error: () => {
          alert('Komentar nije dodat.');
        },
      });
  }
}
