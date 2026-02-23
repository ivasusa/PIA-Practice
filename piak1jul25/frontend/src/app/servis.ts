import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { Komentar, Korisnik, Proizvod } from './models/models';

@Injectable({
  providedIn: 'root',
})
export class Servis {
  constructor() {}

  url = 'http://localhost:8080/oprema';

  http = inject(HttpClient);

  prijava(username: string, password: string, tip: string) {
    const data = {
      kor_ime: username,
      lozinka: password,
      tip: tip,
    };
    return this.http.post<Korisnik>(`${this.url}/prijava`, data);
  }

  proizvodi() {
    return this.http.get<Proizvod[]>(`${this.url}/proizvodi`);
  }

  komentari(idP: number) {
    return this.http.get<Komentar[]>(`${this.url}/komentari/${idP}`);
  }
  komentariNeodobreni()
  {
    return this.http.get<Komentar[]>(`${this.url}/komentari/neodobreni`);
  }

  kupi(idP: number, ime: string) {
    const data = {
      proizvod: idP,
      kupac: ime,
      kolicina: 1,
    };
    return this.http.post(`${this.url}/kupi`, data);
  }
   komentarisi(tekst: string, proizvod: number, korisnik: string) {
    const data = {
      tekst: tekst,
      proizvod: proizvod,
      korisnik: korisnik,
    };
    return this.http.post(`${this.url}/komentarisi`, data);
  }
  odobri(komentar: Komentar) {
    return this.http.put(`${this.url}/odobri`, komentar);
  }
  odbaci(komentar: Komentar) {
    return this.http.put(`${this.url}/odbaci`, komentar);  
  }
}
