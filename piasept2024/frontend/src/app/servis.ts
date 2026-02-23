import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { Aukcija, Korisnik, Umetnina } from './models/models';

@Injectable({
  providedIn: 'root',
})
export class Servis {
 

  constructor() { }

  url = 'http://localhost:8080/aukcije';

  http = inject(HttpClient)

  prijava(username: string, password: string, tip: string) {
    const data = {
      korisnicko_ime: username,
      lozinka: password,
      tip: tip,
    };
    return this.http.post<Korisnik>(`${this.url}/prijava`, data);
  }

    aktuelneAukcije() {
    return this.http.get<Aukcija[]>(`${this.url}/aukcije`);
  }
   dohvatiUmetnine(idA: number) {
    return this.http.get<Umetnina[]>(`${this.url}/umetnine/${idA}`);
  }

   mojeUmetnine(korisnicko_ime: string) {
    return this.http.get<Umetnina[]>(`${this.url}/mojeumetnine/${korisnicko_ime}`);
  }
  unesiPonudu(idU: number, ponuda: number, korisnik: string) {
  return this.http.put(`${this.url}/ponuda/${idU}/${ponuda}/${korisnik}`,{});}

}
