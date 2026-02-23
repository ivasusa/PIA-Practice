import { Component, inject } from '@angular/core';
import { Servis } from '../servis';
import { Aukcija, Korisnik, Umetnina } from '../models/models';
import { Router } from '@angular/router';
import { Logout } from '../logout/logout';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-detalji',
  imports: [Logout, FormsModule],
  templateUrl: './detalji.html',
  styleUrl: './detalji.css',
})
export class Detalji {
ulogovan: Korisnik = new Korisnik();
aukcija: Aukcija = new Aukcija();
  umetnine: Umetnina[] = [];
  private router = inject(Router)
  private servis = inject(Servis)
novaPonuda: number = 0;
greska: string = "";

ngOnInit(): void {
    let x = localStorage.getItem("ulogovan");
    if (x != null) {
      this.ulogovan = JSON.parse(x);
      this.aukcija = JSON.parse(localStorage.getItem("selektovanaAukcija") || '{}');
      this.servis.dohvatiUmetnine(this.aukcija.idA).subscribe(data => {
        this.umetnine = data;
      });
    }
  }
  unesiPonudu(a: Umetnina) {
      if (a.novaPonuda <= a.ponuda) {
        this.greska = "Nova ponuda mora biti veca od trenutne ponude";
        return;
      }
      this.greska = "";
     this.servis.unesiPonudu(a.idU, a.novaPonuda, this.ulogovan.korisnicko_ime).subscribe(data => {
      this.ngOnInit();
    });
  }
}
