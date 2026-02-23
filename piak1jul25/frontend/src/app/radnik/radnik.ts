import { Component, inject } from '@angular/core';
import { Logout } from "../logout/logout";
import { Router } from '@angular/router';
import { Korisnik, Komentar, Proizvod } from '../models/models';
import { Servis } from '../servis';

@Component({
  selector: 'app-radnik',
  imports: [Logout],
  templateUrl: './radnik.html',
  styleUrl: './radnik.css',
})
export class Radnik {
odobri(komentar: Komentar) {
    komentar.status = 'odobren';
    this.servis.odobri(komentar).subscribe(data => {
      if (data)
        this.ucitajKomentare();
    });
  }

odbaci(komentar: Komentar) {
    komentar.status = 'odbijen';
    this.servis.odbaci(komentar).subscribe(data => {
      if (data)
       this.ucitajKomentare();
    });
  
}
ucitajKomentare() {
  this.servis.komentariNeodobreni().subscribe(data => {
    this.komentari = data;
  });
}
  ulogovan: Korisnik = new Korisnik();
  tekst: string = '';

  komentari: Komentar[] = [];

  private router = inject(Router);
  private servis = inject(Servis);

  ngOnInit(): void {
    let x = localStorage.getItem('ulogovan');
    if (x != null) {
      this.ulogovan = JSON.parse(x);
      this.servis.komentariNeodobreni().subscribe((data) => {
        this.komentari = data;
      });
    }
  }

  
}
