import { Component, inject } from '@angular/core';
import { Korisnik, Proizvod } from '../models/Modeli';
import { Router } from '@angular/router';
import { Service } from '../service';

@Component({
  selector: 'app-naslovna',
  imports: [],
  templateUrl: './naslovna.html',
  styleUrl: './naslovna.css',
})
export class Naslovna {
ulogovan: Korisnik = new Korisnik();
  proizvodi: Proizvod[] = [];

  private router = inject(Router)
  private servis = inject(Service)

  ngOnInit(): void {
    const ulogovan = localStorage.getItem('ulogovan');
    if (ulogovan) {
      this.ulogovan = JSON.parse(ulogovan);
    }
    
      this.servis.sviProizvodi().subscribe(data => {
        this.proizvodi = data;
      });
    }

  naslovna(proizvod: Proizvod) {
    localStorage.setItem('izabranProizvodNaziv', proizvod.naziv);
    let ulogovanLS = localStorage.getItem('ulogovan');
    if (ulogovanLS != null) {
      this.router.navigate(['/detalji', proizvod.naziv]);
      return;
    }

    this.router.navigate(['/prijava']);
  }

  }
