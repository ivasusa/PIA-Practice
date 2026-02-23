import { Component, inject } from '@angular/core';
import { Router } from '@angular/router';
import { Dodatak, Korisnik, Narudzbina, Pica } from '../models/models';
import { Servis } from '../servis';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-detalji',
  imports: [FormsModule],
  templateUrl: './detalji.html',
  styleUrl: './detalji.css',
})
export class Detalji {


ulogovan: Korisnik = new Korisnik();
  pica: Pica= new Pica();
  dodaci:Dodatak[] = [];
  noviDodaci: String ="";
  private router = inject(Router)
  private servis = inject(Servis)
    vrsta: string = "";
        poruka: string = "";
    cenaPice: number = 0;

nazad() {
  this.router.navigate(['/kupac']);
}

  ngOnInit(): void {
    let x = localStorage.getItem("ulogovan");
    if (x != null) {
      this.ulogovan = JSON.parse(x);
      this.pica = JSON.parse(localStorage.getItem("selektovana") || '{}');
      this.servis.dohvatiDodatke().subscribe(d => this.dodaci = d);
    }
  }



dodajDodatak(d: Dodatak) {
  this.noviDodaci += d.naziv + " ";

}
cena(){
  let cena = this.pica.cena;
  for (let d of this.dodaci) {
    if (this.noviDodaci.includes(d.naziv)) {
      cena += d.cena;
    }
  }
  if (this.vrsta == "mala") {
    cena += 0;
  } else if (this.vrsta == "srednja") {
    cena += 100;
  } else if (this.vrsta == "velika") {
    cena += 200;
  }
  return cena;

}
  gotovo() {
    this.cenaPice = this.cena();
     this.poruka = "Uspesno naruceno";
this.servis.gotovo(this.ulogovan.korisnicko_ime, this.pica.naziv, this.vrsta,this.noviDodaci, this.cena()).subscribe(data => {

      });
}
}
