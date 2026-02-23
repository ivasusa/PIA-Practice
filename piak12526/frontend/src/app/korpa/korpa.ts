import { Component, inject } from '@angular/core';
import { Service } from '../service';
import { Router } from '@angular/router';
import { Korisnik, Proizvod } from '../models/Modeli';

@Component({
  selector: 'app-korpa',
  imports: [],
  templateUrl: './korpa.html',
  styleUrl: './korpa.css',
})
export class Korpa {
ulogovan: Korisnik = new Korisnik();
  proizvodi: Proizvod[] = [];

  private router = inject(Router)
  private servis = inject(Service)

  ngOnInit(): void {
    const ulogovan = localStorage.getItem('ulogovan');
    if (ulogovan) {
      this.ulogovan = JSON.parse(ulogovan);
    }
    
      
        this.proizvodi = localStorage.getItem('korpa') ? JSON.parse(localStorage.getItem('korpa')!) : [];

    }
}
