import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { Aktivnost, Korisnik, PrijavljeniVolonter } from './models/models';

@Injectable({
  providedIn: 'root',
})
export class Servis {
  
   constructor() { }

  url = 'http://localhost:8080/grad';

  http = inject(HttpClient)

  prijava(username: string, password: string, tip: string) {
    const data = {
      kor_ime: username,
      lozinka: password,
      tip: tip,
    };
    return this.http.post<Korisnik>(`${this.url}/prijava`, data);
  }

   aktuelneAktivnosti() {
    return this.http.get<Aktivnost[]>(`${this.url}/aktuelne`);
  }
  
  postojiPrijava(kor_ime: string, id: any) {
    return this.http.get<boolean>(`${this.url}/postojiPrijava?kor_ime=${kor_ime}&idA=${id}`);
  }
  prijavi(kor_ime: string, idA: number) {
    return this.http.post(`${this.url}/prijavi?kor_ime=${kor_ime}&idA=${idA}`, {});
  }
  prijavljeni(idA: number) {
    return this.http.get<PrijavljeniVolonter[]>(`${this.url}/prijavljeni/${idA}`);
  }
  povecaj(idA: number) {
    return this.http.put(`${this.url}/povecaj/${idA}`, {});
  }

  odobri(kor_ime: string, idA: number) {
    return this.http.post(`${this.url}/odobri?kor_ime=${kor_ime}&idA=${idA}`, {});
  }
    dodajAktivnost(aktivnost: Aktivnost) {
    return this.http.post(`${this.url}/dodajAktivnost`, aktivnost);}
}
