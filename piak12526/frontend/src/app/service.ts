import { inject, Injectable } from '@angular/core';
import { Korisnik, Proizvod } from './models/Modeli';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root',
})
export class Service {
 

  izmeniProizvod(p: Proizvod) {
        return this.http.post<boolean>(`${this.url}/promeniStatus/${p.naziv}`, p);

  }
 
  url = 'http://localhost:8080/bozic';

  http = inject(HttpClient)

    constructor() { }

  prijava(kor_ime: string, lozinka: string, tip: string) {
    const data = {
      kor_ime: kor_ime,
      lozinka: lozinka,
      tip: tip,
    };
    return this.http.post<Korisnik>(`${this.url}/prijava`, data);
  }

  sviProizvodi() {
    return this.http.get<Proizvod[]>(`${this.url}/naslovna`);
  }

  detaljProizvod(naziv: string) {
    return this.http.get<Proizvod>(`${this.url}/detalji/${encodeURIComponent(naziv)}`);
  }

  
}
