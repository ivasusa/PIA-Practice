import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { Dodatak, Korisnik, Narudzbina, Pica } from './models/models';

@Injectable({
  providedIn: 'root',
})
export class Servis {
 
 

   constructor() { }

  url = 'http://localhost:8080/picerija';

  http = inject(HttpClient)

  prijava(username: string, password: string, tip: string) {
    const data = {
      korisnicko_ime: username,
      lozinka: password,
      tip: tip,
    };
    return this.http.post<Korisnik>(`${this.url}/prijava`, data);
  }
   dohvatiPice() {
    return this.http.get<Pica[]>(`${this.url}/pice`);
  }

  mojeNarudzbine(username: string) {
    return this.http.get<Narudzbina[]>(`${this.url}/moje/${username}`);
  }
  sveNarudzbine() {
    return this.http.get<Narudzbina[]>(`${this.url}/narudzbine`);
  }
    dohvatiDodatke() {
        return this.http.get<Dodatak[]>(`${this.url}/dodaci`);
    }


      prihvati(narudzbina: Narudzbina) {
    return this.http.put<boolean>(`${this.url}/prihvati`, narudzbina);
  }
  odbij(narudzbina: Narudzbina) {
    return this.http.put<boolean>(`${this.url}/odbij`, narudzbina);
  }
   gotovo(kupac: string, pica: string, velicina: string, dodaci: String,cena: number) {
    const data = {
      kupac: kupac,
      pica: pica,
      dodaci: dodaci,
      velicina: velicina,
      cena: cena
    };
    return this.http.post<boolean>(`${this.url}/gotovo`, data);
  }
   dostupi(d: Dodatak) {
    return this.http.put<boolean>(`${this.url}/dostupno`, d);
  }
  nedostupi(d: Dodatak) {
    return this.http.put<boolean>(`${this.url}/nedostupno`, d);
  }
}
