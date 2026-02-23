import { Component, inject } from '@angular/core';
import { Servis } from '../servis';
import { Router } from '@angular/router';
import { Korisnik, Proizvod } from '../models/models';
import { Logout } from "../logout/logout";

@Component({
  selector: 'app-kupac',
  imports: [Logout],
  templateUrl: './kupac.html',
  styleUrl: './kupac.css',
})
export class Kupac {

ulogovan: Korisnik = new Korisnik();
  proizvodi: Proizvod[] = [];

  private router = inject(Router)
  private servis = inject(Servis)

  ngOnInit(): void {
    let x = localStorage.getItem("ulogovan");
    if (x != null) {
      this.ulogovan = JSON.parse(x);
      this.servis.proizvodi().subscribe(data => {
        this.proizvodi = data;
      });
    }
  }

  detalji(p: Proizvod) {
    localStorage.setItem('proizvod', JSON.stringify(p));
    this.router.navigate(['/proizvod', p.idP]);

  }
}
